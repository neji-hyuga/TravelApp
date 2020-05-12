package com.alura.travelapp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.alura.travelapp.R;
import com.alura.travelapp.model.TravelPackage;
import com.alura.travelapp.util.PriceUtil;

import static com.alura.travelapp.ui.activity.Constants.PACKAGE_KEY;

public class CheckoutActivity extends AppCompatActivity {

    public static final String TITLE_APPBAR = "payment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        setTitle(TITLE_APPBAR);
        loadsReceivedTravelPackage();

    }

    private void loadsReceivedTravelPackage() {
        Intent intent = getIntent();
        if (intent.hasExtra(PACKAGE_KEY)) {
            final TravelPackage travelPackage = (TravelPackage) intent.getSerializableExtra(PACKAGE_KEY);
            showsPrice(travelPackage);
            setUpPurchaseButton(travelPackage);
        }
    }

    private void setUpPurchaseButton(final TravelPackage travelPackage) {
        Button paymentButton = findViewById(R.id.activity_checkout_button_ok_id);

        paymentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goesToPurchaseActivity(travelPackage);
            }
        });
    }

    private void goesToPurchaseActivity(TravelPackage travelPackage) {
        Intent intent = new Intent(CheckoutActivity.this,
                YourPurchaseActivity.class);
        intent.putExtra(PACKAGE_KEY, travelPackage);
        startActivity(intent);
    }

    private void showsPrice(TravelPackage travelPackage) {
        TextView priceTextView = findViewById(R.id.activity_checkout_text_view_amount_id);
        String cad = PriceUtil
                .formatPriceToCad(travelPackage.getPrice());
        priceTextView.setText(cad);
    }
}
