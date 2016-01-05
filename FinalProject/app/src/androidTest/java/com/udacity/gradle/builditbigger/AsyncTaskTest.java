package com.udacity.gradle.builditbigger;

import android.test.InstrumentationTestCase;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class AsyncTaskTest extends InstrumentationTestCase {

    String joke;

    public final void testAsyncTask() throws Throwable{
        final CountDownLatch signal = new CountDownLatch(1);
        runTestOnUiThread(new Runnable() {
            @Override
            public void run() {
                new JokeAsyncTask() {
                    @Override
                    protected void onPostExecute(String response) {
                        super.onPostExecute(response);
                        joke = response;
                        signal.countDown();
                    }
                }.execute();
            }
        });
        signal.await(30, TimeUnit.SECONDS);
        assertNotNull(joke);
        assertEquals(false, "".equalsIgnoreCase(joke));
    }
}


