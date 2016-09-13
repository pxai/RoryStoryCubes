package io.pello.android.rorystorycubes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void openPlay (View view) {
        Intent intent = new Intent(MenuActivity.this, GameActivity.class);
        startActivity(intent);
        //MenuActivity.this.finish();
    }

    public void openSettings (View view) {
        Intent intent = new Intent(MenuActivity.this, SettingsActivity.class);
        startActivity(intent);
    }

    public void openHelp (View view) {
        Intent intent = new Intent(MenuActivity.this, HelpActivity.class);
        startActivity(intent);
    }
}
