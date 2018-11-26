package com.example.sathv.jbossoutreachrepositories;


import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

public class RepositoriesActivity extends AppCompatActivity {


    public String url = "https://api.github.com/users/JBossOutreach/repos";
    RecyclerView reporv;

    ProgressBar progressBar;
    List<RepoModel> repolist;
    SwipeRefreshLayout mSwipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repositories);
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle("Repositories");
        ab.setSubtitle("JBoss Repos fetched from GitHub");

        repolist = new ArrayList<>();

        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
        try {
            run();
        } catch (IOException e) {
            e.printStackTrace();
        }

        reporv = findViewById(R.id.reporv);
        reporv.setHasFixedSize(true);
        reporv.setLayoutManager(new LinearLayoutManager(this));

     //   progressBar.setVisibility(View.INVISIBLE);

    }

    void run() throws IOException {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .build();

        progressBar.setVisibility(View.VISIBLE);
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                call.cancel();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                final String myResponse = response.body().string();

                RepositoriesActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {

                         //   JSONObject json = new JSONObject(myResponse);

                            JSONArray jsonArr = new JSONArray(myResponse);

                            for (int i = 0; i < jsonArr.length(); i++) {
                                JSONObject jsonObj = jsonArr.getJSONObject(i);

                                String desc ="";
                                if(!jsonObj.get("description").toString().equals("null")){
                                    desc = jsonObj.get("description").toString();
                                }

                                repolist.add(new RepoModel(jsonObj.get("name").toString(),jsonObj.get("language").toString(),"Description: " + desc
                                ,jsonObj.get("updated_at").toString(),jsonObj.get("contributors_url").toString(),jsonObj.get("forks_count").toString(),jsonObj.get("stargazers_count").toString()));

//                                repolist.add(new RepoModel("a","b","c","d","e","f","d"));

                            }

                            RepoAdapter adapter = new RepoAdapter(RepositoriesActivity.this, repolist);
                            reporv.setAdapter(adapter);
                            progressBar.setVisibility(View.INVISIBLE);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });

            }
        });

    }


}
