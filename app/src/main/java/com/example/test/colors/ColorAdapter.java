package com.example.test.colors;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

class ColorAdapter extends RecyclerView.Adapter<ColorAdapter.ColorViewHolder> {

    class ColorViewHolder extends RecyclerView.ViewHolder {

        TextView tvColor;
        CardView cvColor;

        ColorViewHolder(View v) {
            super(v);
            tvColor = (TextView) v.findViewById(R.id.tvColor);
            cvColor = (CardView) v.findViewById(R.id.cvColor);
        }
    }

    private ArrayList<CustomColor> colors;
    ColorAdapter(ArrayList<CustomColor> colors) {
        this.colors = colors;
    }

    @Override
    public int getItemCount() {
        return colors.size();
    }

    @Override
    public ColorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.color_item, parent, false);
        return new ColorViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ColorViewHolder holder, final int position) {

        final int ITEM_NOT_PRESSED_HEIHGT = (int) holder.tvColor.getContext().getResources().getDimension(R.dimen.layout_height_unpressed);
        final int ITEM_PRESSED_HEIHGT = (int) holder.tvColor.getContext().getResources().getDimension(R.dimen.layout_height_pressed);

        holder.cvColor.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ITEM_NOT_PRESSED_HEIHGT));
        holder.tvColor.setText(colors.get(position).name);
        holder.tvColor.setTextColor(Color.parseColor(colors.get(position).color));

        holder.cvColor.setOnClickListener(new View.OnClickListener() {
            boolean pressed;

            @Override
            public void onClick(View v) {
                if (!pressed) {
                    holder.cvColor.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ITEM_PRESSED_HEIHGT));
                    holder.cvColor.setCardBackgroundColor(Color.parseColor(colors.get(position).color));
                    holder.tvColor.setTextColor(ContextCompat.getColor(v.getContext(), R.color.gray));
                    pressed = true;
                } else {
                    holder.cvColor.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ITEM_NOT_PRESSED_HEIHGT));
                    holder.cvColor.setCardBackgroundColor(ContextCompat.getColor(v.getContext(), R.color.gray));
                    holder.tvColor.setTextColor(Color.parseColor(colors.get(position).color));
                    pressed = false;
                }

            }
        });
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}

