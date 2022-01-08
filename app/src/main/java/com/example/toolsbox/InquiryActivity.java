package com.example.toolsbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.github.jarod.qqwry.IPZone;
import com.github.jarod.qqwry.QQWry;
import com.hanks.htextview.scale.ScaleTextView;

import java.io.IOException;

public class InquiryActivity extends AppCompatActivity {
    private Button inquiry_test;
    private ScaleTextView ip_result_text;
    private EditText ip_text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inquiry);

        inquiry_test = (Button) findViewById(R.id.inquiry_test);
        ip_result_text = (ScaleTextView) findViewById(R.id.ip_result_text);
        ip_text = (EditText) findViewById(R.id.ip_text);
        inquiry_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                String  cityInfo = IPUtil.getCityInfo("152.17.176.252");
//                Toast.makeText(getApplicationContext(),cityInfo,Toast.LENGTH_SHORT).show();
                QQWry qqwry = null;
                try {
                    qqwry = new QQWry();
                } catch (IOException e) {
                    e.printStackTrace();
                }
//                String myIP = "36.231.117.29";
                String myIP = ip_text.getText().toString();
                IPZone ipzone = qqwry.findIP(myIP);
                System.out.printf("%s, %s", ipzone.getMainInfo(), ipzone.getSubInfo());
                ip_result_text.animateText(ipzone.getMainInfo()+" "+ipzone.getSubInfo());

                Log.e("------------",ipzone.getMainInfo()+ipzone.getSubInfo());



            }
        });
    }
//    public void init() throws IOException {
//        QQWry qqwry = new QQWry(); // load qqwry.dat from classpath
//
////        QQWry qqwry = new QQWry(Paths.get("path/to/qqwry.dat")); // load qqwry.dat from java.nio.file.Path
////
////        byte[] data = Files.readAllBytes(Paths.get("path/to/qqwry.dat"));
////        QQWry qqwry = new QQWry(data); // create QQWry with provided data
//
//        String dbVer = qqwry.getDatabaseVersion();
//        System.out.printf("qqwry.dat version=%s", dbVer);
//// qqwry.dat version=2021.08.11
//
//    }
}