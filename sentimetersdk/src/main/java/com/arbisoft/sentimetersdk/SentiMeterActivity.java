package com.arbisoft.sentimetersdk;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SentiMeterActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBindingUtil.setContentView(this, R.layout.activity_sentimeter);
//        if (savedInstanceState == null) {
//            UploadFeedbackService.startServiceIfNecessary(this);
//            Branch branch = FlowManager.getBranch(this);
//            City city = FlowManager.getCity(this);
//            mDataBinding.bottom.servedBy.setText(getString(R.string.label_served_by, city != null ? city.name : "", branch != null ? branch.name : ""));
//            ClientQuestionResponse questionResponse = CacheUtils.getClientQuestions(this);
//            if (isNetworkAvailable()) {
//                getQuestions(branch != null ? branch.id : -1, true);
//            } else if (questionResponse != null) {
//                showMainFragment(questionResponse);
//            }
//        }
//        showShimerEffect(mDataBinding.topLogo);
    }


}
