package com.example.secondassignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    TextInputEditText name_edt,email_edt,age_edt;
    RadioGroup gender_grp;
    RadioButton gender_btn;
    CheckBox acc_rules;
    String name,age,email,gender,interest,dept;
    Button next_btn;
    boolean chk_rules=false;
    Spinner interestSpinner,deptSpinner;

    Pattern emailPattern=Pattern.compile("[a-z0-9]+@{1}[a-z]+.com");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        name_edt =findViewById(R.id.name_edt_id);
        email_edt =findViewById(R.id.email_edt_id);
        age_edt =findViewById(R.id.age_edt_id);
        gender_grp =findViewById(R.id.gender_grp_id);
        acc_rules=findViewById(R.id.chk_id);
        next_btn =findViewById(R.id.next_btn);
        interestSpinner =findViewById(R.id.interest_spinner_id);
        deptSpinner=findViewById(R.id.dept_spinner_id);

        String[] interests_item = {"Choose Interest", "Games", "Gardening", "Reading", "Sports", "Movies"};
        interestSpinner.setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, interests_item));
       interestSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               interest = interestSpinner.getSelectedItem().toString();
           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });

        String[] dept_item = {"Choose Department", "CSE", "EEE", "BBA", "English", "Civil","THM"};
        deptSpinner.setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, dept_item));
        deptSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                dept = deptSpinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        gender_grp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                gender_btn= findViewById(checkedId);
                gender =gender_btn.getText().toString();
            }
        });

        acc_rules.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    chk_rules =true;
                }
                else{
                    chk_rules=false;
                }
            }
        });

        next_btn.setOnClickListener(v->{
            name = name_edt.getText().toString();
            age = age_edt.getText().toString();
            email =email_edt.getText().toString();

            if(name.isEmpty()){
                name_edt.requestFocus();
                name_edt.setError("Empty");
            }
            else if(age.isEmpty()){
                age_edt.requestFocus();
                age_edt.setError("Empty");
            }
           else if(email.isEmpty()){
                email_edt.requestFocus();
                email_edt.setError("Empty");
            }
           else if(!emailPattern.matcher(email).matches()){
               email_edt.setError("");
                Toast.makeText(this, "email address is not valid", Toast.LENGTH_SHORT).show();
            }

           else if(interest.equals("Choose Interest")){
                Toast.makeText(this, "Select interest", Toast.LENGTH_SHORT).show();
            }

            else if(dept.equals("Choose Department")){
                Toast.makeText(this, "Select Department", Toast.LENGTH_SHORT).show();
            }
           else if(!chk_rules){
                Toast.makeText(this, "Please accept the rules first", Toast.LENGTH_SHORT).show();
            }
           else{
               Intent intent=new Intent(MainActivity.this,SecondActivity.class);
               intent.putExtra("gender",gender);
                intent.putExtra("email",email);
                intent.putExtra("age",age);
                intent.putExtra("name",name);
                intent.putExtra("interest",interest);
                intent.putExtra("dept",dept);



               startActivity(intent);
            }












        });




    }
}