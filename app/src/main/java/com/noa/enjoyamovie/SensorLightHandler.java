package com.noa.enjoyamovie;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.widget.Toast;

public class SensorLightHandler implements SensorEventListener {
    private Activity mActivity;
    private SensorManager mSensorManager;
    private Sensor mLightSensor;
    private AlertDialog.Builder mBuilder;
    private boolean mDialogShown = false;
    private int mCounter = 0;
    private float mPrevValueX = 0.0f;

    public SensorLightHandler(Activity activity) {
        mActivity = activity;
        mSensorManager = (SensorManager) mActivity.getSystemService(Activity.SENSOR_SERVICE);
        mBuilder = new AlertDialog.Builder(mActivity);

        if (mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT) != null) {
            mLightSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        } else {
            Toast.makeText(mActivity, "Light sensor unavailable", Toast.LENGTH_SHORT).show();
        }
    }

    public void register() {
        if (mLightSensor != null) {
            mSensorManager.registerListener(this, mLightSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    public void unregister() {
        mSensorManager.unregisterListener(this);
    }

    private void showAlertDialog() {
        mBuilder.setTitle("Alert")
                .setMessage("Are you at the movie")
                .setCancelable(true)
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        Toast.makeText(mActivity, "please turn off your phone", Toast.LENGTH_LONG).show();
                    }
                })
                .setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create()
                .show();
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor == mLightSensor) {
            float valueX = sensorEvent.values[0];
            if (valueX < 40 && !mDialogShown && mPrevValueX >= 40) {
                showAlertDialog();
                mDialogShown = true;
            } else if (valueX >= 40 && mDialogShown && mPrevValueX < 40) {
                mDialogShown = false; // reset boolean flag
                mCounter = 0; // reset counter
            }
            mPrevValueX = valueX;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
        if (sensor == mLightSensor) {

        }
    }
}