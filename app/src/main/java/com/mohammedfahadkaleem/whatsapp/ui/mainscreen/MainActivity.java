package com.mohammedfahadkaleem.whatsapp.ui.mainscreen;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.mohammedfahadkaleem.whatsapp.R;
import com.mohammedfahadkaleem.whatsapp.ui.contactslistscreen.ContactsListActivity;
import com.mohammedfahadkaleem.whatsapp.ui.settingscreen.SettingsActivity;

public class MainActivity extends AppCompatActivity {

  private SectionsPagerAdapter mSectionsPagerAdapter;
  public FloatingActionButton floatingActionButton;
  private ViewPager mViewPager;
  private int[] fabIconArray = {R.drawable.ic_fab_message,R.drawable.ic_fab_message,R.drawable.ic_photo_camera,R.drawable.ic_call_white};

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

    setupViewPager();


    floatingActionButton = findViewById(R.id.fab);

    floatingActionButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        // Handle the click.
        Intent newMessageIntent = new Intent(MainActivity.this,ContactsListActivity.class);
        startActivity(newMessageIntent);
      }
    });

  }

  private void setupViewPager() {
    mViewPager = findViewById(R.id.container);
    mViewPager.setAdapter(mSectionsPagerAdapter);
    setupTabLayout();

    mViewPager.addOnPageChangeListener(new OnPageChangeListener() {
      @Override
      public void onPageScrolled(int i, float v, int i1) {
      }

      @Override
      public void onPageSelected(int page) {
      }

      @Override
      public void onPageScrollStateChanged(int state) {
        switch (state) {
          case ViewPager.SCROLL_STATE_SETTLING:
            // This is triggered just before the view pager reaches the final state
            // if you want to trigger the animation after the page reaches its final position
            // just move this to "case ViewPager.SCROLL_STATE_IDLE:"
            showFloatingActionButton(mViewPager.getCurrentItem());
            break;
          case ViewPager.SCROLL_STATE_IDLE:
            // This is only triggered if user pulls to the left of the start or right of the end
            showFloatingActionButton(mViewPager.getCurrentItem());
            break;
          default:
            // in all other cases just hide the fab if it is not visable
            floatingActionButton.hide();
        }
      }
    });
  }

  private void showFloatingActionButton (int position){
    if(position==0) floatingActionButton.hide();
    else {
      floatingActionButton.setImageDrawable(getResources().getDrawable(fabIconArray[position], null));
      floatingActionButton.show();
    }
  }


  public void setupTabLayout(){
    TabLayout tabLayout = findViewById(R.id.tabs);
    tabLayout.setupWithViewPager(mViewPager);
    mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
    tabLayout.getTabAt(0).setIcon(R.drawable.ic_camera);
    //tabLayout.getTabAt(0).getIcon().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);
    tabLayout.getTabAt(0).getIcon().setColorFilter(getResources().getColor(R.color.grey_20), PorterDuff.Mode.SRC_IN);
    tabLayout.getTabAt(1).setText("CHATS");
    tabLayout.getTabAt(2).setText("STATUS");
    tabLayout.getTabAt(3).setText("CALLS");
    LinearLayout layout = ((LinearLayout) ((LinearLayout) tabLayout.getChildAt(0)).getChildAt(0));
    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) layout.getLayoutParams();
    layoutParams.weight = 0.4f; // e.g. 0.5f
    layout.setLayoutParams(layoutParams);
    mViewPager.setCurrentItem(1);
  }


  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      Intent intent = new Intent(MainActivity.this,SettingsActivity.class);
      startActivity(intent);
      return true;
    }

    if (id == R.id.action_search){
      Toast.makeText(this, R.string.action_search, Toast.LENGTH_SHORT).show();
      return true;
    }

    return super.onOptionsItemSelected(item);
  }

}
