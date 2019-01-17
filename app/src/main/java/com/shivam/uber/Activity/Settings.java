package com.shivam.uber.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.shivam.uber.Adapter.RecyclerViewAdapter;
import com.shivam.uber.Model.Setting;
import com.shivam.uber.R;

import java.util.ArrayList;
import java.util.List;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Settings extends AppCompatActivity {

    View view;
    private RecyclerView myrecyclerview;
    private List<Setting> lstSetting;
    ImageView back;

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
        setContentView(R.layout.activity_settings);

        lstSetting= new ArrayList<>();

        lstSetting.add(new Setting("Privacy policy",R.drawable.baseline_security_black_24dp));
        lstSetting.add(new Setting("Terms and conditions",R.drawable.sharp_assignment_turned_in_black_24dp));
        lstSetting.add(new Setting("Help",R.drawable.baseline_help_outline_black_24dp));
        lstSetting.add(new Setting("FAQ's",R.drawable.baseline_question_answer_black_24dp));
        lstSetting.add(new Setting("About us",R.drawable.sharp_find_in_page_black_24dp));
        lstSetting.add(new Setting("Contact us",R.drawable.baseline_contact_phone_black_24dp));

        myrecyclerview=(RecyclerView)findViewById(R.id.recycler);
        myrecyclerview.setHasFixedSize(true);


        RecyclerViewAdapter recyclerAdapter=new RecyclerViewAdapter(this,lstSetting);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(this));
        myrecyclerview.setAdapter(recyclerAdapter);

        back = (ImageView) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Settings.this,Home.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);

            }
        });
    }
}
