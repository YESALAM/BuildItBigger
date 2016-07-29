package io.github.yesalam.builditbigger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import io.github.yesalam.library.jokeactivity.JokeActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showJoke(String joke){
        Intent displayIntent = new Intent(getApplicationContext(), JokeActivity.class);
        displayIntent.putExtra(JokeActivity.JOKE_KEY, joke);
        startActivity(displayIntent);
    }

    public void tellJoke(View view) {
        /*String joke=new JokeTeller().getJoke();
        Toast.makeText(this, joke, Toast.LENGTH_SHORT).show();*/
        //when click the button ,if ad load,show the AD,if not yet,go to the joke show activity
        /*if (mInterstitialAd != null && mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {*/
            EndpointAsyncTask task = new EndpointAsyncTask(){
                @Override
                protected void onPostExecute(String result) {
                    super.onPostExecute(result);
                    showJoke(result);
                }
            };
            task.execute();
       // }

    }

}
