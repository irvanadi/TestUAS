package com.xeylyne.testingle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BookmarkAdapter extends RecyclerView.Adapter<BookmarkAdapter.ViewHolder> {

    Context context;
    ArrayList<Place> results;
    DataHelper dataHelper;

    public BookmarkAdapter(Context context, ArrayList<Place> results) {
        this.context = context;
        this.results = results;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, parent, false);
        ViewHolder holder = new ViewHolder(v);
        dataHelper = new DataHelper(context);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Place result = results.get(position);
        holder.txtNim.setText(result.getID_PLACE());
        holder.txtNama.setText(result.getNAME_PLACE());
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgLogo;
        TextView txtNim, txtNama;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgLogo = itemView.findViewById(R.id.imgLogo);
            txtNim = itemView.findViewById(R.id.txtNim);
            txtNama = itemView.findViewById(R.id.txtNama);
        }
    }
}
