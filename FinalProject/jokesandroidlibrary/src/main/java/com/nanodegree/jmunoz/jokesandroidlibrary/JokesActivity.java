package com.nanodegree.jmunoz.jokesandroidlibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokesActivity extends AppCompatActivity {

    private TextView mJokesText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes);
        mJokesText = (TextView) findViewById(R.id.jokesText);
        String joke = getIntent().getStringExtra(Intent.EXTRA_TEXT);
        if(null != joke)
            mJokesText.setText(joke);
    }
}
