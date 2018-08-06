package com.example.fletch.bibliotheque;


import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;


public class DataParser {

    public String parseFirstTitle(InputStream is)  throws XmlPullParserException, IOException {
        String text = "";
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        XmlPullParser xpp = factory.newPullParser();
        xpp.setInput(is, "utf-8");
        int eventType = xpp.getEventType();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            switch (eventType) {
                case XmlPullParser.TEXT:
                    text = xpp.getText();
                    break;
                case XmlPullParser.END_TAG:
                    if (xpp.getName().equalsIgnoreCase("title")) {
                        return text;
                    }
            }
            eventType = xpp.next();
        }
        return text;
    }
}
