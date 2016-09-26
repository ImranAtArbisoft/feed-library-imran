package com.arbisoft.sentimetersdk.communication.response;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Imran on 6/16/2016.
 */
public class Option implements Parcelable {
    public long id;
    public int sequence;
    public int score;
    public String text_urdu;
    public List<Option> children;
    public String text;
    public boolean isActive;
    public String color_code;
    public String created_at;

    protected Option(Parcel in) {
        id = in.readLong();
        sequence = in.readInt();
        score = in.readInt();
        text_urdu = in.readString();
        children = in.createTypedArrayList(Option.CREATOR);
        text = in.readString();
        isActive = in.readByte() != 0;
        color_code = in.readString();
        created_at = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeInt(sequence);
        dest.writeInt(score);
        dest.writeString(text_urdu);
        dest.writeTypedList(children);
        dest.writeString(text);
        dest.writeByte((byte) (isActive ? 1 : 0));
        dest.writeString(color_code);
        dest.writeString(created_at);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Option> CREATOR = new Creator<Option>() {
        @Override
        public Option createFromParcel(Parcel in) {
            return new Option(in);
        }

        @Override
        public Option[] newArray(int size) {
            return new Option[size];
        }
    };
}
