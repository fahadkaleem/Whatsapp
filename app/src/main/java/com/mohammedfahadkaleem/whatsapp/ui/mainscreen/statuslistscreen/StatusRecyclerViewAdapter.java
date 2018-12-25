package com.mohammedfahadkaleem.whatsapp.ui.mainscreen.statuslistscreen;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.mohammedfahadkaleem.whatsapp.R;
import com.mohammedfahadkaleem.whatsapp.model.User;
import com.mohammedfahadkaleem.whatsapp.util.Utils;
import java.util.List;

public class StatusRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<User> items;

    private Context ctx;
    private StatusRecyclerViewAdapter.OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View view, User obj, int position);
    }

    public void setOnItemClickListener(final StatusRecyclerViewAdapter.OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    public StatusRecyclerViewAdapter(Context context, List<User> items) {
        this.items = items;
        ctx = context;
    }

    public class OriginalViewHolder extends RecyclerView.ViewHolder {
        public ImageView user_display_pic;
        public TextView user_name;
        public TextView status_time;
        public View lyt_parent;

        public OriginalViewHolder(View v) {
            super(v);
            user_display_pic =  v.findViewById(R.id.status_user_display_pic);
            user_name =  v.findViewById(R.id.user_name);
            status_time = v.findViewById(R.id.status_time);
            lyt_parent = v.findViewById(R.id.status_item_parent);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        View v = LayoutInflater
            .from(parent.getContext()).inflate(R.layout.item_status, parent, false);
        vh = new StatusRecyclerViewAdapter.OriginalViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof StatusRecyclerViewAdapter.OriginalViewHolder) {
            StatusRecyclerViewAdapter.OriginalViewHolder view = (StatusRecyclerViewAdapter.OriginalViewHolder) holder;

            User contact = items.get(position);
            view.user_name.setText(contact.name);
            Utils.displayImageRound(ctx, view.user_display_pic, contact.image);
            view.status_time.setText(contact.statusTime);

            view.lyt_parent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mOnItemClickListener != null) {
                        mOnItemClickListener.onItemClick(view, items.get(position), position);
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

}