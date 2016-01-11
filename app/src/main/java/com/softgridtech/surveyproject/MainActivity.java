package com.softgridtech.surveyproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    EditText mUsernameEt, mAgeEt;
    Spinner mGenderSpn, mSalarySpn;
    SeekBar mExperienceSkbr;
    Button mSubmitBtn;
    List<String> spnGenderData;
    List<String> spnSalaryData;
    TextView mExperienceValueTv, mExperienceValueChangeTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUsernameEt = (EditText) findViewById(R.id.usernameEt);


        mAgeEt = (EditText) findViewById(R.id.ageEt);

        mExperienceSkbr = (SeekBar) findViewById(R.id.experienceSkbr);


        mExperienceSkbr.setMax(20);
        mExperienceSkbr.setProgress(2);
        mSubmitBtn = (Button) findViewById(R.id.submitBtn);
        mGenderSpn = (Spinner) findViewById(R.id.genderSpn);
        mSalarySpn = (Spinner) findViewById(R.id.salarySpn);
        mExperienceValueTv = (TextView) findViewById(R.id.experienceValueTv);
        mExperienceValueChangeTv = (TextView) findViewById(R.id.experienceValuechangingTv);

        spnGenderData = new ArrayList<String>();


        spnGenderData.add("Male");
        spnGenderData.add("Female");


        ArrayAdapter<String> spnAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spnGenderData);
        mGenderSpn.setAdapter(spnAdapter);

        mGenderSpn.getSelectedItemPosition();

        spnSalaryData = new ArrayList<String>();


        spnSalaryData.add("$20,000-$40,000");
        spnSalaryData.add("$40,000-$60,000");
        spnSalaryData.add("$60,000-$80,000");
        spnSalaryData.add("$80,000-$100,000");


        ArrayAdapter<String> spnAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spnSalaryData);
        mSalarySpn.setAdapter(spnAdapter1);

        mSalarySpn.getSelectedItemPosition();

        mExperienceSkbr.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                // change progress text label with current seekbar value
                mExperienceValueTv.setText("Your experience is: " + progress + "years");
                // change action text label to changing
                mExperienceValueChangeTv.setText("changing");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

                mExperienceValueChangeTv.setText("starting to track touch");

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setSecondaryProgress(seekBar.getProgress());
                mExperienceValueChangeTv.setText("ended tracking touch");
            }
        });


        mSubmitBtn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                if (mUsernameEt.getText().toString().length() == 0)
                    mUsernameEt.setError("Username is required");

                String age = mAgeEt.getText().toString();

                if (age.length() == 0)
                    mAgeEt.setError("Please enter age");

                else if (Integer.parseInt(age) < 13)
                    mAgeEt.setError("Please enter age 13 and older");


            }
        });

    }


}
