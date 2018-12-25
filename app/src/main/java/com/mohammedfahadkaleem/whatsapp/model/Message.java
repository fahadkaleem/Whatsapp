package com.mohammedfahadkaleem.whatsapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Message {

  @SerializedName("type")
  @Expose
  private String type;
  @SerializedName("data")
  @Expose
  private String data;

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

}

