package com.arbisoft.sentimetersdk.communication.response;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Imran on 6/16/2016.
 */
public class User implements Parcelable {
    public long id;
    public String last_name;
    public String email;
    public Branch branch;
    public String phone_no;
    public int role;
    public User parent;
    public String first_name;
    public String username;
    public boolean is_active;
    public Region region;

    protected User(Parcel in) {
        id = in.readLong();
        last_name = in.readString();
        email = in.readString();
        branch = in.readParcelable(Branch.class.getClassLoader());
        phone_no = in.readString();
        role = in.readInt();
        parent = in.readParcelable(User.class.getClassLoader());
        first_name = in.readString();
        username = in.readString();
        is_active = in.readByte() != 0;
        region = in.readParcelable(Region.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(last_name);
        dest.writeString(email);
        dest.writeParcelable(branch, flags);
        dest.writeString(phone_no);
        dest.writeInt(role);
        dest.writeParcelable(parent, flags);
        dest.writeString(first_name);
        dest.writeString(username);
        dest.writeByte((byte) (is_active ? 1 : 0));
        dest.writeParcelable(region, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
