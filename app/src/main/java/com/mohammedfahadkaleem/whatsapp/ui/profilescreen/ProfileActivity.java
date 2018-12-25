package com.mohammedfahadkaleem.whatsapp.ui.profilescreen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.Toast;
import com.mohammedfahadkaleem.whatsapp.R;

public class ProfileActivity extends AppCompatActivity {
  //SwitchCompat muteNotifications;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_profile);
    //muteNotifications = findViewById(R.id.switch_mute_notifications);
    //muteNotifications.setOnCheckedChangeListener(onCheckedChanged());
    initToolbar();

  }

  private void initToolbar() {
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_profile, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    if (item.getItemId() == android.R.id.home) {
      finish();
    } else {
      Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
    }
    return super.onOptionsItemSelected(item);
  }

  private CompoundButton.OnCheckedChangeListener onCheckedChanged() {
    return new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
/*          case R.id.switch_mute_notifications:
            //setButtonState(isChecked);
            break;*/
        }
      }
    };
  }

}
