package com.robotbot.movies;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @Headers("X-API-KEY:JJ0NXZ9-RR2M81P-H3XC7RT-0T5Q0F2")
    @GET("movie?rating.kp=7-10&sortField=votes.kp&sortType=-1&limit=30")
    Single<MovieResponse> loadMovies(@Query("page") int page);

    @Headers("X-API-KEY:JJ0NXZ9-RR2M81P-H3XC7RT-0T5Q0F2")
    @GET("movie/{id}")
    Single<MovieTrailer> loadTrailers(@Path("id") int id);

    @Headers("X-API-KEY:JJ0NXZ9-RR2M81P-H3XC7RT-0T5Q0F2")
    @GET("review?limit=10")
    Single<ReviewResponse> loadReviews(@Query("page") int page, @Query("movieId") int movieId);
}
