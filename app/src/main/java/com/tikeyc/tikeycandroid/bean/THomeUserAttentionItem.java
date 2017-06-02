package com.tikeyc.tikeycandroid.bean;

/**
 * Created by public1 on 2017/5/31.
 */

public class THomeUserAttentionItem {

    private int imageId;

    private String userName;

    public THomeUserAttentionItem(int imageId, String userName) {
        this.imageId = imageId;
        this.userName = userName;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getImageId() {

        return imageId;
    }

    public String getUserName() {
        return userName;
    }
}
