package org.mosa.calculator;

import android.app.Application;

import com.google.android.material.color.DynamicColors;

public class CalculatorApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        DynamicColors.applyToActivitiesIfAvailable(this);
    }
}
