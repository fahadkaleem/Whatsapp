package com.mohammedfahadkaleem.whatsapp.ui.contactslistscreen;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.mohammedfahadkaleem.whatsapp.R;
import com.mohammedfahadkaleem.whatsapp.model.User;
import com.mohammedfahadkaleem.whatsapp.ui.profilescreen.ProfileActivity;
import com.mohammedfahadkaleem.whatsapp.util.Utils;
import java.util.List;

public class ContactsListRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<User> items;

    private Context ctx;
    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View view, User obj, int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    public ContactsListRecyclerViewAdapter(Context context, List<User> items) {
        this.items = items;
        ctx = context;
    }

    public class OriginalViewHolder extends RecyclerView.ViewHolder {
        public ImageView displayPic;
        public TextView username;
        public TextView userStatus;
        public View parent;
        public TextView contactType;

        public OriginalViewHolder(View v) {
            super(v);
            displayPic =  v.findViewById(R.id.display_picture);
            username  =  v.findViewById(R.id.user_name);
            userStatus = v.findViewById(R.id.user_status);
            parent = v.findViewById(R.id.contacts_list_parent);
            contactType = v.findViewById(R.id.contact_type);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        View v = LayoutInflater
            .from(parent.getContext()).inflate(R.layout.item_contacts_list, parent, false);
        vh = new OriginalViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof OriginalViewHolder) {
            OriginalViewHolder view = (OriginalViewHolder) holder;

            User contact = items.get(position);
            view.username.setText(contact.name);
            Utils.displayImageRound(ctx, view.displayPic, contact.image);
            view.userStatus.setText(contact.status);
            view.contactType.setText(contact.contactType);

            view.parent.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mOnItemClickListener != null) {
                        mOnItemClickListener.onItemClick(view, items.get(position), position);
                    }
                }
            });

            view.parent.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(ctx,ProfileActivity.class);
                    ctx.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

}