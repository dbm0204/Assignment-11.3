package com.example.dbm0204.assignment103;

import android.graphics.Bitmap;

/**
 * Created by dbm0204 on 6/29/17.
 */

public class Student {
    public String stuName;
    public String stuAge;
    public Bitmap employeePhoto;


    public Student() {}
    public Student(String stuName, String stuAge, Bitmap employeePhoto) {
        this.stuName = stuName;
        this.stuAge = stuAge;
        this.employeePhoto = employeePhoto;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuAge() {
        return stuAge;
    }

    public void setStuAge(String stuAge) {
        this.stuAge = stuAge;
    }

    public Bitmap getEmployeePhoto() {
        return employeePhoto;
    }
    public void setEmployeePhoto(Bitmap employeePhoto) {
        this.employeePhoto = employeePhoto;
    }

}
