package de.ur.mi.android.demos.patternguide.patterns;

/**
 * Diese Klasse repräsentiert Teile eines Design Pattern, bestehend aus Titel und Beschreibungstext.
 * Instanzen der Klasse sind als Immutables nach Erzeugung hinsichtlich ihrer Eigenschaften nicht mehr
 * veränderbar.
 */
public class Pattern {

    public final String title;
    public final String description;

    public Pattern(String title, String description) {
        this.title = title;
        this.description = description;
    }

}
