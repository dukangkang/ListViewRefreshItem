package com.docking.refresh.item;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by docking on 16/7/14 09:21.
 */
public class TestEntity implements Parcelable {
    String url;
    String title;
    String desc;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.url);
        dest.writeString(this.title);
        dest.writeString(this.desc);
    }

    public TestEntity() {
    }

    protected TestEntity(Parcel in) {
        this.url = in.readString();
        this.title = in.readString();
        this.desc = in.readString();
    }

    public static final Parcelable.Creator<TestEntity> CREATOR = new Parcelable.Creator<TestEntity>() {
        @Override
        public TestEntity createFromParcel(Parcel source) {
            return new TestEntity(source);
        }

        @Override
        public TestEntity[] newArray(int size) {
            return new TestEntity[size];
        }
    };
}
