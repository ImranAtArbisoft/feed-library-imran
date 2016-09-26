package com.arbisoft.sentimetersdk.communication.response;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Imran on 6/14/2016.
 */
public class AreaResponse extends BaseResponse implements Parcelable {
    public List<Area> response;


    protected AreaResponse(Parcel in) {
        super(in);
        response = in.createTypedArrayList(Area.CREATOR);
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

    public static final Creator<AreaResponse> CREATOR = new Creator<AreaResponse>() {
        @Override
        public AreaResponse createFromParcel(Parcel in) {
            return new AreaResponse(in);
        }

        @Override
        public AreaResponse[] newArray(int size) {
            return new AreaResponse[size];
        }
    };
}
