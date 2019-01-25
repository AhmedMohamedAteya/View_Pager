
package com.example.eljoker.ViewPager.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubNode implements Parcelable {
    @SerializedName("iteration")
    @Expose
    private Integer iteration;
    @SerializedName("leafNode")
    @Expose
    private LeafNode leafNode;
    public void setIteration(Integer iteration){
        this.iteration=iteration;
    }
    public Integer getIteration(){
        return iteration;
    }
    public void setLeafNode(LeafNode leafNode){
        this.leafNode=leafNode;
    }
    public LeafNode getLeafNode(){
        return leafNode;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.iteration);
        dest.writeParcelable(this.leafNode, flags);
    }

    public SubNode() {
    }

    protected SubNode(Parcel in) {
        this.iteration = (Integer) in.readValue(Integer.class.getClassLoader());
        this.leafNode = in.readParcelable(LeafNode.class.getClassLoader());
    }

    public static final Parcelable.Creator<SubNode> CREATOR = new Parcelable.Creator<SubNode>() {
        @Override
        public SubNode createFromParcel(Parcel source) {
            return new SubNode(source);
        }

        @Override
        public SubNode[] newArray(int size) {
            return new SubNode[size];
        }
    };
}