package com.example.secondassignment;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FinalActivity extends AppCompatActivity {

    TextView nameView,ageView,usernameView,emailView,deptView,interestView,yearView,ratingView,notifyView,genderView;
    String name,age,email,gender,interest,dept,username,rating_value,year,notify;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_final);

        nameView=findViewById(R.id.fullname_id);
        ageView=findViewById(R.id.age_id);
        usernameView=findViewById(R.id.username_id);
        emailView=findViewById(R.id.email_id);
        deptView=findViewById(R.id.dept_id);
        interestView=findViewById(R.id.interest_id);
        yearView=findViewById(R.id.year_id);
        ratingView=findViewById(R.id.rating_id);
        notifyView=findViewById(R.id.notify_id);
        genderView=findViewById(R.id.gender_id);
//
        name= getIntent().getStringExtra("name");
        age= getIntent().getStringExtra("age");
        email= getIntent().getStringExtra("email");
        gender= getIntent().getStringExtra("gender");
        interest= getIntent().getStringExtra("interest");
        dept= getIntent().getStringExtra("dept");
        username= getIntent().getStringExtra("username");
        rating_value= getIntent().getStringExtra("rating");
        year= getIntent().getStringExtra("year");
        notify= getIntent().getStringExtra("notify");

        nameView.setText(name);
        ageView.setText(age);
        usernameView.setText(username);
        emailView.setText(email);
        genderView.setText(gender);
        deptView.setText(dept);
        interestView.setText(interest);
        yearView.setText(year);
        ageView.setText(age);
        notifyView.setText(notify);
        ratingView.setText(rating_value);




    }
}