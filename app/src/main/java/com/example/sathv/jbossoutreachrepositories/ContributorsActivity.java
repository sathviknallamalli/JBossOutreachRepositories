package com.example.sathv.jbossoutreachrepositories;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ContributorsActivity extends AppCompatActivity {

    String conturl;
    RecyclerView contrv;
    List<ContributeModel> contlist;
    SharedPreferences sharedp;
    ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contributors);

        conturl = getIntent().getExtras().getString("contributeurl");

        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle("Contributors");
        ab.setSubtitle("List of contributors for the repository");
        contlist = new ArrayList<>();
         sharedp = getSharedPreferences("nameinfo", Context.MODE_PRIVATE);

        try {
            run();
        } catch (IOException e) {
            e.printStackTrace();
        }

        pb = findViewById(R.id.pb);
        pb.setVisibility(View.VISIBLE);

        contrv = findViewById(R.id.contrv);
        contrv.setHasFixedSize(true);
        contrv.setLayoutManager(new LinearLayoutManager(this));



    }
    void run() throws IOException {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(conturl)
                .build();


        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                call.cancel();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                final String myResponse = response.body().string();

                ContributorsActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {

                            //   JSONObject json = new JSONObject(myResponse);

                            JSONArray jsonArr = new JSONArray(myResponse);

                            for (int i = 0; i < jsonArr.length(); i++) {
                                JSONObject jsonObj = jsonArr.getJSONObject(i);


                             //  runagain(jsonObj.get("url").toString());

                                contlist.add(new ContributeModel(jsonObj.get("login").toString(),
                                        jsonObj.get("url").toString(),
                                        jsonObj.get("avatar_url").toString(),
                                        jsonObj.get("contributions").toString()));


                            }

                            ContributeAdapter adapter = new ContributeAdapter(ContributorsActivity.this, contlist);
                            contrv.setAdapter(adapter);
                            pb.setVisibility(View.INVISIBLE);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });

            }
        });

    }

    public void runagain(String url){
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .build();

        SharedPreferences sp = getSharedPreferences("nameinfo", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sp.edit();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                call.cancel();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                final String myResponse = response.body().string();

                ContributorsActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {

                            //   JSONObject json = new JSONObject(myResponse);

                            JSONArray jsonArr = new JSONArray(myResponse);

                            for (int i = 0; i < jsonArr.length(); i++) {
                                JSONObject jsonObj = jsonArr.getJSONObject(i);


                                editor.putString(getString(R.string.sample), jsonObj.get("name").toString());
                                // jsonObj.get("company").toString();
                                Log.d("CAFE", "through");
                            }



                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });

            }
        });

    }


}
