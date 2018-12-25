package com.mohammedfahadkaleem.whatsapp.ui.settingscreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;
import com.mohammedfahadkaleem.whatsapp.R;
import com.mohammedfahadkaleem.whatsapp.accountsettingsscreen.AccountSettingsActivity;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {
  View settingAccount;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_settings);
    setupToolbar();

    settingAccount = findViewById(R.id.settings_account);
    settingAccount.setOnClickListener(this);
  }

  private void setupToolbar() {
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
  }

  @Override
  public boolean onSupportNavigateUp() {
    onBackPressed();
    return true;
  }


  @Override
  public void onClick(View view) {
    switch (view.getId()){
      case R.id.settings_account:
        Toast.makeText(this,"Pressed",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(SettingsActivity.this,AccountSettingsActivity.class);
        startActivity(intent);
        return;
      default:
        return;
    }
  }
}
