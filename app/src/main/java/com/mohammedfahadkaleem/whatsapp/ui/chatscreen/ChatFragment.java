package com.mohammedfahadkaleem.whatsapp.ui.chatscreen;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mohammedfahadkaleem.whatsapp.R;
import com.mohammedfahadkaleem.whatsapp.data.DummyDataGenerator;
import com.mohammedfahadkaleem.whatsapp.model.Message;
import java.util.List;


/**
 * Created by vihaan on 22/05/17.
 */

public class ChatFragment extends Fragment {
  RecyclerView chatRecyclerView;
  ChatRecyclerViewAdapter mAdapter;

  public static ChatFragment newInstance(Bundle bundle) {
    ChatFragment fragment = new ChatFragment();
    fragment.setArguments(bundle);
    return fragment;
  }


  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    super.onCreateView(inflater, container, savedInstanceState);
    View rootView = inflater.inflate(R.layout.fragment_chat, container, false);
    chatRecyclerView = rootView.findViewById(R.id.chatsRecyclerView);
    initComponent();
    return rootView;
  }

  private void initComponent() {
    chatRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    chatRecyclerView.setHasFixedSize(true);

    List<Message> messageList = DummyDataGenerator.getMessageData(getActivity());
    messageList.addAll(DummyDataGenerator.getMessageData(getActivity()));
    messageList.addAll(DummyDataGenerator.getMessageData(getActivity()));
    messageList.addAll(DummyDataGenerator.getMessageData(getActivity()));
    messageList.addAll(DummyDataGenerator.getMessageData(getActivity()));
    messageList.addAll(DummyDataGenerator.getMessageData(getActivity()));

    //set data and list adapter
    mAdapter = new ChatRecyclerViewAdapter(getActivity(), messageList);
    chatRecyclerView.setAdapter(mAdapter);

  }


}
