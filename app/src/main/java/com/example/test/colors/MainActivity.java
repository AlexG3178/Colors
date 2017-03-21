package com.example.test.colors;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.xmlpull.v1.XmlPullParser;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvColors;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    XmlPullParser parser;
    ColorParser colorParser;
    public ArrayList<CustomColor> colors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        parser = getResources().getXml(R.xml.custom_colors);
        colorParser = new ColorParser();
        colors = colorParser.parseCustomColors(parser);

        rvColors = (RecyclerView) findViewById(R.id.rvColors);
        rvColors.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        rvColors.setLayoutManager(layoutManager);

        adapter = new ColorAdapter(colors);
        rvColors.setAdapter(adapter);
    }
}
