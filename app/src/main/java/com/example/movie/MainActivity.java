package com.example.movie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import com.example.movie.description_model.MovieDescription;
import com.example.movie.description_remote.MyRetroClient;
import com.example.movie.description_remote.MyService;
import com.example.movie.movie_model.Adapter;
import com.example.movie.movie_model.MovieModel;
import com.example.movie.movie_remote.RetroClient;
import com.example.movie.movie_remote.UserService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static maes.tech.intentanim.CustomIntent.customType;

public class MainActivity extends AppCompatActivity implements Adapter.OnItemClickListener {
    private List<MovieModel> movieModels = new ArrayList<>();
    private Adapter adapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
    private List <MovieDescription> movieDescription = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rv_list);
        UserService userService = RetroClient.getApiService();
        Call<List<MovieModel>> call = userService.getData();
        sendRequestForMovie(call);
        MyService myService=MyRetroClient.getApiService();
        Call<List<MovieDescription>> call1=myService.getData();
        sendRequestForDescription(call1);
    }


    @Override
    public void onItemClick(int position) {

        Intent intent = new Intent(MainActivity.this, DescriptionActivity.class);
        intent.putExtra("genre", TextUtils.join(",", movieModels.get(position).getGenre()));
        intent.putExtra("url", movieModels.get(position).getImage());
        intent.putExtra("title", movieModels.get(position).getTitle());
        intent.putExtra("description",movieDescription.get(position).getDescription());
        startActivity(intent);
        customType(MainActivity.this, "left-to-right");


    }

    private void sendRequestForMovie(Call<List<MovieModel>> call) {
        call.enqueue(new Callback<List<MovieModel>>() {
            @Override
            public void onResponse(Call<List<MovieModel>> call, Response<List<MovieModel>> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "Successful",
                            Toast.LENGTH_SHORT).show();
                    movieModels.addAll( response.body());
                    adapter = new Adapter(MainActivity.this, movieModels);
                    adapter.setOnItemClickListener(MainActivity.this);
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.addItemDecoration(new SimpleDividerItemDecoration(MainActivity.this));
                    recyclerView.setAdapter(adapter);

                } else {
                    Toast.makeText(MainActivity.this, " Not successful",
                            Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<List<MovieModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Not connected",
                        Toast.LENGTH_SHORT).show();

            }
        });
    }
    private void sendRequestForDescription(Call<List<MovieDescription>> call ) {
        call.enqueue(new Callback<List<MovieDescription>>() {
            @Override
            public void onResponse(Call<List<MovieDescription>> call, Response<List<MovieDescription>> response) {
                if(response.isSuccessful()){

                    movieDescription.addAll(response.body());

                }else {


                }
            }

            @Override
            public void onFailure(Call<List<MovieDescription>> call, Throwable t) {

            }
        });

    }

}
