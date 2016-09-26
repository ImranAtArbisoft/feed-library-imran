package com.arbisoft.sentimetersdk;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by Imran on 6/16/2016.
 */
public interface ActivityImplementation {
    void showWelcome(Bundle bundle);

    void showWelcomeWithPromotion(Bundle bundle);

    void showWelcomeWithQuestionnaire(Bundle bundle);

    void showChooseLanguageScreen(Bundle bundle);

    void showNextScreen(Fragment fragment);

    void onBack(String tag);

    void onFeedbackFinished();
}
