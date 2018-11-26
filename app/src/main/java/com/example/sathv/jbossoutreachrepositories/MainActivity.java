package com.example.sathv.jbossoutreachrepositories;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread thread = new Thread() {

            @Override
            public void run() {
                try {
                    //  pb.setVisibility(View.VISIBLE);
                    //1.5 seconds
                    sleep(1500);
                    //then start the next activity
                    Intent intent = new Intent(getApplicationContext(), RepositoriesActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }
}
