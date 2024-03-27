package com.example.transformapp;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Optional;

public class URLTestModel {

    private final com.example.transformapp.Notifications notifications =
            new com.example.transformapp.Notifications();

    private Optional<com.example.transformapp.URLTestObject> urlTestObject =
            Optional.empty();

    public Optional<com.example.transformapp.URLTestObject> getUrlTestObject() {
        return urlTestObject;
    }

    public Optional<com.example.transformapp.URLTestObject> testURL(String url) {

        try {
            long startTimeMillis = System.currentTimeMillis();
            HttpURLConnection urlConnection =
                    (HttpURLConnection) new URL(url).openConnection();
            try (
                    InputStream is = urlConnection.getInputStream();
            ) {
                while (is.read() != -1) {
                }
            }
            long endTimeMillis = System.currentTimeMillis();

            com.example.transformapp.URLTestObject uto = new com.example.transformapp.URLTestObject(
                    urlConnection.getResponseCode(),
                    (int) (endTimeMillis - startTimeMillis)
            );

            urlTestObject = Optional.of(uto);

        } catch(Exception exc) {
            com.example.transformapp.URLTestObject uto = new com.example.transformapp.URLTestObject(exc.getMessage());
            urlTestObject = Optional.of(uto);
        }

        notifications.publish(com.example.transformapp.Notifications.EVENT_MODEL_UPDATE);

        return urlTestObject;
    }
}
