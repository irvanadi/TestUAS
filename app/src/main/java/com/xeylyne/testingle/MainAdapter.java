package com.xeylyne.testingle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    Context context;
    ArrayList<ResultAPI> results;
    DataHelper dataHelper;

    public MainAdapter(Context context, ArrayList<ResultAPI> results) {
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
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        ResultAPI result = results.get(position);
        holder.txtNim.setText(result.getIDPLACE());
        holder.txtNama.setText(result.getNAMEPLACE());

        holder.toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myFav(holder.toggleButton, holder.txtNama, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imgLogo;
        TextView txtNim, txtNama;
        ToggleButton toggleButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgLogo = itemView.findViewById(R.id.imgLogo);
            txtNim = itemView.findViewById(R.id.txtNim);
            txtNama = itemView.findViewById(R.id.txtNama);
            toggleButton = itemView.findViewById(R.id.imgBookmark);
        }
    }

    public void myFav(ToggleButton fav, TextView nama, int position) {
        if (fav.isChecked()) {
            fav.setChecked(true);
            fav.setBackgroundResource(R.drawable.ic_star_black_24dp);
            dataHelper.AddPlace(nama.getText().toString());
        } else {
            fav.setChecked(false);
            fav.setBackgroundResource(R.drawable.ic_star_border_black_24dp);
            dataHelper.deleteData(position);
            clear();
            dataHelper.getAllData();
        }
    }

    public void clear() {
        int size = results.size();
        results.clear();
        notifyItemRangeRemoved(0, size);
    }
}
