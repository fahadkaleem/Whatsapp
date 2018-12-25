package com.mohammedfahadkaleem.whatsapp.model;

/**
 * Created by fahadkaleem on 12/12/18.
 */

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Comparator;

public class User implements Parcelable {

  public int image;
  public Drawable imageDrw;
  public String name;
  public String email;
  public String status;
  public String contactType;
  public int readReceipt;
  public Drawable readReceiptDrw;
  public int callIndicator;
  public Drawable callIndicatorDrw;
  public String message;
  public String statusTime;


  public static Comparator<User> ContactsNameComparator = new Comparator<User>() {
    @Override
    public int compare(User contact1, User contact2) {
      String contactName1 = contact1.name.toUpperCase();
      String contactName2 = contact2.name.toUpperCase();
      return contactName1.compareTo(contactName2);
    }
  };

  public User(Parcel in) {
    image = in.readInt();
    name = in.readString();
    email = in.readString();
    status = in.readString();
    contactType = in.readString();
    readReceipt = in.readInt();
    callIndicator = in.readInt();
    message = in.readString();
    statusTime = in.readString();
  }

  public static final Creator<User> CREATOR = new Creator<User>() {
    @Override
    public User createFromParcel(Parcel in) {
      return new User(in);
    }

    @Override
    public User[] newArray(int size) {
      return new User[size];
    }
  };

  public User() {

  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel parcel, int i) {
    parcel.writeInt(image);
    parcel.writeString(name);
    parcel.writeString(email);
    parcel.writeString(status);
    parcel.writeString(contactType);
    parcel.writeInt(readReceipt);
    parcel.writeInt(callIndicator);
    parcel.writeString(message);
    parcel.writeString(statusTime);
  }
}