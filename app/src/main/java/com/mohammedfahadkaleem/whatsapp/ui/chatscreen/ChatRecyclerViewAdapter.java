package com.mohammedfahadkaleem.whatsapp.ui.chatscreen;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.mohammedfahadkaleem.whatsapp.R;
import com.mohammedfahadkaleem.whatsapp.model.Message;
import java.util.List;

public class ChatRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<Message> messages;

    private Context ctx;
    private ChatRecyclerViewAdapter.OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View view, Message obj, int position);
    }

    public void setOnItemClickListener(final ChatRecyclerViewAdapter.OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    public ChatRecyclerViewAdapter(Context context, List<Message> messages) {
        this.messages = messages;
        ctx = context;
    }

    public class OriginalViewHolder extends RecyclerView.ViewHolder {
        public TextView messageText;
        public ImageView messageImage;

        public OriginalViewHolder(View v) {
            super(v);
            messageText =  v.findViewById(R.id.outgoing_message_text);
            messageImage = v.findViewById(R.id.outgoing_message_image);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        View v = LayoutInflater
            .from(parent.getContext()).inflate(R.layout.item_chat_sent_message, parent, false);
        vh = new ChatRecyclerViewAdapter.OriginalViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof ChatRecyclerViewAdapter.OriginalViewHolder) {
            ChatRecyclerViewAdapter.OriginalViewHolder view = (ChatRecyclerViewAdapter.OriginalViewHolder) holder;

            Message message = messages.get(position);
            view.messageText.setText(message.getData());
            view.messageImage.setVisibility(View.GONE);

        }
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }
}
