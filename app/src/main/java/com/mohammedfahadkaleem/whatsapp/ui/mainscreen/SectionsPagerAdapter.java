package com.mohammedfahadkaleem.whatsapp.ui.mainscreen;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.mohammedfahadkaleem.whatsapp.ui.mainscreen.callslistscreen.CallsFragment;
import com.mohammedfahadkaleem.whatsapp.ui.mainscreen.camerascreen.CameraFragment;
import com.mohammedfahadkaleem.whatsapp.ui.mainscreen.chatslistscreen.ChatsFragment;
import com.mohammedfahadkaleem.whatsapp.ui.mainscreen.statuslistscreen.StatusFragment;

/**
 * Created by fahadkaleem on 12/12/18.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

  public SectionsPagerAdapter(FragmentManager fm) {
    super(fm);
  }

  @Override
  public Fragment getItem(int position) {
    // getItem is called to instantiate the fragment for the given page.
    // Return a PlaceholderFragment (defined as a static inner class below).
    switch (position){
      case 0: {
        return new CameraFragment();
      }
      case 1: {
        return new ChatsFragment();

      }
      case 2: {
        return new StatusFragment();
      }
      case 3: {
        return new CallsFragment();
      }
      default: return null;
    }
  }

  @Override
  public int getCount() {
    // Show 3 total pages.
    return 4;
  }

}
