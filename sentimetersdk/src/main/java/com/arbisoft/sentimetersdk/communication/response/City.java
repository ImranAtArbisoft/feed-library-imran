package com.arbisoft.sentimetersdk.communication.response;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Imran on 6/14/2016.
 */
public class City implements Parcelable {
    public long id;
    public String name;
    public long region;

    protected City(Parcel in) {
        id = in.readLong();
        name = in.readString();
        region = in.readLong();
    }

    public City(String name) {
        id = -1;
        this.name = name;
        region = -1;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(name);
        dest.writeLong(region);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<City> CREATOR = new Creator<City>() {
        @Override
        public City createFromParcel(Parcel in) {
            return new City(in);
        }

        @Override
        public City[] newArray(int size) {
            return new City[size];
        }
    };
}
