package com.martinandersson.builditbigger;

import android.test.AndroidTestCase;

import com.martinandersson.jokelibrary.Joker;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class BuildItBiggerAndroidTest extends AndroidTestCase implements EndpointsAsyncTask.EndpointsAsyncTaskCallback {

    public void testVerifyJoker() {

        Joker joker = new Joker();
        assertNotNull(joker);
        assertNotNull(joker.getJoke());
        assertTrue(joker.getJoke().startsWith("This is joke number"));

    }

    public void testVerifyEndpointsAsyncTask() {
        final CountDownLatch signal = new CountDownLatch(1);

        new EndpointsAsyncTask(this).execute();

        try {
            signal.await(20, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onEndpointsAsyncTaskResult(String result) {
        assertNotNull(result);
    }
}
