package com.w3learnteam.w3learn.learn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;

import com.pddstudio.highlightjs.HighlightJsView;
import com.pddstudio.highlightjs.models.Language;
import com.pddstudio.highlightjs.models.Theme;
import com.w3learnteam.w3learn.R;

public class List_Code extends AppCompatActivity {
    HighlightJsView highlightJsView;
    ScrollView ScrollV1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list__code);

        ScrollV1 = (ScrollView) findViewById(R.id.ScrollView1);

        //find and instantiate the view
        highlightJsView = (HighlightJsView) findViewById(R.id.code_view);

        //optional: register callbacks and style the view

        //register theme change listener
        highlightJsView.setOnThemeChangedListener(new HighlightJsView.OnThemeChangedListener() {
            @Override
            public void onThemeChanged(@NonNull Theme theme) {
            }
        });

        //change theme and set language to auto detect
        highlightJsView.setTheme(Theme.AGATE);
        highlightJsView.setHighlightLanguage(Language.HTML);
        //load the source (can be loaded by String, File or URL)
        highlightJsView.setSource("<HTML><HEAD><TITLE>THIS IS TITLE</TITLE></HEAD></HTML>");

        highlightJsView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });


    }
}

