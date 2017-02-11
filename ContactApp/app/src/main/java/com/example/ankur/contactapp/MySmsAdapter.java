package com.example.ankur.contactapp;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ankur on 10/2/17.
 */

public class MySmsAdapter extends RecyclerView.Adapter<MySmsAdapter.MyViewHolder> {
    private ArrayList<Sms> info;
    private LayoutInflater inflater;
    public Context context;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    class MyViewHolder extends RecyclerView.ViewHolder {
        CardView mCardView;
        TextView mTextViewName, mTextViewDate, mTextViewOtp;

        public MyViewHolder(View v) {
            super(v);

            mCardView = (CardView) v.findViewById(R.id.cardView);
            mTextViewName = (TextView) v.findViewById(R.id.textName);
            mTextViewDate = (TextView) v.findViewById(R.id.textDate);
            mTextViewOtp = (TextView) v.findViewById(R.id.textOtp);
        }

    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MySmsAdapter(Context context, ArrayList<Sms> info) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.info = info;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MySmsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_sms_row, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MySmsAdapter.MyViewHolder vh = new MySmsAdapter.MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Sms sms = info.get(position);
        holder.mTextViewName.setText(sms.getName());
        holder.mTextViewDate.setText(sms.getDate());
        holder.mTextViewOtp.setText(sms.getOtp());

    }

    @Override
    public int getItemCount() {
        return info.size();
    }
}
