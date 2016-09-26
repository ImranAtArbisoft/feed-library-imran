package com.arbisoft.sentimetersdk.communication.response;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Imran on 6/14/2016.
 */
public class BranchResponse extends BaseResponse implements Parcelable {
    public List<Branch> response;


    protected BranchResponse(Parcel in) {
        super(in);
        response = in.createTypedArrayList(Branch.CREATOR);
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

    public static final Creator<BranchResponse> CREATOR = new Creator<BranchResponse>() {
        @Override
        public BranchResponse createFromParcel(Parcel in) {
            return new BranchResponse(in);
        }

        @Override
        public BranchResponse[] newArray(int size) {
            return new BranchResponse[size];
        }
    };
}
