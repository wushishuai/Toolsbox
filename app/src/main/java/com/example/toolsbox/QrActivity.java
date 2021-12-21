package com.example.toolsbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.toolsbox.function.QRCode;

public class QrActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView qr_image;
    Button QR_generate_btn;
    EditText qr_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);
        qr_image = (ImageView) findViewById(R.id.qr_image);
        QR_generate_btn = (Button) findViewById(R.id.QR_generate);
        qr_text = (EditText) findViewById(R.id.edit_text);
        QR_generate_btn.setOnClickListener(this::onClick);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.QR_generate:
                String inputText = qr_text.getText().toString();
                qr_image.setImageBitmap(QRCode.createQRCode(inputText));
                break;
            default:
                break;
        }

    }
}