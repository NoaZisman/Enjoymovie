package com.noa.enjoyamovie.Activity;
import androidx.appcompat.app.AlertDialog;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.noa.enjoyamovie.MainActivity4;
import com.noa.enjoyamovie.MainActivity5;
import com.noa.enjoyamovie.MainActivity6;
import com.noa.enjoyamovie.MainActivity7;
import com.noa.enjoyamovie.R;

public class MainActivity extends AppCompatActivity {
Button gotoactivity4;
TextView title;
AlertDialog.Builder builder;
LinearLayout title1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title1 = (LinearLayout) findViewById(R.id.title1);
        title = (TextView) findViewById(R.id.title);
        gotoactivity4 = (Button) findViewById(R.id.gotoactivity4);
        builder=new AlertDialog.Builder(this);
        gotoactivity4.setOnClickListener(this::Click1);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.item1:
                builder.setTitle("Alert").setMessage("Do you want to close the app").setCancelable(true).setPositiveButton("yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int i)
                    {
                        Toast.makeText(getApplicationContext(),"closing app",Toast.LENGTH_LONG).show();
                        finishAffinity();
                    }
                })
                        .setNegativeButton("no", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        })
                        .show();

                return true;
            case R.id.item2:
                finish();
                Intent intent = new Intent(this, MainActivity7.class);
                startActivity(intent);
                return true;
            case R.id.item3:
                finish();
                intent = new Intent(this, MainActivity6.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }



    public void Click1(View v) {
        finish();
        Intent intent = new Intent(this, MainActivity5.class);
        startActivity(intent);

    }

    
}