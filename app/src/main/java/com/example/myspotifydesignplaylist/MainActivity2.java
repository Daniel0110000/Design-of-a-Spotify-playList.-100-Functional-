package com.example.myspotifydesignplaylist;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity2 extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    private ImageView imageMusic, imageBack, ImageFav;
    private TextView textName, textDate, textDatePublication;
    private String name;
    private FloatingActionButton controllMusic;
    private int playOnStop = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        main();
    }

    private void main(){
        imageBack = findViewById(R.id.back);
        imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        ImageFav = findViewById(R.id.imageFav);
        ImageFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageFav.setImageResource(R.drawable.ic_baseline_favorite_24);
            }
        });

        name = getIntent().getStringExtra("Name");
        String date = getIntent().getStringExtra("Date");
        int image = getIntent().getIntExtra("image", 0);

        imageMusic = findViewById(R.id.imageMusic);
        textName = findViewById(R.id.titleMusic);
        textDate = findViewById(R.id.dateMusic);

        imageMusic.setImageResource(image);
        textName.setText(name);
        textDate.setText("Sencillo • " + date);

        controllMusic = findViewById(R.id.playMusic);

        verification();

    }

    private void verification(){
        textDatePublication = findViewById(R.id.datePublication);
        controllMusic = findViewById(R.id.playMusic);
        String date;
        if(name.equals("Luces")){
            date = "29 de junio 2022";
            controllMusic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    playMusic("Luces");
                }
            });
        }else if(name.equals("Nublado")){
            date = "28 de junio 2022";
            controllMusic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    playMusic("Nublado");
                }
            });
        }else if(name.equals("Chance")){
            date = "6 de abril de 2022";
            controllMusic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    playMusic("Chance");
                }
            });
        }else if(name.equals("Plan A")){
            date = "23 de marzo de 2022";
            controllMusic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    playMusic("Plan A");
                }
            });
        }else if(name.equals("Party")){
            date = "26 de septiembre de 2019";
            controllMusic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    playMusic("Party");
                }
            });
        }else if(name.equals("Tal Vez")){
            date = "3 de abril de 2019";
            controllMusic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    playMusic("Tal Vez");
                }
            });
        }else if(name.equals("Solo Pienso En Ti")){
            date = "14 de mayo de 2019";
            controllMusic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    playMusic("Solo Pienso En Ti");
                }
            });
        }else if(name.equals("Forever Alone")){
            date = "13 de septiembre de 2019";
            controllMusic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    playMusic("Forever");
                }
            });
        }else if(name.equals("Adan y Eva")){
            date = "5 de noviembre de 2018";
            controllMusic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    playMusic("Adan y Eva");
                }
            });
        }else if(name.equals("Condenado Para El Millon")){
            date = "3 de noviembre de 2018";
            controllMusic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    playMusic("Condenado");
                }
            });
        }else {
            date = "No definido";
        }
        textDatePublication.setText(date);
    }


    private void playMusic(String nameMusic){
        if(playOnStop == 0){
            int musicPlay = R.raw.luces;

            switch (nameMusic){
                case "Luces":
                    musicPlay = R.raw.luces;
                    break;
                case "Nublado":
                    musicPlay = R.raw.nublado;
                    break;
                case "Chance":
                    musicPlay = R.raw.chance;
                    break;
                case "Plan A":
                    musicPlay = R.raw.plana;
                    break;
                case "Party":
                    musicPlay = R.raw.party;
                    break;
                case "Tal Vez":
                    musicPlay = R.raw.talvez;
                    break;
                case "Solo Pienso En Ti":
                    musicPlay = R.raw.solopiensoenti;
                    break;
                case "Forever":
                    musicPlay = R.raw.forever;
                    break;
                case "Adan y Eva":
                    musicPlay = R.raw.adanyeva;
                    break;
                case "Condenado":
                    musicPlay = R.raw.condenadomillon;
                    break;
            }

            if(mediaPlayer != null){
                mediaPlayer.release();
            }
            mediaPlayer = MediaPlayer.create(this, musicPlay);
            controllMusic.setImageResource(R.drawable.ic_baseline_pause_24);
            mediaPlayer.start();
            playOnStop = 1;
        }else if(playOnStop == 1){
            if(mediaPlayer != null && mediaPlayer.isPlaying()){
                mediaPlayer.pause();
            }
            playOnStop = 2;
            controllMusic.setImageResource(R.drawable.ic_baseline_play_arrow_24);
        }else{
            if(mediaPlayer != null && !mediaPlayer.isPlaying()){
                mediaPlayer.start();
                playOnStop = 1;
                controllMusic.setImageResource(R.drawable.ic_baseline_pause_24);
            }
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

}

// Programer: Daniel Carias
