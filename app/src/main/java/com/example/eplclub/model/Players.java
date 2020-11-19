package com.example.eplclub.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Players implements Parcelable {

    private String name;
    private String position;
    private String backNumber;

    public Players(String name, String position, String backNumber) {
        this.name = name;
        this.position = position;
        this.backNumber = backNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getBackNumber() {
        return backNumber;
    }

    public void setBackNumber(String backNumber) {
        this.backNumber = backNumber;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.position);
        dest.writeString(this.backNumber);
    }

    protected Players(Parcel in) {
        this.name = in.readString();
        this.position = in.readString();
        this.backNumber = in.readString();
    }

    public static final Parcelable.Creator<Players> CREATOR = new Parcelable.Creator<Players>() {
        @Override
        public Players createFromParcel(Parcel source) {
            return new Players(source);
        }

        @Override
        public Players[] newArray(int size) {
            return new Players[size];
        }
    };
}
