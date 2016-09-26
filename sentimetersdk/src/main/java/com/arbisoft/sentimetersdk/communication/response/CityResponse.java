package com.arbisoft.sentimetersdk.communication.response;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Imran on 6/14/2016.
 */
public class CityResponse extends BaseResponse implements Parcelable {
    public List<City> response;


    protected CityResponse(Parcel in) {
        super(in);
        response = in.createTypedArrayList(City.CREATOR);
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

    public static final Creator<CityResponse> CREATOR = new Creator<CityResponse>() {
        @Override
        public CityResponse createFromParcel(Parcel in) {
            return new CityResponse(in);
        }

        @Override
        public CityResponse[] newArray(int size) {
            return new CityResponse[size];
        }
    };
}
