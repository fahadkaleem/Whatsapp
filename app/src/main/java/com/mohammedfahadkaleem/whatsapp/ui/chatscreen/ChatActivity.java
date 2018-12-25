package com.mohammedfahadkaleem.whatsapp.ui.chatscreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.mohammedfahadkaleem.whatsapp.R;
import com.mohammedfahadkaleem.whatsapp.model.User;

public class ChatActivity extends AppCompatActivity {

  public static final String EXTRAS_USER= "user";
  public static final String tag = ChatActivity.class.getSimpleName();
  private User user;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_chat);
    Intent intent = getIntent();
    user = intent.getParcelableExtra(EXTRAS_USER);
    init();
  }

  private void init() {
    initView();
  }

  private void initView() {
    initToolbar();
    showFragment();
  }

  private void showFragment()
  {
    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
    ft.replace(R.id.chats_frame_layout, new ChatFragment());
    ft.commit();
  }



  private void initToolbar()
  {
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    TextView user_name = findViewById(R.id.user_name);
    ImageView user_profile_picture = findViewById(R.id.display_picture);
    user_name.setText(user.name);
    user_profile_picture.setImageResource(user.image);


    toolbar.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Log.e("Toolbar","Clicked");
      }
    });
  }

  @Override
  public boolean onSupportNavigateUp() {
    onBackPressed();
    return true;
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_chat, menu);
    return true;
  }

  @Override
  protected void onStart() {
    super.onStart();
    Log.d(tag, " onStart()");
  }

  @Override
  protected void onResume() {
    super.onResume();
    Log.d(tag, " onResume()");
  }

  @Override
  protected void onPause() {
    super.onPause();
    Log.d(tag, " onPause()");
  }

  @Override
  protected void onStop() {
    super.onStop();
    Log.d(tag, " onStop()");
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    Log.d(tag, " onDestroy()");
  }
}
