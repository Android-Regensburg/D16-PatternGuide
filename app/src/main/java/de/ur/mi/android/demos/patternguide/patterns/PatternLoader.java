package de.ur.mi.android.demos.patternguide.patterns;

/**
 * Diese Klasse stellt eine Hilfsmethode zum Erstellen von Pattern-Objekten auf Basis einer String-
 * Array-Ressource zur Verfügung. Innerhalb des Ressourcen-Arrays müssen individuelle Patterns als
 * einzelne Items hinterlegt sein. Innerhalb des Items sind Title und Beschreiungstexts des Patterns
 * durch ein Pipe-Symbol ("|") getrennt.
 */
public class PatternLoader {

    public static final String RESOURCE_PART_DELIMITER = "\\|";

    public static Pattern[] loadFromStringResourceArray(String[] array) {
        Pattern[] patterns = new Pattern[array.length];
        for (int i = 0; i < patterns.length; i++) {
            String title = array[i].split(RESOURCE_PART_DELIMITER)[0];
            String description = array[i].split(RESOURCE_PART_DELIMITER)[1];
            patterns[i] = new Pattern(title, description);
        }
        return patterns;
    }
}
