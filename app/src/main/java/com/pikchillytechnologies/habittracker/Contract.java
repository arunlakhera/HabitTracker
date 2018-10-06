package com.pikchillytechnologies.habittracker;

import android.provider.BaseColumns;

public class Contract {

    public Contract() {
    }

    public class HabitEntry implements BaseColumns {

        // Table Name
        public final static String TABLE_NAME = "my_tracking_diary";

        // Table Columns
        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_DATE = "date";
        public final static String COLUMN_HABIT = "habit";
        public final static String COLUMN_COMMENT = "comment";

        public final static String HABIT_WALK = "Walk";
        public final static String HABIT_CODING = "CODE";
        public final static String HABIT_GYM = "GYM";
    }
}
