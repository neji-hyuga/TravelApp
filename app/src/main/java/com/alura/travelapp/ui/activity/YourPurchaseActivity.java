package com.alura.travelapp.ui.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.alura.travelapp.R;
import com.alura.travelapp.model.TravelPackage;
import com.alura.travelapp.util.DateUtil;
import com.alura.travelapp.util.PriceUtil;
import com.alura.travelapp.util.ResourcesUtil;

import static com.alura.travelapp.ui.activity.Constants.PACKAGE_KEY;

public class YourPurchaseActivity extends AppCompatActivity {

    public static final String TITLE_APPBAR = "your order : )";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_purchase);
        setTitle(TITLE_APPBAR);
        loadsReceivedTravelPackage();
    }

    private void loadsReceivedTravelPackage() {
        Intent intent = getIntent();
        if (intent.hasExtra(PACKAGE_KEY)) {
            TravelPackage travelPackage = (TravelPackage) intent.getSerializableExtra(PACKAGE_KEY);
            startsFields(travelPackage);
        }
    }

    private void startsFields(TravelPackage travelPackage) {
        showsPlace(travelPackage);
        showsImage(travelPackage);
        showsTripLength(travelPackage);
        showsPrice(travelPackage);
    }

    private void showsPrice(TravelPackage travelPackage) {
        TextView priceTextView = findViewById(R.id.activity_purchase_text_view_amount_id);
        String cad = PriceUtil
                .formatPriceToCad(travelPackage.getPrice());
        priceTextView.setText(cad);
    }

    private void showsTripLength(TravelPackage travelPackage) {
        TextView tripLengthTextView = findViewById(R.id.activity_purchase_text_view_trip_period_id);
        String periodString = DateUtil
                .tripLengthToString(travelPackage.getTripLength());
        tripLengthTextView.setText(periodString);
    }

    private void showsImage(TravelPackage travelPackage) {
        ImageView placeImage = findViewById(R.id.activity_purchase_place_image_view_id);
        Drawable drawable = ResourcesUtil
                .getDrawable(this, travelPackage.getImage());
        placeImage.setImageDrawable(drawable);
    }

    private void showsPlace(TravelPackage travelPackage) {
        TextView placeTextView = findViewById(R.id.activity_purchase_text_view_place_name_id);
        placeTextView.setText(travelPackage.getPlace());
    }
}
