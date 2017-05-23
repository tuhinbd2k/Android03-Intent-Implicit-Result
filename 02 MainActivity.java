package com.example.tuhin.android03_newactivitysendreceivedata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

// Variable declaration -> EditText, TextView, Button
// Initialization of variables -> EditText, TextView, Button
// Button -> click event
// Intent -> sending and receiving setup

public class MainActivity extends AppCompatActivity {

    // Variable declaration
    EditText etName, etEmail, etMobile;
    TextView tvReplyMessage;
    Button btnClear, btnSend, btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialization of variables
        etName   = (EditText) findViewById(R.id.txtName);
        etEmail  = (EditText) findViewById(R.id.txtEmail);
        etMobile = (EditText) findViewById(R.id.txtMobile);
        tvReplyMessage = (TextView) findViewById(R.id.lblReplyMessageBox);
        btnClear = (Button) findViewById(R.id.buttonClear);
        btnSend  = (Button) findViewById(R.id.buttonSent);
        btnExit  = (Button) findViewById(R.id.buttonExit);

        // Clear button event
        btnClear.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        etName.setText("");
                        etEmail.setText("");
                        etMobile.setText("");
                        tvReplyMessage.setText("");
                        etName.requestFocus();
                    }
                }
        );

        // Send button event
        btnSend.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Variable declaration and initialization for sending text of Name, Email and Mobile number
                        String sName, sEmail, sMobile;
                        sName   = etName.getText().toString();
                        sEmail  = etEmail.getText().toString();
                        sMobile = etMobile.getText().toString();
                        tvReplyMessage.setText("");

                        //Intent setup and sending text of Name, Email and Mobile number
                        Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
                        intent.putExtra("nameKey", sName);
                        intent.putExtra("emailKey", sEmail);
                        intent.putExtra("mobileKey", sMobile);
//                        startActivity(intent);
                        startActivityForResult(intent, 0);
                    }
                }
        );

        // Exit button event
        btnExit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.exit(1);
                    }
                }
        );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == 1) {
            tvReplyMessage.setText(data.getStringExtra("replyKey"));
        }
    }
}
