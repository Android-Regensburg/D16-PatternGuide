package de.ur.mi.android.demos.patternguide.ui.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import de.ur.mi.android.demos.patternguide.R;
import de.ur.mi.android.demos.patternguide.patterns.Pattern;
import de.ur.mi.android.demos.patternguide.patterns.PatternCategory;
import de.ur.mi.android.demos.patternguide.patterns.PatternCollection;

/**
 * Activity zum Darstellung einer Subkategorie an Pattern
 *
 * Subklassen der Activity stellen Patterns aus einer jeweils unterschiedlichen Kategorie dar. Die
 * anzuzeigenden Patterns werden aus String- bzw. String-Array-Ressourcen geladen, die in den Sub-
 * klassen über das Überschreiben entsprechender Getter-Methoden spezifiziert werden.
 *
 * Beim Start der Activity werden die zugehörigen Patterns geladen, das UI über eine Layout-Datei
 * initalisiert und ein Klick-Listener für das ring-förmige Durchschalten des aktuell angezeigten
 * Patterns registriert.
 */
public abstract class PatternActivity extends AppCompatActivity {

    // Sammlung mit den in dieser Activity anzuzeigenden Patterns
    private PatternCollection patternCollection;
    // Referenz auf UI-Element zur Darstellung des Titels des aktuellen Patterns
    private TextView patternTitleText;
    // Referenz auf UI-Element zur Darstellung der Beschreibung des aktuellen Patterns
    private TextView patternDescriptionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initContent();
        initUI();
        renderNextPattern();
    }

    /**
     * Gibt die PatternCategory zurück, deren Inhalte in dieser Activity angezeigt werden sollen
     * @return Die für diese Activity passende PatternCategory
     */
    public abstract PatternCategory getPatternCategory();

    /**
     * Lädt die in der Activity anzuzeigenden Patterns und nutzt dazu die in den Subklassen überschriebene
     * Getter-Methode für die Spezifizierung der Pattern-Kategorie, aus der auch die notwendige Ressourcen-ID
     * für die Pattern-Inhalte ausgelesen werden kann.
     */
    private void initContent() {
        String[] patternsAsCSVArray = getResources().getStringArray(getPatternCategory().resourceID);
        patternCollection = PatternCollection.fromCSVArray(patternsAsCSVArray);
    }

    private void initUI() {
        // Lädt das UI über die entsprechende XML-DDatei
        setContentView(R.layout.activity_pattern);
        /* Referenziert das TextView, in dem die Kategorie der Patterns angezeigt werden soll
         * und setzt dort den korrekten Text ein. Der Vorgang muss nur beim initialen Starten der
         * Activity ausgeführt werden. Eine Speicherung der der View-Referenz in einer Instanzvariable
         * ist daher nicht notwendig.
         */
        TextView patternCategoryTitle = findViewById(R.id.patternCategoryText);
        patternCategoryTitle.setText(getPatternCategory().categoryName);
        /* Referenziert den Button, mit dem die Nutzer*innen das jeweils nächste Pattern der Kategorie
         * auswählen können. Im Anschluss wird direkt ein Listener für den Button registriert, in dessen
         * Callback-Methode die private Methode der Activity aufgerufen wird, mit der das nächste Pattern
         * ausgewählt und im UI angezeigt werden kann.
         */
        Button selectNextPatternButton = findViewById(R.id.nextPatternButton);
        selectNextPatternButton.setOnClickListener(view -> renderNextPattern());
        // Referenziert das TextView, in dem der Titel des Pattern angezeigt werden soll
        patternTitleText = findViewById(R.id.patternTitleText);
        // Referenziert das TextView, in dem der Beschreibungstext des Pattern angezeigt werden soll
        patternDescriptionText = findViewById(R.id.patternDescriptionTitle);
    }

    /**
     * Wählt das nächste Pattern aus der Sammlung aus und zeigt diese im UI der Activity an. Dazu werden
     * Title und Beschreibung des Pattern ausgelesen und als Inhalte der entsprechenden Views gesetzt,
     * die im Vorfeld (siehe initUI) in Instanzvariablen der Activity referenziert wurden.
     */
    public void renderNextPattern() {
        Pattern pattern = patternCollection.nextPattern();
        patternTitleText.setText(pattern.title);
        patternDescriptionText.setText(pattern.description);
    }

}