package de.ur.mi.android.demos.patternguide.patterns;

/**
 * Stellt eine Sammlung von Pattern dar, die u.a. auch aus einem String-Array mit entsprechend
 * formatierten Inhalten initialisiert werden kann. Über eine öffentliche Methode können die Pattern
 * der Kollektion ausgelesen werden. Zurückgegeben wird dabei immer das nächste Pattern in der Liste.
 * In einem Ringschluss wird nach dem letzten Pattern der Liste wieder das erste zurückgegeben.
 */
public class PatternCollection {

    // Standardwert für Trennzeichen zwischen Titel und Beschreibung der Pattern in den Ressourcen-Strings
    private static final String DEFAULT_CSV_DELIMITER = ";";
    // Array mit den Pattern dieser Kategorie
    private final Pattern[] collection;
    // Position des nächsten Pattern in dem Array
    private int nextIndex;

    public PatternCollection(Pattern[] collection) {
        this.collection = collection;
        nextIndex = 0;
    }

    public Pattern nextPattern() {
        Pattern nextPattern = collection[nextIndex];
        nextIndex = getNextPatternIndex();
        return nextPattern;
    }

    private int getNextPatternIndex() {
        if (nextIndex < collection.length - 1) {
            return nextIndex + 1;
        }
        return 0;
    }

    public static PatternCollection fromCSVArray(String[] csvArray) {
        return fromCSVArray(csvArray, DEFAULT_CSV_DELIMITER);
    }

    /**
     * Erzeugt eine neue PatternCollection auf Basis der übergebenen StringArrays. Aus den Inhalten
     * des Arrays werden neue Pattern-Objekte erstellt. Dazu wird der jeweilige String als CSV-formatierter
     * Inhalt interpretiert und so Titel und Beschreibung für das neue Pattern extrahiert. Das Trennzeichen
     * wird als zusätzlicher Parameter übergeben. Die erstellten Pattern werden als neue PatternCollection
     * zurückgegeben.
     * @param csvArray Array mit den einzelnen CSV-formatierten Strings, aus denen die Pattern erstellt werden
     * @param delimiter Trennzeichen, das innerhalb eines CSV-formatierten Strings Titel und Beschreibung des Pattern trennt
     * @return Die neu erstellte PatternCollection
     */
    public static PatternCollection fromCSVArray(String[] csvArray, String delimiter) {
        Pattern[] patterns = new Pattern[csvArray.length];
        for (int i = 0; i < patterns.length; i++) {
            String title = csvArray[i].split(delimiter)[0];
            String description = csvArray[i].split(delimiter)[1];
            patterns[i] = new Pattern(title, description);
        }
        return new PatternCollection(patterns);
    }

}
