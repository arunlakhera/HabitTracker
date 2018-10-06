package com.pikchillytechnologies.habittracker;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MyHabits";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyHabitsDBHelper habitDbHelper = new MyHabitsDBHelper(this);

        // Insert Data in tables
        habitDbHelper.insertHabit("28/09/2018", Contract.HabitEntry.HABIT_CODING, "Android with Firebase");
        habitDbHelper.insertHabit("01/10/2018", Contract.HabitEntry.HABIT_WALK, "Morning Walk 2 km");
        habitDbHelper.insertHabit("02/10/2018", Contract.HabitEntry.HABIT_GYM, "Exercise for 2 hours");
        
        Cursor cursor = habitDbHelper.readHabits();
        while (cursor.moveToNext()) {
            Log.v(TAG, "habit: " + cursor.getString(0) + " " + cursor.getString(1) +
                    " " + cursor.getString(2) + " " + cursor.getString(3));
        }

    }
}
