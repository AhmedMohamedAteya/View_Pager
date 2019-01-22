
package com.example.eljoker.ViewPager.Models;


import java.util.List;

public class AzkarModel
{
    private Integer id;
    private Boolean hasReminder;
    private String name;
    private List<SubNode> subNodes = null;
    private Boolean isFavourite;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getHasReminder() {
        return hasReminder;
    }

    public void setHasReminder(Boolean hasReminder) {
        this.hasReminder = hasReminder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubNode> getSubNodes() {
        return subNodes;
    }

    public void setSubNodes(List<SubNode> subNodes) {
        this.subNodes = subNodes;
    }

    public Boolean getIsFavourite() {
        return isFavourite;
    }

    public void setIsFavourite(Boolean isFavourite) {
        this.isFavourite = isFavourite;
    }

}
