package com.example.myspotifydesignplaylist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myspotifydesignplaylist.R;
import com.example.myspotifydesignplaylist.interfaz.RecyclerViewInterfaceOnClick;
import com.example.myspotifydesignplaylist.utilities.getItems;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private final RecyclerViewInterfaceOnClick recyclerViewInterfaceOnClick;

    private List<getItems> items;
    private Context context;
    private LayoutInflater inflater;

    public RecyclerViewAdapter(List<getItems> items, Context context, RecyclerViewInterfaceOnClick recyclerViewInterfaceOnClick) {
        this.items = items;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.recyclerViewInterfaceOnClick = recyclerViewInterfaceOnClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.layout_items_list,
                null

        ), recyclerViewInterfaceOnClick);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.print(position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView textNameMusic, textDateMusic;
        private ImageView imageViewMusic;

        public ViewHolder(@NonNull View itemView, RecyclerViewInterfaceOnClick recyclerViewInterfaceOnClick) {
            super(itemView);

            textDateMusic = itemView.findViewById(R.id.textDateMusic);
            textNameMusic = itemView.findViewById(R.id.textNameMusic);
            imageViewMusic = itemView.findViewById(R.id.musicImage);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(recyclerViewInterfaceOnClick != null){
                        int post = getAdapterPosition();

                        if(post != RecyclerView.NO_POSITION){
                            recyclerViewInterfaceOnClick.onItemClick(post);
                        }
                    }
                }
            });

        }

        public void print(int position) {
            textNameMusic.setText(items.get(position).getTextNameMusic());
            textDateMusic.setText(items.get(position).getTextDateMusic());
            imageViewMusic.setImageResource(items.get(position).getMusicImage());
        }
    }
}

// Programer: Daniel Carias
