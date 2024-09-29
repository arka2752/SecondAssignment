package com.example.secondassignment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.util.regex.Pattern;

public class SecondActivity extends AppCompatActivity {

    String name, age, email, gender, interest, dept, username, password, rating_value, year, notify;
    TextInputEditText username_edt, pass_edt;
    Button sub_btn;
    RatingBar ratingbar;
    SeekBar seekbar;
    Switch switch_bar;
    Pattern usernamePattern = Pattern.compile("^[a-z0-9/_]+");
    Pattern passwordPattern = Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        name = getIntent().getStringExtra("name");
        age = getIntent().getStringExtra("age");
        email = getIntent().getStringExtra("email");
        gender = getIntent().getStringExtra("gender");
        interest = getIntent().getStringExtra("interest");
        dept = getIntent().getStringExtra("dept");

        sub_btn=findViewById(R.id.submit_id);
        username_edt=findViewById(R.id.username_id);
        pass_edt=findViewById(R.id.password_id);
        seekbar=findViewById(R.id.seekbar_id);
        switch_bar =findViewById(R.id.switch_id);
        ratingbar =findViewById(R.id.rating_bar_id);

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                year = String.valueOf(progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        ratingbar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                rating_value = ""+rating;
            }
        });

        switch_bar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    notify="allowed";
                }
                else{
                    notify="not allowed";
                }
            }
        });




        sub_btn.setOnClickListener(v->{
           username = username_edt.getText().toString();
           password=pass_edt.getText().toString();

           if(username.isEmpty()){
               username_edt.requestFocus();
               username_edt.setError("Empty");
           }
           else if(!usernamePattern.matcher(username).matches()){
               username_edt.requestFocus();
               Toast.makeText(this, "Username is not valid. Use small letter, digit and underscore", Toast.LENGTH_SHORT).show();
           }
           else if(!passwordPattern.matcher(password).matches()){
               pass_edt.requestFocus();
               Toast.makeText(this, "Password is not strong engough. length must be 8 and use minimum 1 special character", Toast.LENGTH_SHORT).show();
           }
           else{
               Intent intent =new Intent(SecondActivity.this,FinalActivity.class);
               intent.putExtra("gender",gender);
               intent.putExtra("email",email);
               intent.putExtra("age",age);
               intent.putExtra("name",name);
               intent.putExtra("interest",interest);
               intent.putExtra("dept",dept);
               intent.putExtra("username",username);
               intent.putExtra("year",year);
               intent.putExtra("notify",notify);
               intent.putExtra("rating",rating_value);

               startActivity(intent);

           }

       });


    }
}
