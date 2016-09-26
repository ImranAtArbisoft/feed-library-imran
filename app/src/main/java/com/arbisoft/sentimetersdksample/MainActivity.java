package com.arbisoft.sentimetersdksample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.arbisoft.sentimetersdk.Sentimeter;

public class MainActivity extends AppCompatActivity {
    Sentimeter mSentimeter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSentimeter = new Sentimeter.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(R.mipmap.ic_launcher)
                .build();
    }

    public void onStartFeedback(View view) {
        mSentimeter.showFeedback();
    }
}
