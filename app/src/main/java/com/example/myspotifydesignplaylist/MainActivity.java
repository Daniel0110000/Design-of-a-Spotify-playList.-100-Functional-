package com.example.myspotifydesignplaylist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.myspotifydesignplaylist.adapter.RecyclerViewAdapter;
import com.example.myspotifydesignplaylist.interfaz.RecyclerViewInterfaceOnClick;
import com.example.myspotifydesignplaylist.utilities.getItems;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterfaceOnClick {

    private List<getItems> items;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    private FloatingActionButton floanButton;
    private MediaPlayer mediaPlayer;
    private int playOnStop = 0;
    private String[] namesMusic = {"Luces", "Nublado", "Chance", "Plan A", "Party", "Tal Vez", "Solo Pienso En Ti", "Forever Alone", "Adan y Eva", "Condenado Para El Millon"};
    private String[] datesMusic = {"2022", "2022", "2022", "2022", "2019", "2019", "2019", "2019", "2018", "2018"};
    private int[] imagesMusic = {R.drawable.img2, R.drawable.img9, R.drawable.img8, R.drawable.img1, R.drawable.img10, R.drawable.img5, R.drawable.img6, R.drawable.img3, R.drawable.img4, R.drawable.img7};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main();
    }

    private void main(){
        recyclerView = findViewById(R.id.recycler);
        items = new ArrayList<>();
        for (int i = 0; i < namesMusic.length; i++){
            items.add(new getItems(namesMusic[i], datesMusic[i], imagesMusic[i]));
        }

        adapter = new RecyclerViewAdapter(items, this, this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        floanButton = findViewById(R.id.floatingOne);
        floanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                randomMusic();
            }
        });
    }

    @Override
    public void onItemClick(int position) {
        String nameMusic = items.get(position).getTextNameMusic();
        String dateMusic = items.get(position).getTextDateMusic();
        int imageMusic = items.get(position).getMusicImage();

        Intent selectedMusic = new Intent(this, MainActivity2.class);
        selectedMusic.putExtra("Name", nameMusic);
        selectedMusic.putExtra("Date", dateMusic);
        selectedMusic.putExtra("image", imageMusic);
        startActivity(selectedMusic);
    }

    private void randomMusic(){
        if(playOnStop == 0){
            int numberRandom = (int)(Math.random() * 8 + 1);
            int [] musicName = {R.raw.luces, R.raw.nublado, R.raw.plana, R.raw.party, R.raw.talvez, R.raw.solopiensoenti, R.raw.forever, R.raw.adanyeva, R.raw.condenadomillon};
            int selectedMusic = 0;
            for (int i = 0; i < musicName.length; i++){
                if(i == numberRandom){
                    selectedMusic = musicName[i];
                }
            }
            if(mediaPlayer != null){
                mediaPlayer.release();
            }

            mediaPlayer = MediaPlayer.create(this, selectedMusic);
            mediaPlayer.start();
            playOnStop = 1;
            floanButton.setImageResource(R.drawable.ic_baseline_pause_24);
        }else if(playOnStop == 1){
            if(mediaPlayer != null && mediaPlayer.isPlaying()){
                mediaPlayer.pause();
            }
            playOnStop = 2;
            floanButton.setImageResource(R.drawable.ic_baseline_play_arrow_24);
        }else if(playOnStop == 2){
            if(mediaPlayer != null && !mediaPlayer.isPlaying()){
                mediaPlayer.start();
            }
            playOnStop = 1;
            floanButton.setImageResource(R.drawable.ic_baseline_pause_24);
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