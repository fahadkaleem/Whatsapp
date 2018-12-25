package com.mohammedfahadkaleem.whatsapp.ui.mainscreen.camerascreen;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mohammedfahadkaleem.whatsapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CameraFragment extends Fragment {


  public CameraFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View rootView = inflater.inflate(R.layout.fragment_camera, container, false);
    //rootView.findViewById(R.id.fab).setVisibility(View.INVISIBLE);
    return rootView;
  }

}
