package com.mohammedfahadkaleem.whatsapp.ui.mainscreen.chatslistscreen;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.mohammedfahadkaleem.whatsapp.R;
import com.mohammedfahadkaleem.whatsapp.model.User;
import com.mohammedfahadkaleem.whatsapp.ui.chatscreen.ChatActivity;
import com.mohammedfahadkaleem.whatsapp.ui.profilescreen.ProfileActivity;
import com.mohammedfahadkaleem.whatsapp.util.Utils;
import java.util.List;

public class ChatsRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<User> items;
    private Context ctx;
    private OnItemClickListener mOnItemClickListener;


    public interface OnItemClickListener {
        void onItemClick(View view, User obj, int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    public ChatsRecyclerViewAdapter(Context context, List<User> items) {
        this.items = items;
        ctx = context;
    }

    public class OriginalViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView name;
        public ImageView readReceipt;
        public View lyt_parent;
        public TextView message;

        public OriginalViewHolder(View v) {
            super(v);
            image =  v.findViewById(R.id.user_profile_picture);
            name  =  v.findViewById(R.id.user_name);
            readReceipt = v.findViewById(R.id.read_receipt);
            lyt_parent = v.findViewById(R.id.chat_item_parent);
            message = v.findViewById(R.id.message);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        View v = LayoutInflater
            .from(parent.getContext()).inflate(R.layout.item_chat, parent, false);
        vh = new OriginalViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof OriginalViewHolder) {
            OriginalViewHolder view = (OriginalViewHolder) holder;

            User contact = items.get(position);
            view.name.setText(contact.name);
            view.readReceipt.setImageResource(contact.readReceipt);
            Utils.displayImageRound(ctx, view.image, contact.image);
            view.message.setText(contact.message);

            view.lyt_parent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mOnItemClickListener != null) {
                        mOnItemClickListener.onItemClick(view, items.get(position), position);
                    }
                }
            });

            view.image.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    showDialog(view.getContext(),position);
                }
            });
        }
    }

    private void showDialog(Context context, int position) {
        final Dialog dialog = new Dialog(context);
        User user = items.get(position);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // before
        dialog.setContentView(R.layout.dialog_profile);
        dialog.setCancelable(true);

        WindowManager.LayoutParams parameters = new WindowManager.LayoutParams();
        parameters.copyFrom(dialog.getWindow().getAttributes());
        parameters.width = WindowManager.LayoutParams.WRAP_CONTENT;
        parameters.height = WindowManager.LayoutParams.WRAP_CONTENT;
        parameters.gravity = Gravity.TOP;
        int height = Utils.getScreenHeight();
        parameters.y= (height/10);

        ImageView dialogProfilePicture = dialog.findViewById(R.id.dialog_profile_picture);
        dialogProfilePicture.setImageResource(user.image);

        TextView dialogName = dialog.findViewById(R.id.dialog_name);
        dialogName.setText(user.name);



        dialog.findViewById(R.id.dialog_message).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx,ChatActivity.class);
                ctx.startActivity(intent);
                dialog.dismiss();
            }
        });

        dialog.findViewById(R.id.dialog_call).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ctx,"Feature not yet implemented",Toast.LENGTH_SHORT).show();
            }
        });

        dialog.findViewById(R.id.dialog_video_call).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ctx,"Feature not yet implemented",Toast.LENGTH_SHORT).show();
            }
        });

        dialog.findViewById(R.id.dialog_profile_info).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx,ProfileActivity.class);
                ctx.startActivity(intent);
                dialog.dismiss();
            }
        });


        dialog.show();
        dialog.getWindow().setAttributes(parameters);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

}