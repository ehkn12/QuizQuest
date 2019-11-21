package com.example.GroupAssignment.Adapters;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.GroupAssignment.models.Results;
import com.example.GroupAssignment.R;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {

    private ArrayList<Results> data;
    private static TextView nameText;
    private static TextView descText;
    private static TextView extraText;
    private static View linearResult;
    private static Context mContext;

    public SearchAdapter(){

    }

    public SearchAdapter(ArrayList<Results> data, Context context) {
        this.data = data;
        mContext = context;
    }

    public static class SearchViewHolder extends RecyclerView.ViewHolder {

        private View view;
        public SearchViewHolder(View view) {
            super(view);
            this.view = view;

            nameText = view.findViewById(R.id.text_name);
            descText = view.findViewById(R.id.text_desc);
            extraText = view.findViewById(R.id.text_route);
            linearResult = view.findViewById(R.id.result_linear_layout);



        }
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.chunk_search_result, parent, false);
        SearchViewHolder searchViewHolder = new SearchViewHolder(v);
        return searchViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder searchHolder, int position){

        final Results searchAtPosition = data.get(position);
        setText(searchAtPosition);

    }

    public void setData(ArrayList<Results> breeds) {this.data = breeds;}

    public void setText(Results searchAtPosition) {
        switch (searchAtPosition.getRoute()) {
            case "spells/":
                nameText.setText(searchAtPosition.getName());
                descText.setText(searchAtPosition.getText());
                extraText.setText("Classes that can use this spell: " + searchAtPosition.getDnd_class());
                linearResult.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#DFACEB")));
                break;
            case "weapons/":
                nameText.setText(searchAtPosition.getName());
                descText.setText(searchAtPosition.getDesc());
                extraText.setText("");
                linearResult.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#F8EEA7")));
                break;
            default:
                nameText.setText(searchAtPosition.getName());
                descText.setText("");
                extraText.setText("Click here to get more information");
                final String url = "http://www.google.com/#q=dnd+" + searchAtPosition.getName();
                linearResult.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Uri uri = Uri.parse(url);
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, uri);
                        mContext.startActivity(browserIntent);
                    }

                });

                break;
        }

    }

    @Override
    public int getItemCount() { return data.size();}
    public ArrayList<Results> getData() {return this.data;}
}



