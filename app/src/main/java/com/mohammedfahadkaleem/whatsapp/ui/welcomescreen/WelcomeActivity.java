package com.mohammedfahadkaleem.whatsapp.ui.welcomescreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.mohammedfahadkaleem.whatsapp.R;
import com.mohammedfahadkaleem.whatsapp.ui.verifyscreen.VerifyPhoneNumberActivity;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_welcome);
    findViewById(R.id.agreeNContinueTVBtn).setOnClickListener(this);
  }

  @Override
  public void onClick(View v) {
    switch(v.getId())
    {
      case R.id.agreeNContinueTVBtn:
        Intent intent = new Intent(this, VerifyPhoneNumberActivity.class);
        startActivity(intent);
        finish();
        break;
    }
  }

}
