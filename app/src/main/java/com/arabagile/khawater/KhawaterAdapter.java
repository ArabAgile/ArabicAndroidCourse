package com.arabagile.khawater;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by trainer on 12/11/16.
 */

public class KhawaterAdapter extends RecyclerView.Adapter<KhawaterAdapter.ViewHolder> {

    private List<Khatera> mDataset;
    private Context mContext;

    public KhawaterAdapter(Context context, List<Khatera> myDataset) {
        mDataset = myDataset;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item, parent, false);

        ViewHolder vh = new ViewHolder(v);

        Typeface type = Typeface.createFromAsset(mContext.getAssets(),"fonts/DroidKufi-Regular.ttf");

        vh.tvName.setTypeface(type);
        vh.tvLikes.setTypeface(type);
        vh.tvDate.setTypeface(type);
        vh.tvText.setTypeface(type);

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        final Khatera khatera = mDataset.get(position);
        holder.tvName.setText(khatera.getAuthorName());
        holder.tvDate.setText(khatera.getDate());
        holder.tvText.setText(khatera.getKhateraText());

        setAvatar(khatera.getAuthorPicture(), holder.ivUserPicture);

        holder.tvLikes.setText(mContext.getString(R.string.likes_number, khatera.getLikes()));

        holder.ivLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                khatera.setLikes(khatera.getLikes()+1);
                notifyItemChanged(position);
            }
        });

        holder.ivShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, khatera.getKhateraText());
                sendIntent.setType("text/plain");
                mContext.startActivity(Intent.createChooser(sendIntent, mContext.getResources().getText(R.string.share_with)));
            }
        });
    }

    private void setAvatar(String authorPicture, ImageView ivUserPicture) {
        switch (authorPicture) {
            case "1":
                ivUserPicture.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_avatar_1));
                break;

            case "2":
                ivUserPicture.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_avatar_2));
                break;

            case "3":
                ivUserPicture.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_avatar_3));
                break;

            case "4":
                ivUserPicture.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_avatar_4));
                break;

            case "5":
                ivUserPicture.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_avatar_5));
                break;

        }
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.ivUserPicture)
        ImageView ivUserPicture;

        @BindView(R.id.tvName)
        TextView tvName;

        @BindView(R.id.tvDate)
        TextView tvDate;

        @BindView(R.id.ivLike)
        ImageView ivLike;

        @BindView(R.id.ivShare)
        ImageView ivShare;

        @BindView(R.id.tvText)
        TextView tvText;

        @BindView(R.id.tvLikes)
        TextView tvLikes;


        // each data item is just a string in this case
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
