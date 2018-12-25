package com.mohammedfahadkaleem.whatsapp.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.support.annotation.DrawableRes;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

/**
 * Created by fahadkaleem on 12/12/18.
 */
public class Utils {
  public static void displayImageRound(final Context ctx, final ImageView img, @DrawableRes int drawable) {
    try {
      Glide.with(ctx)
          .asBitmap()
          .load(drawable)
          .into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
              img.setImageBitmap(resource);
            }
          });
    } catch (Exception e) {
    }
  }

  public static int getScreenHeight(){
    return Resources.getSystem().getDisplayMetrics().heightPixels;
  }
}
