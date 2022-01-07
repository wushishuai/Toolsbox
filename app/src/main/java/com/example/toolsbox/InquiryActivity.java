package com.example.toolsbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.toolsbox.function.IPUtil;

import java.util.Map;

public class InquiryActivity extends AppCompatActivity {
    private Button inquiry_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inquiry);
        inquiry_test = (Button) findViewById(R.id.inquiry_test);
        inquiry_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String  cityInfo = IPUtil.getCityInfo("152.17.176.252");
                Toast.makeText(getApplicationContext(),cityInfo,Toast.LENGTH_SHORT).show();



            }
        });
    }
}