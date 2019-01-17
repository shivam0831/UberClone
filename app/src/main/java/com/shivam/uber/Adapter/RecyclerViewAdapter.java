package com.shivam.uber.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.shivam.uber.Activity.AboutUs;
import com.shivam.uber.Activity.ContactUs;
import com.shivam.uber.Activity.FAQ;
import com.shivam.uber.Activity.HelpSettings;
import com.shivam.uber.Model.Setting;
import com.shivam.uber.Activity.PrivacyPolicy;
import com.shivam.uber.R;
import com.shivam.uber.Activity.TermsConditions;

import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolader> {

    private Context mContext;
    List<Setting> mData;

    public RecyclerViewAdapter(Context mContext, List<Setting> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolader onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.recyclerview_item, parent, false);
        MyViewHolader vHolder = new MyViewHolader(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolader holder, int position) {

        holder.tv_name.setText(mData.get(position).getName());
        holder.img.setImageResource(mData.get(position).getPhoto());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolader extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView tv_name;
        private ImageView img;


        public MyViewHolader(View itemView) {
            super(itemView);
            mContext = itemView.getContext();

            tv_name = (TextView) itemView.findViewById(R.id.setting);
            img = (ImageView) itemView.findViewById(R.id.img_contact);

            itemView.setClickable(true);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int pos = getAdapterPosition();

            if (pos == 0) {
                Intent intent = new Intent(mContext, PrivacyPolicy.class);
                mContext.startActivity(intent);
            }
            if (pos == 1) {
                Intent intent = new Intent(mContext, TermsConditions.class);
                mContext.startActivity(intent);
            }
            if (pos == 2) {
                Intent intent = new Intent(mContext, HelpSettings.class);
                mContext.startActivity(intent);
            }
            if (pos == 3) {
                Intent intent = new Intent(mContext, FAQ.class);
                mContext.startActivity(intent);
            }
            if (pos == 4) {
                Intent intent = new Intent(mContext, AboutUs.class);
                mContext.startActivity(intent);
            }
            if (pos == 5) {
                Intent intent = new Intent(mContext, ContactUs.class);
                mContext.startActivity(intent);
            }
        }
    }
}
