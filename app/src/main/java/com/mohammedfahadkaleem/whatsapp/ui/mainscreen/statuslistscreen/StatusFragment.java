package com.mohammedfahadkaleem.whatsapp.ui.mainscreen.statuslistscreen;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
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
import java.util.List;


public class StatusFragment extends Fragment {
  private View rootView;
  private RecyclerView recyclerView;
  private StatusRecyclerViewAdapter mAdapter;
  private Context context = getActivity();

  public StatusFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    rootView =  inflater.inflate(R.layout.fragment_status, container, false);
    setHasOptionsMenu(true);
    recyclerView = rootView.findViewById(R.id.status_recent_updates_recycler_view);
    initComponent();
    return rootView;
  }

  private void initComponent() {
    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    recyclerView.setHasFixedSize(true);

    List<User> items = DummyDataGenerator.getStatusData(getActivity());

    //set data and list adapter
    mAdapter = new StatusRecyclerViewAdapter(getActivity(), items);
    recyclerView.setAdapter(mAdapter);

    // on item list clicked
    mAdapter.setOnItemClickListener(new StatusRecyclerViewAdapter.OnItemClickListener() {
      @Override
      public void onItemClick(View view, User obj, int position) {
        Snackbar.make(view, "Item " + obj.name + " clicked", Snackbar.LENGTH_SHORT).show();
      }
    });

  }

  @Override
  public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
    inflater.inflate(R.menu.menu_status,menu);
    super.onCreateOptionsMenu(menu,inflater);
  }

}
