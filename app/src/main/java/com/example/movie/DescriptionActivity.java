package com.example.movie;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.movie.description_model.MovieDescription;
import com.example.movie.description_remote.MyRetroClient;
import com.example.movie.description_remote.MyService;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static maes.tech.intentanim.CustomIntent.customType;

public class DescriptionActivity extends AppCompatActivity {
    private ImageView imageView;
    private TextView genre;
    private TextView title;
    private TextView description;
   private List <MovieDescription> movieDescription = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        System.out.println(movieDescription.size());
        imageView = findViewById(R.id.image1);
        genre = findViewById(R.id.genre);
        title = findViewById(R.id.tv_title1);
        description = findViewById(R.id.description);
        genre.setText("Genres "+ getIntent().getStringExtra("genre"));
        Picasso.get().load(getIntent().getStringExtra("url")).placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(imageView);
        title.setText(getIntent().getStringExtra("title"));
        description.setText(getIntent().getStringExtra("description"));

    }

    @Override
    public void finish() {
        super.finish();
        customType(this,"right-to-left");
    }

    }

