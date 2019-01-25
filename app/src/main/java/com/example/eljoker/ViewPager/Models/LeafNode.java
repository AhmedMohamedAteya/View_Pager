package com.example.eljoker.ViewPager.Models;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class LeafNode implements Parcelable {

  @SerializedName("description")
  @Expose
  private String description;
  @SerializedName("value")
  @Expose
  private String value;
  public void setDescription(String description){
   this.description=description;
  }
  public String getDescription(){
   return description;
  }
  public void setValue(String value){
   this.value=value;
  }
  public String getValue(){
   return value;
  }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.description);
        dest.writeString(this.value);
    }

    public LeafNode() {
    }

    protected LeafNode(Parcel in) {
        this.description = in.readString();
        this.value = in.readString();
    }

    public static final Parcelable.Creator<LeafNode> CREATOR = new Parcelable.Creator<LeafNode>() {
        @Override
        public LeafNode createFromParcel(Parcel source) {
            return new LeafNode(source);
        }

        @Override
        public LeafNode[] newArray(int size) {
            return new LeafNode[size];
        }
    };
}