package com.arbisoft.sentimetersdk.communication.response;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Imran on 6/16/2016.
 */
public class BranchGroResponse extends BaseResponse implements Parcelable {
    public List<User> response;

    protected BranchGroResponse(Parcel in) {
        super(in);
        response = in.createTypedArrayList(User.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeTypedList(response);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<BranchGroResponse> CREATOR = new Creator<BranchGroResponse>() {
        @Override
        public BranchGroResponse createFromParcel(Parcel in) {
            return new BranchGroResponse(in);
        }

        @Override
        public BranchGroResponse[] newArray(int size) {
            return new BranchGroResponse[size];
        }
    };
}
