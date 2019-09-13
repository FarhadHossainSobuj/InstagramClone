package com.example.instagramclone;

import android.app.Application;

import com.parse.Parse;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("ID3UT6AejoyprBAm8q3KLGlmywDQsUNv3ebl3303")
                // if defined
                .clientKey("EAdaUtaa2ngkNVgi6IwIa1cFINPKN0ZuYup9KSj8")
                .server("https://parseapi.back4app.com/")
                .build()
        );
    }
}
