package com.example.GroupAssignment.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.GroupAssignment.R;
import com.example.GroupAssignment.Models.Results;

import java.util.List;

public class SpellRecyclerAdapter extends RecyclerView.Adapter<SpellRecyclerAdapter.SpellViewHolder> {
    public List<Results> spellList;

    public static class SpellViewHolder extends RecyclerView.ViewHolder {
        public TextView spell;
        public SpellViewHolder(@NonNull View itemView) {
            super(itemView);
            spell = itemView.findViewById(
                    R.id.spellNameView);
        }
    }

    public SpellRecyclerAdapter(List<Results> spells) {
        spellList = spells;
    }
    @NonNull
    @Override
    public SpellViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.spelllayout, parent, false);
        SpellViewHolder spellViewHolder = new SpellRecyclerAdapter.SpellViewHolder(view);
        return spellViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SpellViewHolder holder, int position) {
        holder.spell.setText(spellList.get(position).getName());
    }



    @Override
    public int getItemCount() {
        return spellList.size();
    }
}
