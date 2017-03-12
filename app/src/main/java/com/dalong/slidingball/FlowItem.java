package com.dalong.slidingball;

public class FlowItem {
    private String name;
    private int imageResId;
    private boolean isSelected;

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
