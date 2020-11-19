package com.example.eplclub.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class EplClubModel implements Parcelable {
    private String name;
    private List<Players> players;
    private int image;

    public EplClubModel() {
    }

    public EplClubModel(String name, List<Players> players, int image) {
        this.name = name;
        this.players = players;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }


    public List<Players> getPlayers() {
        return players;
    }

    public void setPlayers(List<Players> players) {
        this.players = players;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeTypedList(this.players);
        dest.writeInt(this.image);
    }

    protected EplClubModel(Parcel in) {
        this.name = in.readString();
        this.players = in.createTypedArrayList(Players.CREATOR);
        this.image = in.readInt();
    }

    public static final Creator<EplClubModel> CREATOR = new Creator<EplClubModel>() {
        @Override
        public EplClubModel createFromParcel(Parcel source) {
            return new EplClubModel(source);
        }

        @Override
        public EplClubModel[] newArray(int size) {
            return new EplClubModel[size];
        }
    };
}
