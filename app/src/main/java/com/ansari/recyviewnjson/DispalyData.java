package com.ansari.recyviewnjson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class DispalyData extends AppCompatActivity {

    TextView resHeading,resDesc;
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispaly_data);
        resHeading = (TextView) findViewById(R.id.textViewResHeading);
        resDesc = (TextView) findViewById(R.id.textViewResDesc);
        iv = (ImageView) findViewById(R.id.imageViewRes);
        int position = getIntent().getExtras().getInt("position");
        String heading = getIntent().getExtras().getString("heading");
        String spouse = getIntent().getExtras().getString("spouse");
        String url = getIntent().getExtras().getString("url");

        resHeading.setText("NAME -- "+ heading);
        resDesc.setText(spouse);
        Picasso.with(DispalyData.this)
                .load(url)
                .into(iv);

        Toast.makeText(this, "position is = " + position + " heading is " + heading + " url " + url, Toast.LENGTH_LONG).show();




    }
}
