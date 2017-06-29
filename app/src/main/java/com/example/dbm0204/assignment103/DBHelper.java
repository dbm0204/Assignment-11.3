package com.example.dbm0204.assignment103;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;

/**
 * Created by dbm0204 on 6/29/17.
 */

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context){
        super(context,"blobShower",null,1);

    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE="create table personaldetails (id integer primary key autoincrement,pname text,age integer,img blob)";
        sqLiteDatabase.execSQL(CREATE_TABLE);

    }
    //onUpgrade method is used when the database is changed
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {}
    public int addData(Student student){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("pname",student.stuName);
        contentValues.put("age",student.stuAge);
        Bitmap bitmap = student.employeePhoto;
        //Converting Bitmap image to byte array
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,0, byteArrayOutputStream);
        byte[] img = byteArrayOutputStream.toByteArray();
        // putting image;
        contentValues.put("img",img);
        //Fetching thr id.
        int student_id =(int)db.insert("personaldetains","null",contentValues);
        return student_id;


    }
    //Method to get the data by ID.
    public Student getDataByID(int student_ID)
    {
        //Creating reference of Readable Database.
        SQLiteDatabase db=this.getReadableDatabase();

        //Creating selectQuery String to select db element based on its ID.
        String selectQuery =  "SELECT  " +
                "id" + "," +
                "pname" + "," +
                "age" +","+"img"+
                " FROM " + "personaldetails"
                + " WHERE " +
                "id" + "=?";

        //Creating Student object.
        Student student=new Student();

        //Creating the cursor by using the rawQuery method of db.
        Cursor cursor=db.rawQuery(selectQuery,new String[]{String.valueOf(student_ID)});

        //Fetching the data into the Student object.
        if(cursor.moveToFirst())
        {
            student.stuName=cursor.getString(cursor.getColumnIndex("pname"));
            student.stuAge=cursor.getString(cursor.getColumnIndex("age"));

            //Converting byte array into Bitmap Image.
            byte[] img=cursor.getBlob(cursor.getColumnIndex("img"));
            student.employeePhoto= BitmapFactory.decodeByteArray(img,0,img.length);
        }
        cursor.close();
        db.close();
        return student;    //returning object of student.
    }
}
