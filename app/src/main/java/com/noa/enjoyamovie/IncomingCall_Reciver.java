package com.noa.enjoyamovie;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;

public class IncomingCall_Reciver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        //הפעולה מאזינה האם ישנה שיחה נכנסת וכאשר מזהה פעולה של התקשרות היא תשלח הודעה
        Bundle extras=intent.getExtras();
        if(extras!=null)
        {
            String state = extras.getString(TelephonyManager.EXTRA_STATE);
            if(state.equals(TelephonyManager.EXTRA_STATE_RINGING))
            {
                String phoneNumber= extras.getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
                if(phoneNumber!=null)
                {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(phoneNumber, null, "I am ordering movie tickets", null, null);
                }
            }
        }

    }



}


