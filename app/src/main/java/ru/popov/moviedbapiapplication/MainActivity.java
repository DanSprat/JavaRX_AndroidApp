package ru.popov.moviedbapiapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.List;
import java.util.function.Function;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView movieRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Controller controller = new Controller();
        movieRecyclerView = findViewById(R.id.movies_recycler);
        movieRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        Call<MovieResponse> moviesCall = controller.prepareMoviesCall();
        moviesCall.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                List<Movie> movieList = response.body().results;
               movieRecyclerView.setAdapter(new MoviesAdapter(movieList));
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Log.d(TAG, t.getLocalizedMessage());
            }
        });
    }
}