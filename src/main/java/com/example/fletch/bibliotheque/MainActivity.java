package com.example.fletch.bibliotheque;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            InputStream is=getAssets().open("books.xml");
            DataParser parser = new DataParser();
            try {
               String title = parser.parseFirstTitle(is);
               TextView toolbar = findViewById(R.id.titleBookView);
               toolbar.setText(title);
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
