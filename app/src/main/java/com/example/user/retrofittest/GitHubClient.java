package com.example.user.retrofittest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubClient {
    @GET("/users/{user}/repos")
    /*
    이 부분이 잘 이해가 안되는데, 이 GET이 참조하고 있는
    https://api.github.com/users/{user}/repos 을 인터넷으로 쳐서 들어가보면 별다른게 안나오지만
    어플 실행시에는 리스트뷰가 쭉 잘 나옵니다.

    반대로 이 부분을 @GET("/users/LieutenantKang/repos") 로 바꿔서 제 걸 참조하려고 하면
    어플이 멈춰버리지만, 실제 주소인 api.github.com/users/LieutenantKang/repos 를 인터넷으로
    들어가면 제 repo 목록이 잘 나옵니다.

    이 부분이 잘 이해가 되지 않습니다 ㅠㅠ
     */
    Call<List<GitHubRepo>> reposForUser(
            @Path("user") String user
    );
}
