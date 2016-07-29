package io.github.yesalam.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import io.github.yesalam.library.jokeactivity.JokeActivity;

/**
 * Created by yesalam on 29-07-2016.
 */
public class MainActivity extends AppCompatActivity {

    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //prepare the Interstitial  AD
        // Create the InterstitialAd and set the adUnitId.
        mInterstitialAd = new InterstitialAd(this);
        // Defined in res/values/strings.xml
        mInterstitialAd.setAdUnitId(getString(R.string.ad_unit_id));//ca-app-pub-3940256099942544/1033173712
//set the action after close,we want to open a new activity to show the joke
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                //do something here
                showJoke();

            }
        });

        //load the InterstitialAd
        if (!mInterstitialAd.isLoading() && !mInterstitialAd.isLoaded()) {
            AdRequest adRequest = new AdRequest.Builder().build();
            mInterstitialAd.loadAd(adRequest);
        }

    }

    public void showJoke(){
        EndpointAsyncTask task = new EndpointAsyncTask(){
            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);
                Intent displayIntent = new Intent(getApplicationContext(), JokeActivity.class);
                displayIntent.putExtra(JokeActivity.JOKE_KEY, result);
                startActivity(displayIntent);
            }
        };
        task.execute();

    }

    public void tellJoke(View view) {

        //when click the button ,if ad load,show the AD,if not yet,go to the joke show activity
        if (mInterstitialAd != null && mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            showJoke();
         }

    }


}
