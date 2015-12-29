package com.martinandersson.builditbigger;

import android.os.AsyncTask;
import android.util.Log;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.martinandersson.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

/**
 * Created by martin.andersson on 12/28/15.
 */
public class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {
    public static final String TAG = EndpointsAsyncTask.class.getSimpleName();

    private static MyApi myApiService = null;
    private EndpointsAsyncTaskCallback mEndpointsAsyncTaskCallback;

    public interface EndpointsAsyncTaskCallback {
        void onEndpointsAsyncTaskResult(String result);
    }

    public EndpointsAsyncTask(EndpointsAsyncTaskCallback endpointsAsyncTaskCallback) {
        mEndpointsAsyncTaskCallback = endpointsAsyncTaskCallback;
    }

    @Override
    protected String doInBackground(Void... params) {

        if (myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://builditbigger-1173.appspot.com/_ah/api/");

//            builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
//                    new AndroidJsonFactory(), null)
//                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
//                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
//                        @Override
//                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
//                            abstractGoogleClientRequest.setDisableGZipContent(true);
//                        }
//                    });
            // end options for devappserver

            myApiService = builder.build();
        }

        try {
            return myApiService.getJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        Log.d(TAG, "onPostExecute: " + result);
        mEndpointsAsyncTaskCallback.onEndpointsAsyncTaskResult(result);
    }
}