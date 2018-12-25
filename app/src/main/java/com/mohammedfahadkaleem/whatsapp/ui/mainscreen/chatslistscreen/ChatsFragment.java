package com.mohammedfahadkaleem.whatsapp.ui.mainscreen.chatslistscreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.mohammedfahadkaleem.whatsapp.R;
import com.mohammedfahadkaleem.whatsapp.data.DummyDataGenerator;
import com.mohammedfahadkaleem.whatsapp.model.User;
import com.mohammedfahadkaleem.whatsapp.ui.chatscreen.ChatActivity;
import java.util.List;


public class ChatsFragment extends Fragment {
  private View rootView;
  private RecyclerView recyclerView;
  private ChatsRecyclerViewAdapter mAdapter;

  public ChatsFragment() {
    // Required empty public constructor
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    rootView = inflater.inflate(R.layout.fragment_chats, container, false);
    setHasOptionsMenu(true);
    recyclerView = rootView.findViewById(R.id.chatsRecyclerView);
    initComponent();
    return rootView;
  }

  private void initComponent() {
    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    recyclerView.setHasFixedSize(true);

    final List<User> items = DummyDataGenerator.getContactsData(getActivity());
    items.addAll(DummyDataGenerator.getContactsData(getActivity()));
    items.addAll(DummyDataGenerator.getContactsData(getActivity()));

    //set data and list adapter
    mAdapter = new ChatsRecyclerViewAdapter(getActivity(), items);
    recyclerView.setAdapter(mAdapter);

    // on item list clicked
    mAdapter.setOnItemClickListener(new ChatsRecyclerViewAdapter.OnItemClickListener() {
      @Override
      public void onItemClick(View view, User obj, int position) {
        Intent intent = new Intent(getActivity(),ChatActivity.class);
        intent.putExtra("user",items.get(position));
        startActivity(intent);
        //Snackbar.make(view, "Item " + obj.user_name + " clicked", Snackbar.LENGTH_SHORT).show();
      }
    });

  }

  @Override
  public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
    inflater.inflate(R.menu.menu_chats,menu);
    super.onCreateOptionsMenu(menu,inflater);
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.action_new_group:
        Toast.makeText(getActivity(), R.string.action_new_group, Toast.LENGTH_SHORT).show();
        return true;
      case R.id.action_new_broadcast:
        Toast.makeText(getActivity(), R.string.action_new_broadcast, Toast.LENGTH_SHORT).show();
        return true;
      case R.id.action_whatsapp_web:
        Toast.makeText(getActivity(), R.string.action_whatsapp_web, Toast.LENGTH_SHORT).show();
        return true;
      case R.id.action_starred_messages:
        Toast.makeText(getActivity(), R.string.action_starred_messages, Toast.LENGTH_SHORT).show();
        return true;
      default:
        return super.onOptionsItemSelected(item);
    }
  }
}
