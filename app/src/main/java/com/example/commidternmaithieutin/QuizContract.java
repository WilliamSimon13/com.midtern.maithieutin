package com.example.commidternmaithieutin;

import android.provider.BaseColumns;

public class QuizContract {
    public static class QuizEntry implements BaseColumns {
        public static final String TABLE_NAME = "quiz_questions";
        public static final String COLUMN_QUESTION = "question";
        public static final String COLUMN_ANSWER = "answer";
    }
}
