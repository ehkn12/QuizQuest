package com.example.GroupAssignment.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
    private static Context mContext;

    public static class ResultViewHolder extends RecyclerView.ViewHolder {
        public TextView infoName;
        public View infoView;


        public ResultViewHolder(@NonNull View itemView) {
            super(itemView);
            infoName = itemView.findViewById(R.id.infoNameView);
            infoView = itemView;
        }
    }

    public InfoNameRecyclerAdapter(List<Results> results, String string, Context context) {
        resultsList = results;
        infoType = string;
        mContext = context;

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
        final int clickPosition = position;
        holder.infoName.setText(name);

        holder.infoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(infoType == "Spells" || infoType == "Classes" || infoType == "Weapons" ){
                    InfoDetailFragment fragment = new InfoDetailFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("InfoName", name);
                    bundle.putString("InfoType", infoType);
                    fragment.setArguments(bundle);

                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout, fragment)
                            .addToBackStack(null).commit();
                } else {
                    String url = "http://www.google.com/#q=dnd+" + resultsList.get(clickPosition).getName();

                    Uri uri = Uri.parse(url);
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, uri);
                    mContext.startActivity(browserIntent);
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return resultsList.size();
    }
}
