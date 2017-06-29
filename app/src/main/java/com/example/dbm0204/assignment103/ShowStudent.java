package com.example.dbm0204.assignment103;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by dbm0204 on 6/29/17.
 */

public class ShowStudent extends Activity {
    TextView tvName,tvAge;
    ImageView empPhoto;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_student_details);
        tvName=(TextView) findViewById(R.id.name_tv);
        tvAge= (TextView) findViewById(R.id.age_tv);
        empPhoto = (ImageView) findViewById(R.id.employee_photo);
        //Getting the Intent Object which is passed
        Intent intent = getIntent();
        DBHelper db = new DBHelper(getApplicationContext());
        // fetching the id of the student which is passed in the intent
        int id=intent.getIntExtra("stud_id",0);
        //getting the Student object by its ID using the method of the DB Calss]
        Student student = db.getDataByID(id);
        //Setting the Views according to the information in the Object

        tvName.setText("Name:"+student.getStuName());
        tvAge.setText("Age:"+student.getStuAge());
        empPhoto.setImageBitmap(student.employeePhoto);

    }
}
