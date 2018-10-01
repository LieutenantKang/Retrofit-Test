package com.example.user.retrofittest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubClient {
    @GET("users/{user}/repos")
    /*
    이 부분이 잘 이해가 안되는데, 이 GET이 참조하고 있는
    https://api.github.com/users/{user}/repos 을 인터넷으로 쳐서 들어가보면 별다른게 안나오지만
    어플 실행시에는 리스트뷰가 쭉 잘 나옵니다.
    --> MainActivity에서 {user}값으로 'fs-opensource'을 넘겨주도록 작성했기 때문에 실제 호출 url은
    https://api.github.com/users/fs-opensource/repos 입니다.

    반대로 이 부분을 @GET("/users/LieutenantKang/repos") 로 바꿔서 제 걸 참조하려고 하면
    어플이 멈춰버리지만, 실제 주소인 api.github.com/users/LieutenantKang/repos 를 인터넷으로
    들어가면 제 repo 목록이 잘 나옵니다.
    --> @GET() 안의 url은 Retrofit.Builder 생성 시 설정한 baseUrl의 뒷부분에 이어집니다.
    현재 코드를 실행하면 https://api.github.com//users/{user}/repos 을 호출하기 때문에,
    이렇게 슬래시가 2개가 들어가서 발생하는 에러로 보입니다.
    onFailure()를 디버깅해서 호출 url을 직접 확인하실 수 있습니다.

    이 부분이 잘 이해가 되지 않습니다 ㅠㅠ
     */
    Call<List<GitHubRepo>> reposForUser(
            @Path("user") String user
    );
}
