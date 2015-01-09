package com.example.android.opengl;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;


public  class user extends Activity {

    public SharedPreferences myPrefs;
     public static final String PREFS_NAME = "userfile";

    public static String username="null";
    public static EditText userView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user);

         myPrefs = this.getSharedPreferences("userfile", MODE_WORLD_READABLE);
         username = myPrefs.getString("username","user1");

         userView = (EditText)findViewById(R.id.user_name);
        userView.setText(username);

        View background = findViewById(R.id.user_background);

        if(Menu.stagenumber==0) {
            background.setBackgroundResource(R.drawable.space);
        }
        else if(Menu.stagenumber==1){
            background.setBackgroundResource(R.drawable.space2);
        }
   }

    protected void onDestroy(){

        myPrefs = getSharedPreferences("userfile", MODE_WORLD_READABLE);
        SharedPreferences.Editor prefsEditor = myPrefs.edit();
        prefsEditor.putString("username",userView.getText().toString());
        prefsEditor.commit();
        super.onDestroy();
    }

    protected void onPause(){

        myPrefs = getSharedPreferences("userfile", MODE_WORLD_READABLE);
        SharedPreferences.Editor prefsEditor = myPrefs.edit();
        prefsEditor.putString("username",userView.getText().toString());
        prefsEditor.commit();
        super.onPause();


    }

}
