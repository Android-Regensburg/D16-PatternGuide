package de.ur.mi.android.demos.patternguide.patterns;

import de.ur.mi.android.demos.patternguide.R;

/**
 * Das Enum PatternCategory bildet die geschlossene Liste der in der App verwendeten Pattern-
 * Kategorien ab. Alle Pattern sind genau einer dieser Kategorien zugeordnet. Für jede Kategorie
 * ist ein Name (wird als Überschrift der Kategorie im UI angezeigt) sowie eine ID zur String-Array-
 * Ressource angegeben, in der die einzelnen Pattern dieser Kategorie als CSV-formatierte Strings
 * gespeichert sind.
 */
public enum PatternCategory {
    CREATIONAL("Creational Pattern", R.array.creationalPatterns),
    STRUCTURAL("Structural Pattern", R.array.structuralPatterns),
    BEHAVIORAL("Behavioral Pattern", R.array.behavioralPatterns);

    public final String categoryName;
    public final int resourceID;

    PatternCategory(String categoryName, int resourceID) {
        this.categoryName = categoryName;
        this.resourceID = resourceID;
    }

}