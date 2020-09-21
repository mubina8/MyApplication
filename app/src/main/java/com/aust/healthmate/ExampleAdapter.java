package com.aust.healthmate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {
    private ArrayList<ExampleItem> mExampleList;
    public  static class ExampleViewHolder extends RecyclerView.ViewHolder{
        public ImageView mImageView, nImageView;
        public TextView  mText,nText,pText;


        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView=itemView.findViewById(R.id.imageView);
            nImageView=itemView.findViewById(R.id.positive);
            mText=itemView.findViewById(R.id.time);
            nText=itemView.findViewById(R.id.Penicilin);
            pText=itemView.findViewById(R.id.dose);

        }
    }
    public ExampleAdapter(ArrayList<ExampleItem> exampleList){
        mExampleList=exampleList;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item,parent,false);
        ExampleViewHolder evh =new ExampleViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
                ExampleItem currentItem=mExampleList.get(position);
                holder.mImageView.setImageResource(currentItem.getImageResource());
                holder.nImageView.setImageResource(currentItem.getmImageResource2());
                holder.mText.setText(currentItem.getmText());
                holder.nText.setText(currentItem.getnText());
                holder.pText.setText(currentItem.getpText());
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }
}
