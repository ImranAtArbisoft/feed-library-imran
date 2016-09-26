package com.arbisoft.sentimetersdk.communication.response;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Imran on 6/14/2016.
 */
public class Region implements Parcelable {
    public long id;
    public String name;
    public long area;

    protected Region(Parcel in) {
        id = in.readLong();
        name = in.readString();
        area = in.readLong();
    }

    public Region(String name) {
        id = -1;
        this.name = name;
        area = -1;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(name);
        dest.writeLong(area);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Region> CREATOR = new Creator<Region>() {
        @Override
        public Region createFromParcel(Parcel in) {
            return new Region(in);
        }

        @Override
        public Region[] newArray(int size) {
            return new Region[size];
        }
    };
}
