package com.martinandersson.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.martinandersson.jokedisplayer.JokeDisplayActivity;

public class MainActivity extends AppCompatActivity implements EndpointsAsyncTask.EndpointsAsyncTaskCallback {
    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        setContentView(R.layout.activity_main);
    }

    public void tellJoke(View view) {
        Log.d(TAG, "tellJoke");
        new EndpointsAsyncTask(this).execute();
    }

    @Override
    public void onEndpointsAsyncTaskResult(String result) {
        Log.d(TAG, "onEndpointsAsyncTaskResult");
        Intent intent = new Intent(this, JokeDisplayActivity.class);
        intent.putExtra(JokeDisplayActivity.ARG_JOKE, result);
        startActivity(intent);
    }
}
