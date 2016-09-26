package com.arbisoft.sentimetersdk.communication.response;

import android.app.Fragment;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Imran on 6/16/2016.
 */
public class Question extends BaseQuestion implements Parcelable {
    public long id;
    public int sequence;
    public String text_urdu;
    public String created_at;
    public List<Option> options;
    public String text;
    public String image;
    public boolean isActive;
    public int type;
    public int genreType;

    protected Question(Parcel in) {
        id = in.readLong();
        sequence = in.readInt();
        text_urdu = in.readString();
        created_at = in.readString();
        options = in.createTypedArrayList(Option.CREATOR);
        text = in.readString();
        image = in.readString();
        isActive = in.readByte() != 0;
        type = in.readInt();
        genreType = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeInt(sequence);
        dest.writeString(text_urdu);
        dest.writeString(created_at);
        dest.writeTypedList(options);
        dest.writeString(text);
        dest.writeString(image);
        dest.writeByte((byte) (isActive ? 1 : 0));
        dest.writeInt(type);
        dest.writeInt(genreType);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Question> CREATOR = new Creator<Question>() {
        @Override
        public Question createFromParcel(Parcel in) {
            return new Question(in);
        }

        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };

    @Override
    public Fragment getFragment() {
        return null;
    }
}
