package com.tikeyc.tikeycandroid.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by public1 on 2017/5/31.
 */

public class THomeUserItem implements MultiItemEntity {

    public static final int User_Attentions = 0;
    public static final int User_Normal = 1;

    private int itemType;

    private String title;

    public THomeUserItem(int itemType, String title) {
        this.itemType = itemType;
        this.title = title;
    }

    public int getItemType() {
        return itemType;
    }

    public String getTitle() {
        return title;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
