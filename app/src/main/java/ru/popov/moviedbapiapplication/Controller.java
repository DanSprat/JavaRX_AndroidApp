package ru.popov.moviedbapiapplication;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Controller {

    static final String BASE_URL = "https://api.themoviedb.org/3/";
    static final String KEY = "815945b4b65392efdf89366063fde428";

    private Retrofit prepare() {
        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit;

    }

    public Call<MovieResponse> prepareMoviesCall(){
        EndPointInterface movieApi = prepare().create(EndPointInterface.class);
        Call<MovieResponse> call = movieApi.getTopRatedMovies(KEY);
        return call;
    }
}
