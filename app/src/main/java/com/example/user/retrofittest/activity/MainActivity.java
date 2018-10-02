package com.example.user.retrofittest.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.example.user.retrofittest.R;
import com.example.user.retrofittest.adapter.GitHubRepoAdapter;
import com.example.user.retrofittest.model.GitHubRepo;
import com.example.user.retrofittest.retrofit.RetrofitClient;
import com.example.user.retrofittest.retrofit.service.GitHubService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private ListView listView;

    /*  1. 재사용 되지 않는 변수는 지역변수로 선언
     *   2. 또는 아래와 같이 한줄로 작성
     *   */
    private GitHubService gitHubService = RetrofitClient.create().create(GitHubService.class);

    /* onCreate()는 최대한 깔끔하게 */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        getGithubRepo("LieutenantKang");
    }

    /* init()에 findViewById() 몰아주는게 깔끔해짐 */
    public void init() {
        listView = findViewById(R.id.pagination_list);
    }

    public void getGithubRepo(String name) {
        Call<List<GitHubRepo>> call = gitHubService.reposForUser(name);
        call.enqueue(new Callback<List<GitHubRepo>>() {
            @Override
            public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
                List<GitHubRepo> gitHubRepos = response.body();
                listView.setAdapter(new GitHubRepoAdapter(MainActivity.this, gitHubRepos));
            }

            @Override
            public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
