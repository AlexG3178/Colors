package com.example.test.colors;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;

class ColorParser {

    private final String COLOR_NAME = "name";
    private final String COLOR_VALUE = "color";

    ArrayList<CustomColor> parseCustomColors(XmlPullParser parser) {
        ArrayList<CustomColor> colors = new ArrayList<>();
        try {
            while (parser.getEventType() != XmlPullParser.END_DOCUMENT) {
                switch (parser.getEventType()) {
                    case XmlPullParser.START_TAG:
                        String name = parser.getAttributeValue(null, COLOR_NAME);
                        String value = parser.getAttributeValue(null, COLOR_VALUE);
                        if (name != null && !name.isEmpty() && value != null && !value.isEmpty()) {
                            String nameCapitalized = ColorUtils.capitalize(name);
                            colors.add(new CustomColor(nameCapitalized, value));
                        }
                        break;
                    default:
                        break;
                }
                parser.next();
            }
        } catch (XmlPullParserException | IOException e) {
            e.printStackTrace();
            // use logging to some file
        }
        return colors;
    }
}
