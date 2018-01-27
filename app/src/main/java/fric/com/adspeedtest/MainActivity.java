package fric.com.adspeedtest;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Pure Javascript implementation of AdView, testing 1-25-2018
        AdView mAdView = new AdView(this);

        mAdView.setAdSize(AdSize.BANNER);

        mAdView.setAdUnitId(getString(R.string.banner_ad_unit_id));

        ConstraintLayout constraintLayoutAL = (ConstraintLayout) findViewById(R.id.main_layout);

        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 320, getResources().getDisplayMetrics());
        layoutParams.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, getResources().getDisplayMetrics());
        layoutParams.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID;
        layoutParams.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        layoutParams.rightToRight = ConstraintLayout.LayoutParams.PARENT_ID;

        constraintLayoutAL.addView(mAdView, layoutParams);

        mAdView.setLayerType(View.LAYER_TYPE_HARDWARE, null);

        try {
            final AdRequest adRequestTest = new AdRequest.Builder().build();
            mAdView.loadAd(adRequestTest);
        } catch (Exception e) {

        }

    }
}
