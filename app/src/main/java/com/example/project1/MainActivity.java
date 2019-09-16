package com.example.project1;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends Activity implements View.OnClickListener {

    private ImageButton phoneIb, emailIb, addressIb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phoneIb = findViewById(R.id.ib_restaurant_contact_id);
        emailIb = findViewById(R.id.ib_restaurant_email_id);
        addressIb = findViewById(R.id.ib_restaurant_address_id);

        phoneIb.setOnClickListener(this);
        emailIb.setOnClickListener(this);
        addressIb.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v == phoneIb) {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + getString(R.string.restaurant_contact)));
            startActivity(intent);
        } else if (v == emailIb) {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("message/rfc822");
            intent.putExtra(Intent.EXTRA_EMAIL  , new String[]{getString(R.string.restaurant_email)});
            startActivity(Intent.createChooser(intent, null));
        } else if (v == addressIb) {
            Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + getString(R.string.restaurant_address)));
            startActivity(intent);
        }
    }
}
