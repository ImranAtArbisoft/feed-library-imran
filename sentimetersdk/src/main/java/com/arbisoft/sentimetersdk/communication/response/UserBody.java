package com.arbisoft.sentimetersdk.communication.response;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public class UserBody implements Parcelable {
    private String first_name;
    private String last_name;
    private String email;
    private String phone_no;
    private Integer gender;
    private Long ageGroup;//Index of selected button 0 to 5
    private String dob;
    private String waiter;

    public UserBody() {
    }

    protected UserBody(Parcel in) {
        first_name = in.readString();
        last_name = in.readString();
        email = in.readString();
        phone_no = in.readString();
        gender = in.readByte() == 0x00 ? null : in.readInt();
        ageGroup = in.readByte() == 0x00 ? null : in.readLong();
        dob = in.readString();
        waiter = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(first_name);
        dest.writeString(last_name);
        dest.writeString(email);
        dest.writeString(phone_no);
        if (gender == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(gender);
        }
        if (ageGroup == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeLong(ageGroup);
        }
        dest.writeString(dob);
        dest.writeString(waiter);
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public long getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(long ageGroup) {
        this.ageGroup = ageGroup;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<UserBody> CREATOR = new Creator<UserBody>() {
        @Override
        public UserBody createFromParcel(Parcel in) {
            return new UserBody(in);
        }

        @Override
        public UserBody[] newArray(int size) {
            return new UserBody[size];
        }
    };

    public void populateFrom(UserBody body) {
        if (!TextUtils.isEmpty(body.first_name)) {
            setFirst_name(body.first_name);
        }
        if (!TextUtils.isEmpty(body.last_name)) {
            setLast_name(body.last_name);
        }
        if (!TextUtils.isEmpty(body.email)) {
            setEmail(body.email);
        }
        if (!TextUtils.isEmpty(body.phone_no)) {
            setPhone_no(body.phone_no);
        }
        if (!TextUtils.isEmpty(body.dob)) {
            setDob(body.dob);
        }
        if (!TextUtils.isEmpty(body.waiter)) {
            setWaiter(body.waiter);
        }
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDob() {
        return dob;
    }

    public void setWaiter(String waiter) {
        this.waiter = waiter;
    }

    public String getWaiter() {
        return waiter;
    }
}