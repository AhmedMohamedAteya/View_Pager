
package com.example.eljoker.ViewPager.Models;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class AzkarModel implements Parcelable {

    @SerializedName("hasReminder")
    @Expose
    private Boolean hasReminder;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("subNodes")
    @Expose
    private List<SubNode> subNodes;
    @SerializedName("isFavourite")
    @Expose
    private Boolean isFavourite;
    public void setHasReminder(Boolean hasReminder){
        this.hasReminder=hasReminder;
    }
    public Boolean getHasReminder(){
        return hasReminder;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setId(Integer id){
        this.id=id;
    }
    public Integer getId(){
        return id;
    }
    public void setSubNodes(List<SubNode> subNodes){
        this.subNodes=subNodes;
    }
    public List<SubNode> getSubNodes(){
        return subNodes;
    }
    public void setIsFavourite(Boolean isFavourite){
        this.isFavourite=isFavourite;
    }
    public Boolean getIsFavourite(){
        return isFavourite;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.hasReminder);
        dest.writeString(this.name);
        dest.writeValue(this.id);
        dest.writeList(this.subNodes);
        dest.writeValue(this.isFavourite);
    }

    public AzkarModel() {
    }

    protected AzkarModel(Parcel in) {
        this.hasReminder = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.name = in.readString();
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.subNodes = new ArrayList<SubNode>();
        in.readList(this.subNodes, SubNode.class.getClassLoader());
        this.isFavourite = (Boolean) in.readValue(Boolean.class.getClassLoader());
    }

    public static final Parcelable.Creator<AzkarModel> CREATOR = new Parcelable.Creator<AzkarModel>() {
        @Override
        public AzkarModel createFromParcel(Parcel source) {
            return new AzkarModel(source);
        }

        @Override
        public AzkarModel[] newArray(int size) {
            return new AzkarModel[size];
        }
    };
}
