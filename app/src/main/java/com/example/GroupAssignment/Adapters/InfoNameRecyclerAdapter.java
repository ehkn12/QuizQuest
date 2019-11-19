package com.example.GroupAssignment.Adapters;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.GroupAssignment.Fragments.InfoDetailFragment;
import com.example.GroupAssignment.R;
import com.example.GroupAssignment.models.Results;

import java.util.List;

public class InfoNameRecyclerAdapter extends RecyclerView.Adapter<InfoNameRecyclerAdapter.ResultViewHolder> {
    private List<Results> resultsList;
    private String infoType;

    public static class ResultViewHolder extends RecyclerView.ViewHolder {
        public TextView infoName;
        public View infoView;


        public ResultViewHolder(@NonNull View itemView) {
            super(itemView);
            infoName = itemView.findViewById(R.id.infoNameView);
            infoView = itemView;
        }
    }

    public InfoNameRecyclerAdapter(List<Results> results, String string) {
        resultsList = results;
        infoType = string;

    }
    @NonNull
    @Override
    public ResultViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.infoname, parent, false);
        ResultViewHolder resultViewHolder = new InfoNameRecyclerAdapter.ResultViewHolder(view);
        return resultViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ResultViewHolder holder, int position) {
        final String name = resultsList.get(position).getName();
        holder.infoName.setText(name);

        holder.infoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InfoDetailFragment fragment = new InfoDetailFragment();

                Bundle bundle = new Bundle();
                bundle.putString("InfoName", name);
                bundle.putString("InfoType", infoType);
                fragment.setArguments(bundle);

                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout, fragment)
                        .addToBackStack(null).commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return resultsList.size();
    }
}
