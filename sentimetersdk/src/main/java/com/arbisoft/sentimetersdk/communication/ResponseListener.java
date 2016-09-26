package com.arbisoft.sentimetersdk.communication;

import com.arbisoft.sentimetersdk.communication.response.BaseResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Imran on 6/14/2016.
 * Custom callback
 */
public abstract class ResponseListener<T> implements Callback<T> {
    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            BaseResponse baseResponse = (BaseResponse) response.body();
            if (baseResponse.success) {
                onSuccess(response.body());
            } else {
                onError(call, new Throwable(baseResponse.toString()));
            }
        } else {
            onError(call, new Throwable(response.message()));
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        onError(call, t);
    }

    public abstract void onSuccess(T t);

    public abstract void onError(Call<T> call, Throwable t);
}
