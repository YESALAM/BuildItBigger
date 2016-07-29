package io.github.yesalam.builditbigger;

import android.app.Application;
import android.test.ApplicationTestCase;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by yesalam on 29-07-2016.
 */
public class AsyncTaskTest extends ApplicationTestCase<Application> {

    public AsyncTaskTest() {
        super(Application.class);
    }

    public void testAsyncTask() throws Throwable{
        final  String[] testresults = new String[1] ;
        final CountDownLatch signal=new CountDownLatch(1);

        EndpointAsyncTask asyncTask = new EndpointAsyncTask(){
            @Override
            protected void onPostExecute(String result) {
                //super.onPostExecute(result);
               testresults[0] = result ;
                signal.countDown();
            }
        };

        asyncTask.execute() ;
        signal.await(30, TimeUnit.SECONDS);
        assertFalse(testresults[0].equals(""));

    }
}
