package com.example.GroupAssignment.Adapters;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.GroupAssignment.Fragments.InfoNameFragment;
import com.example.GroupAssignment.R;

import java.util.List;

public class InformationRecyclerAdapter extends RecyclerView.Adapter<InformationRecyclerAdapter.InformationViewHolder> {
    private List<String> infoList;

    public static class InformationViewHolder extends RecyclerView.ViewHolder {
        public TextView infoCategory;
        public View infoView;

        public InformationViewHolder(@NonNull View itemView) {
            super(itemView);
            infoCategory = itemView.findViewById(R.id.infoCategory);
            infoView = itemView;

        }
    }

    public InformationRecyclerAdapter(List<String> infoList) {
        this.infoList = infoList;

    }

    @NonNull
    @Override
    public InformationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.informationlistlayout, parent, false);
        InformationViewHolder informationViewHolder = new InformationViewHolder(view);

        return informationViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull InformationViewHolder holder, final int position) {
        holder.infoCategory.setText(infoList.get(position));

        holder.infoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InfoNameFragment fragment = new InfoNameFragment();
                String infoType = infoList.get(position);

                Bundle bundle = new Bundle();
                bundle.putString("infoType", infoType);
                fragment.setArguments(bundle);

                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout, fragment)
                        .addToBackStack(null).commit();
            }
        });
    }



    @Override
    public int getItemCount() {
        return infoList.size();
    }
}
