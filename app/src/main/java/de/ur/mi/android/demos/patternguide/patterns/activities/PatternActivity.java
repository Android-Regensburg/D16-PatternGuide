package de.ur.mi.android.demos.patternguide.patterns.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

import de.ur.mi.android.demos.patternguide.R;
import de.ur.mi.android.demos.patternguide.patterns.Pattern;
import de.ur.mi.android.demos.patternguide.patterns.PatternLoader;

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

    // Array mit den anzuzeigenden Patterns
    private Pattern[] patterns;
    // Index-Position des aktuell darzustellenden Pattern im Array
    private int currentPatternIndex;
    // Referenz auf UI-Element zur Darstellung des Titels des aktuellen Patterns
    private TextView patternTitleText;
    // Referenz auf UI-Element zur Darstellung der Beschreibung des aktuellen Patterns
    private TextView patternDescriptionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initContent();
        initUI();
        renderPatternFromIndex(currentPatternIndex);
    }

    /**
     * Subklassen spezifizieren über das Implementieren dieser Methode den Titlel der konkrete
     * Patternsammlung, die in der jeweiligen Activity angezeigt werden soll.
     *
     * @return ID zu einer String-Ressource, die in der Activity als Kategorientitel angezeigt werden soll
     */
    public abstract int getPatternCategoryID();

    /**
     * Subklassen spezifizieren über das Implementieren dieser Methode die konkrete
     * Patternsammlung, die in der jeweiligen Activity angezeigt werden soll.
     *
     * @return ID zu einer String-Array-Ressource, deren Inhalt als Pattern in der Activity angezeigt werden sollen
     */
    public abstract int getPatternArrayID();

    /**
     * Lädt die in der Activity anzuzeigenden Patterns und nutzt dazu die in den Subklassen überschriebene
     * Getter-Methode für die Spezifzierung der ID des String-Arrays (Ressource)
     */
    private void initContent() {
        String[] patternsAsStringArray = getResources().getStringArray(getPatternArrayID());
        patterns = PatternLoader.loadFromStringResourceArray(patternsAsStringArray);
        currentPatternIndex = 0;
    }

    private void initUI() {
        setContentView(R.layout.activity_pattern);
        TextView patternCategoryTitle = findViewById(R.id.patternCategoryText);
        // Liest die passende Pattern-Kategorie aus den Ressourcen aus
        patternCategoryTitle.setText(getResources().getText(getPatternCategoryID()));
        Button selectNextPatternButton = findViewById(R.id.nextPatternButton);
        selectNextPatternButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNextPattern();
            }
        });
        patternTitleText = findViewById(R.id.patternTitleText);
        patternDescriptionText = findViewById(R.id.patternDescriptionTitle);
    }

    /**
     * Wählt den Index des nächsten anzuzeigenden Pattern aus dem Array aus und stellt dieses im UI dar.
     * Nach dem letzten Pattern wird als nächstes wieder das erste Pattern aus dem Array angezeigt.
     */
    private void setNextPattern() {
        currentPatternIndex = (currentPatternIndex == patterns.length - 1) ? 0 : currentPatternIndex + 1;
        renderPatternFromIndex(currentPatternIndex);
    }

    /**
     * Stellt  das übergebene Pattern im UI dar
     */
    private void renderPatternFromIndex(int patternIndex) {
        patternTitleText.setText(patterns[patternIndex].title);
        patternDescriptionText.setText(patterns[patternIndex].description);
    }

}