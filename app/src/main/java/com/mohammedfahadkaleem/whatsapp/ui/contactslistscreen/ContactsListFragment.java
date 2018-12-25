package com.mohammedfahadkaleem.whatsapp.ui.contactslistscreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mohammedfahadkaleem.whatsapp.R;
import com.mohammedfahadkaleem.whatsapp.data.DummyDataGenerator;
import com.mohammedfahadkaleem.whatsapp.model.User;
import com.mohammedfahadkaleem.whatsapp.ui.chatscreen.ChatActivity;
import java.util.List;


public class ContactsListFragment extends Fragment{
  private View rootView;
  private RecyclerView recyclerView;
  private ContactsListRecyclerViewAdapter mAdapter;

  public static ContactsListFragment newInstance() {
    Bundle args = new Bundle();
    ContactsListFragment fragment = new ContactsListFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    rootView = inflater.inflate(R.layout.fragment_contacts_list, container, false);
    setHasOptionsMenu(true);
    recyclerView = rootView.findViewById(R.id.contactsListRecyclerView);
    initComponent();
    return rootView;
  }

  private void initComponent() {
    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    recyclerView.setHasFixedSize(true);

    List<User> items = DummyDataGenerator.getContactsListData(getActivity());
    items.addAll(DummyDataGenerator.getContactsListData(getActivity()));
    items.addAll(DummyDataGenerator.getContactsListData(getActivity()));
    items.addAll(DummyDataGenerator.getContactsListData(getActivity()));
    items.addAll(DummyDataGenerator.getContactsListData(getActivity()));
    items.addAll(DummyDataGenerator.getContactsListData(getActivity()));
    items.addAll(DummyDataGenerator.getContactsListData(getActivity()));

    //set data and list adapter
    mAdapter = new ContactsListRecyclerViewAdapter(getActivity(), items);
    recyclerView.setAdapter(mAdapter);

    // on item list clicked
    mAdapter.setOnItemClickListener(new ContactsListRecyclerViewAdapter.OnItemClickListener() {
      @Override
      public void onItemClick(View view, User obj, int position) {
        Intent intent = new Intent(getActivity(),ChatActivity.class);
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

}