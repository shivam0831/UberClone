package com.shivam.uber.Activity;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.shivam.uber.Adapter.IntroAdapter;
import com.shivam.uber.IntroPageTransformer;
import com.shivam.uber.R;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class IntroActivity extends AppCompatActivity {

    private int pagePosition = 0;
    private ImageButton nextBtn;
    private Button finishBtn;
    private ViewPager viewPager;
    private ImageView[] indicators;
    private ImageView indicator01, indicator02, indicator03;



    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Montserrat-Light.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build());
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_intro);

        SharedPreferences share=getSharedPreferences("PREFS",MODE_PRIVATE);
        if(share.getInt("INTRO",0)==1){
            startActivity(new Intent(this, MainActivity.class));
            finish();

        }

        nextBtn = (ImageButton) findViewById(R.id.btn_next);
        finishBtn = (Button) findViewById(R.id.btn_finish);

        indicator01 = (ImageView) findViewById(R.id.indicator_01);
        indicator02 = (ImageView) findViewById(R.id.indicator_02);
        indicator03 = (ImageView) findViewById(R.id.indicator_03);
        indicators = new ImageView[] {indicator01, indicator02, indicator03};

        updateIndicator(pagePosition);

        final int pageColor01 = ContextCompat.getColor(this, R.color.lightBlue);
        final int pageColor02 = ContextCompat.getColor(this, R.color.cyan);
        final int pageColor03 = ContextCompat.getColor(this, R.color.teal);
        final int[] pageColorList = new int[] {pageColor01, pageColor02, pageColor03};

        final ArgbEvaluator argbEvaluator = new ArgbEvaluator();  //used to update the page color


        viewPager = (ViewPager) findViewById(R.id.onboarding_viewpager);

        // Set Adapter on ViewPager
        viewPager.setAdapter(new IntroAdapter(getSupportFragmentManager()));

        // Set PageTransformer on ViewPager
        viewPager.setPageTransformer(false, new IntroPageTransformer());

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                // Update Page Background Color
                int pageColorUpdate = (Integer) argbEvaluator.evaluate(
                        positionOffset,
                        pageColorList[position],
                        pageColorList[position == 2 ? position : position + 1]  //If there's no last page, do not increment
                );
                viewPager.setBackgroundColor(pageColorUpdate);

            }

            @Override
            public void onPageSelected(int position) {
                pagePosition = position;
                updateIndicator(pagePosition);

                //set the page color when selected
                switch (position) {
                    case 0:
                        viewPager.setBackgroundColor(pageColor01);
                        break;
                    case 1:
                        viewPager.setBackgroundColor(pageColor02);
                        break;
                    case 2:
                        viewPager.setBackgroundColor(pageColor03);
                        break;
                }

                nextBtn.setVisibility(position == 2 ? View.GONE : View.VISIBLE);
                finishBtn.setVisibility(position == 2 ? View.VISIBLE : View.GONE);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void updateIndicator(int pagePosition) {
        for(int i = 0; i < indicators.length; i++) {
            indicators[i].setBackgroundResource(
                    i == pagePosition ? R.drawable.indicator_selected : R.drawable.indicator_unselected
            );
        }
    }

    public void onNextButton(View view) {
        pagePosition += 1;
        viewPager.setCurrentItem(pagePosition, true);
    }

    public void onFinishButton(View view) {
        SharedPreferences share=getSharedPreferences("PREFS",MODE_PRIVATE);
        SharedPreferences.Editor editor;

        editor=share.edit();
        editor.putInt("INTRO",1);
        editor.apply();
        startActivity(new Intent(IntroActivity.this, MainActivity.class));
    }

    public void onCancelButton(View view) {
        SharedPreferences share=getSharedPreferences("PREFS",MODE_PRIVATE);
        SharedPreferences.Editor editor;

        editor=share.edit();
        editor.putInt("INTRO",1);
        editor.apply();
        startActivity(new Intent(IntroActivity.this, MainActivity.class));
    }

}
