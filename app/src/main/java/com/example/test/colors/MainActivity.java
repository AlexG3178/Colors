package com.example.test.colors;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvColors;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    public ArrayList<ColorClass> colors = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        try {
            XmlPullParser parser = getResources().getXml(R.xml.custom_colors);
            while (parser.getEventType() != XmlPullParser.END_DOCUMENT) {
                switch (parser.getEventType()) {
                    case XmlPullParser.START_TAG:
                        String name = parser.getAttributeValue(null, "name");
                        String value = parser.getAttributeValue(null, "color");
                        if (name != null && !name.isEmpty() && value != null && !value.isEmpty()) {
                            String nameCapitalized = capitalize(name);
                            colors.add(new ColorClass(nameCapitalized, value));
                        }
                        break;
                    default:
                        break;
                }
                parser.next();
            }
        } catch (XmlPullParserException | IOException e) {
            e.printStackTrace();
        }

        rvColors = (RecyclerView) findViewById(R.id.rvColors);
        rvColors.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        rvColors.setLayoutManager(layoutManager);

        adapter = new ColorAdapter(colors);
        rvColors.setAdapter(adapter);
    }

    private String capitalize(String str) {
        String strLowerCase = str.toLowerCase();
        return Character.toUpperCase(strLowerCase.charAt(0)) + strLowerCase.substring(1);
    }
}
