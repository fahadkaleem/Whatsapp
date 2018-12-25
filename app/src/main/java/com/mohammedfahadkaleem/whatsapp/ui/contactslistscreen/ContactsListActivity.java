package com.mohammedfahadkaleem.whatsapp.ui.contactslistscreen;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import com.mohammedfahadkaleem.whatsapp.R;

public class ContactsListActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_contacts_list);
    initViews();
  }

  private void initViews()
  {
    initToolbar();
    showFragment();
  }

  private void initToolbar() {
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);

  }


  private void showFragment()
  {
    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
    ft.replace(R.id.contacts_list_frame_layout, ContactsListFragment.newInstance());
    ft.commit();
  }



  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_contacts_list, menu);
    return true;
  }

  @Override
  public boolean onSupportNavigateUp() {
    onBackPressed();
    return true;
  }
}