package com.example.ankur.contactapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ContactInfoActivity extends AppCompatActivity {

    TextView tvName, tvPhone;
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_info);
        tvName = (TextView) findViewById(R.id.tvName);
        tvPhone = (TextView) findViewById(R.id.tvPhone);
        btnSend = (Button) findViewById(R.id.btnSend);

        final Contact data = (Contact) getIntent().getExtras().getSerializable("DATA");
        tvName.setText(data.getCombineName());
        tvPhone.setText(data.getPhoneNo());

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SmsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name", data.getCombineName());
                bundle.putString("phone", data.getPhoneNo());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
