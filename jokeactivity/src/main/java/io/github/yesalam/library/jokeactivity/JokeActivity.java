package io.github.yesalam.library.jokeactivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by yesalam on 28-07-2016.
 */
public class JokeActivity extends AppCompatActivity{

    public static final String JOKE_KEY = "joke" ;

    private ImageView imageView ;
    private TextView textView ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jokeactivity);

        imageView = (ImageView) findViewById(R.id.imageView);
        textView = (TextView) findViewById(R.id.textView);

        imageView.setImageResource(R.drawable.smiley_medium);

        String joke = getIntent().getStringExtra(JOKE_KEY) ;
        textView.setText(joke);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
