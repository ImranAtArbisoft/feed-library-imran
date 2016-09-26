package com.arbisoft.sentimetersdk.communication.response;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Imran on 6/14/2016.
 */
public class Branch implements Parcelable {
    public long id;
    public String name;
    public float latitude;
    public float longitude;
    public long benchmark_count;
    public long city;

    public Branch(String name) {
        id = -1;
        this.name = name;
        latitude = -1;
        longitude = 0;
        benchmark_count = 0;
        city = -1;
    }

    protected Branch(Parcel in) {
        id = in.readLong();
        name = in.readString();
        latitude = in.readFloat();
        longitude = in.readFloat();
        benchmark_count = in.readLong();
        city = in.readLong();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(name);
        dest.writeFloat(latitude);
        dest.writeFloat(longitude);
        dest.writeLong(benchmark_count);
        dest.writeLong(city);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Branch> CREATOR = new Creator<Branch>() {
        @Override
        public Branch createFromParcel(Parcel in) {
            return new Branch(in);
        }

        @Override
        public Branch[] newArray(int size) {
            return new Branch[size];
        }
    };
}
