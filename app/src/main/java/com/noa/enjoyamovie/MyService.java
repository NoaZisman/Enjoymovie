package com.noa.enjoyamovie;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {
    public MyService()
    {
    }
    MediaPlayer player1;


    @Override
    public IBinder onBind(Intent intent) {
       return null;
    }
    @SuppressLint("WrongConstant")
    public int onStartCommand(Intent intent,int flags, int startId)
    {
        if(player1==null) {
            player1 = MediaPlayer.create(this, R.raw.under_the_sea);
            player1.setVolume(0.2f, 0.2f);
            player1.setLooping(true);
            player1.start();
            Toast.makeText(getApplicationContext(),"song is playing",Toast.LENGTH_LONG).show();
        }
        return 1;
    }
    @Override
    public void onDestroy() {
        player1.stop();
        player1.release();
        player1=null;
    }

}