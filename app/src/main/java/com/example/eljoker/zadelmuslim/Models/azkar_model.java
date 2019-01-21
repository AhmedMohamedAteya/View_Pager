package com.example.eljoker.zadelmuslim.Models;

import java.util.ArrayList;

public class azkar_model
{
    String items, value, description, iteration;
    String id;
    int leafNode;

    public azkar_model() {
    }

    public int getLeafNode() {
        return leafNode;
    }

    public azkar_model(String items) {
        this.items = items;
    }

    public void setLeafNode(int leafNode) {
        this.leafNode = leafNode;
    }

    public String getIteration() {
        return iteration;
    }

    public void setIteration(String iteration) {
        this.iteration = iteration;
    }

    boolean hasReminder;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isHasReminder() {
        return hasReminder;
    }

    public void setHasReminder(boolean hasReminder) {
        this.hasReminder = hasReminder;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items)
    {
        this.items = items;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

/*
    public azkar_model(String items, int id)
    {
        this.items = items;
        this.id = id;
    }
*/
}
