package com.alura.travelapp.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public class ResourcesUtil {

    public static final String DRAWABLE = "drawable";

    public static Drawable getDrawable(Context context, String stringDrawble) {
        Resources resources = context.getResources();
        int drawableId = resources.getIdentifier(stringDrawble,
                DRAWABLE, context.getPackageName());
        return resources.getDrawable(drawableId);
    }
}
