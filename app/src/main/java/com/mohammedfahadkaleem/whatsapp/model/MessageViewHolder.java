package com.mohammedfahadkaleem.whatsapp.model;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.mohammedfahadkaleem.whatsapp.R;

/**
 * Created by vihaan on 18/06/17.
 */

public class MessageViewHolder extends RecyclerView.ViewHolder {


    public ImageView chatIV;
    public TextView chatTV;
    public TextView timeTV;

    public MessageViewHolder(View itemView) {
        super(itemView);

        chatTV = (TextView)itemView.findViewById( R.id.outgoing_message_text);
        timeTV = (TextView)itemView.findViewById( R.id.message_time);
    }

    public void bindToMessage(Message message, View.OnClickListener starClickListener) {

//        if (!TextUtils.isEmpty(user.getProfilePicUrl())) {
//            Picasso.with(userIV.getContext()).load(user.getProfilePicUrl()).into(userIV);
//        }
        chatTV.setText(message.getData());
    }

}
