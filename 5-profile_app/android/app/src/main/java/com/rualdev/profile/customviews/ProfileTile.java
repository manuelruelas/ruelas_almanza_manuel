package com.rualdev.profile.customviews;



import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.rualdev.profile.R;
import com.rualdev.profile.utils.ViewUtils;

public class ProfileTile extends ConstraintLayout {

    private static final int DEFAULT_ICON_SIZE = 24;

    public ProfileTile(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public ProfileTile(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.profile_tile, this, true);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ProfileTile);
        int leadingIconResId = typedArray.getResourceId(R.styleable.ProfileTile_leadingIcon, 0);
        int trailingIconResId = typedArray.getResourceId(R.styleable.ProfileTile_trailingIcon, 0);
        String text = typedArray.getString(R.styleable.ProfileTile_text);
        int leadingIconSize = typedArray.getDimensionPixelSize(R.styleable.ProfileTile_leadingIconSize, ViewUtils.dpToPx(getContext(),DEFAULT_ICON_SIZE));


        typedArray.recycle();

        if (leadingIconResId != 0) {
            ImageView leadingIcon = findViewById(R.id.leadingIcon);
            leadingIcon.setImageResource(leadingIconResId);
            leadingIcon.setVisibility(VISIBLE);

        }

        if (trailingIconResId != 0) {
            ImageView trailingIcon = findViewById(R.id.trailingIcon);
            trailingIcon.setImageResource(trailingIconResId);
            trailingIcon.setVisibility(VISIBLE);
        }

        if(leadingIconSize > 0 ){
            ImageView leadingIcon = findViewById(R.id.leadingIcon);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) leadingIcon.getLayoutParams();
            layoutParams.width = leadingIconSize;
            layoutParams.height = leadingIconSize;
            leadingIcon.setLayoutParams(layoutParams);
        }


        TextView textView = findViewById(R.id.textView);
        textView.setText(text);
    }
}
