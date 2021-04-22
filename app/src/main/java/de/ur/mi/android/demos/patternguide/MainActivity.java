package de.ur.mi.android.demos.patternguide;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import de.ur.mi.android.demos.patternguide.patterns.activities.BehavioralPatternsActivity;
import de.ur.mi.android.demos.patternguide.patterns.activities.CreationalPatternsActivity;
import de.ur.mi.android.demos.patternguide.patterns.activities.StructuralPatternsActivity;

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

    /**
     * Setzt das korrekte Layout (activity_main.xml) und registriert Klick-Listener auf den drei
     * Buttons. In den Callback-Methoden wird dabei die Methode zum Starten der nächsten Activity mit
     * einem jeweils unterschiedlichen Parameter aufgerufen.
     */
    private void initUI() {
        setContentView(R.layout.activity_main);
        Button selectCreationalPatternsButton = findViewById(R.id.creationalPatternsButton);
        selectCreationalPatternsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Startet die Activity zur Anzeige der Creational Patterns
                startPatternActivity(CreationalPatternsActivity.class);
            }
        });
        Button selectStructuralPatternsButton = findViewById(R.id.structuralPatternsButton);
        selectStructuralPatternsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Startet die Activity zur Anzeige der Structural Patterns
                startPatternActivity(StructuralPatternsActivity.class);
            }
        });
        Button selectBehavioralPatternsButton = findViewById(R.id.behavioralPatternsButton);
        selectBehavioralPatternsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Startet die Activity zur Anzeige der Behavioral Patterns
                startPatternActivity(BehavioralPatternsActivity.class);
            }
        });
    }

    /**
     * Startet eine neue Activity via Intent
     * @param activity Die zu startende Activity
     */
    private void startPatternActivity(Class<?> activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }
}