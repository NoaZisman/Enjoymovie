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
import com.noa.enjoyamovie.MainActivity8;
import com.noa.enjoyamovie.R;

public class MainActivity2 extends AppCompatActivity {

    LinearLayout title1;
    AlertDialog.Builder builder;
    Button one;
    Button two;
    Button three;
    Button four;
    Button five;
    Button six;
    Button seven;
    Button eight;
    Button nine;
    Button ten;
    Button eleven;
    Button twelve;
    Button thirteen;
    Button fourteen;
    Button fifteen;
    Button sixteen;
    Button seventeen;
    Button eighteen;
    Button nineteen;
    Button twenty;
    Button twentyOne;
    Button twentyTwo;
    Button twentyThree;
    Button twentyFour;
    Button twentyFive;
    Button twentySix;
    Button twentySeven;
    Button twentyEight;
    TextView title;
    TextView greentext;
    TextView greytext;
    TextView orangetext;
    Button back;
    Button topay;
    ImageView screen;
    ImageView green;
    ImageView grey;
    ImageView orange;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        title1 = (LinearLayout) findViewById(R.id.title1);
        title = (TextView) findViewById(R.id.title);
        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);
        ten = (Button) findViewById(R.id.ten);
        eleven = (Button) findViewById(R.id.eleven);
        twelve = (Button) findViewById(R.id.twelve);
        thirteen = (Button) findViewById(R.id.thirteen);
        fourteen = (Button) findViewById(R.id.fourteen);
        fifteen = (Button) findViewById(R.id.fifteen);
        sixteen = (Button) findViewById(R.id.sixteen);
        seventeen = (Button) findViewById(R.id.seventeen);
        eighteen = (Button) findViewById(R.id.eighteen);
        nineteen = (Button) findViewById(R.id.nineteen);
        twenty = (Button) findViewById(R.id.twenty);
        twentyOne = (Button) findViewById(R.id.twentyOne);
        twentyTwo = (Button) findViewById(R.id.twentyTwo);
        twentyThree = (Button) findViewById(R.id.twentyThree);
        twentyFour = (Button) findViewById(R.id.twentyFour);
        twentyFive = (Button) findViewById(R.id.twentyFive);
        twentySix = (Button) findViewById(R.id.twentySix);
        twentySeven = (Button) findViewById(R.id.twentySeven);
        twentyEight = (Button) findViewById(R.id.twentyEight);
        back = (Button) findViewById(R.id.back);
        topay = (Button) findViewById(R.id.topay);
        greentext = (TextView) findViewById(R.id.greentext);
        greytext = (TextView) findViewById(R.id.greytext);
        orangetext = (TextView) findViewById(R.id.orangetext);
        green = (ImageView) findViewById(R.id.green);
        grey = (ImageView) findViewById(R.id.grey);
        orange = (ImageView) findViewById(R.id.orange);
        screen = (ImageView) findViewById(R.id.screen);
        builder=new AlertDialog.Builder(this);
        back.setOnClickListener(this::Click1);
        topay.setOnClickListener(this::Click2);
    }
    public void Click1(View v) {
        finish();
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);

    }
    public void Click2(View v) {
        finish();
        Intent intent = new Intent(this, MainActivity8.class);
        startActivity(intent);

    }
}