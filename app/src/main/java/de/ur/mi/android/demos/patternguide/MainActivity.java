package de.ur.mi.android.demos.patternguide;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


/**
 * Der Pattern Guide stellt Design Patterns aus dem Gebiet der Objekt-Orientierten Programmierung vor.
 * Im Hauptmenü (diese Activity) wird neben einem Erklärungstext eine Liste von Buttons angezeigt, die
 * jeweils zu einer anderen Subkategorie an Patterns führen (Creational Patterns, Structural Patterns und
 * Behavioral Patterns). Die dargestellten Inhalte entstammen der Wikipedia bzw. der Webseite gofpatterns.com.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initUI();
    }

    private void initUI() {
        setContentView(R.layout.activity_main);
    }

}