package com.alura.travelapp.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.alura.travelapp.R;
import com.alura.travelapp.model.TravelPackage;
import com.alura.travelapp.util.PriceUtil;

import java.math.BigDecimal;

public class CheckoutActivity extends AppCompatActivity {

    public static final String TITLE_APPBAR = "payment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        setTitle(TITLE_APPBAR);

        TravelPackage travelPackageOslo = new TravelPackage("oslo", "sao_paulo_sp",
                2, new BigDecimal("200.00"));

        showsPrice(travelPackageOslo);

    }

    private void showsPrice(TravelPackage travelPackage) {
        TextView priceTextView = findViewById(R.id.activity_checkout_text_view_amount_id);
        String cad = PriceUtil
                .formatPriceToCad(travelPackage.getPrice());
        priceTextView.setText(cad);
    }
}
