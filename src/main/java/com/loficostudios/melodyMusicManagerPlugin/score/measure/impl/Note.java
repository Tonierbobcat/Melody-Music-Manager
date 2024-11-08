/**
 * @Author Tonierbobcat
 */

package com.loficostudios.melodyMusicManagerPlugin.score.measure.impl;

//https://www.reddit.com/r/Minecraft/comments/1hazq2/table_and_formula_to_convert_note_block_clicks/

import org.jetbrains.annotations.Nullable;

public interface Note {

    public static final Note F3 = Note.of((float) calculatePitch(-13));
    public static final Note F_SHARP3 = Note.of(0.5f);
    public static final Note G3 = Note.of((float) calculatePitch(-11));
    public static final Note G_SHARP3 = Note.of((float) calculatePitch(-10));
    public static final Note A3 = Note.of((float) calculatePitch(-9));
    public static final Note A_SHARP3 = Note.of((float) calculatePitch(-8));
    public static final Note B3 = Note.of((float) calculatePitch(-7));

    public static final Note C4 = Note.of((float) calculatePitch(-6));
    public static final Note C_SHARP4 = Note.of((float) calculatePitch(-5));
    public static final Note D4 = Note.of((float) calculatePitch(-4));
    public static final Note D_SHARP4 = Note.of((float) calculatePitch(-3));
    public static final Note E4 = Note.of((float) calculatePitch(-2));
    public static final Note F4 = Note.of((float) calculatePitch(-1));
    public static final Note F_SHARP4 = Note.of(1f);
    public static final Note G4 = Note.of((float) calculatePitch(1));
    public static final Note G_SHARP4 = Note.of((float) calculatePitch(2));
    public static final Note A4 = Note.of((float) calculatePitch(3));
    public static final Note A_SHARP4 = Note.of((float) calculatePitch(4));
    public static final Note B4 = Note.of((float) calculatePitch(5));

    Note C5 = Note.of((float) calculatePitch(6));
    public static final Note C_SHARP5 = Note.of((float) calculatePitch(7));
    public static final Note D5 = Note.of((float) calculatePitch(8));
    public static final Note D_SHARP5 = Note.of((float) calculatePitch(9));
    public static final Note E5 = Note.of((float) calculatePitch(10));
    public static final Note F5 = Note.of((float) calculatePitch(11));
    public static final Note F_SHARP5 = Note.of(2f);


    static @Nullable Note getNote(String string) {

        String[] strings = string.split(":");

        String noteLabel = strings[0];

        final int volume = strings.length > 1
                ? Integer.parseInt(strings[1])
                : 100;

        if (string.isEmpty() || string.equals("*"))
            return null;

        //B3, G, *, A; B3, G, *, A; B3, G, *, A; B3, G, *, A;

        //Eb D#

        //B4:100 // volume

        //float volume = //string split

        Note note = switch (noteLabel) {
            case "F3" -> Note.F3;
            case "F#3", "Gb3" -> Note.F_SHARP3;
            case "G3" -> Note.G3;
            case "G#3", "Ab3" -> Note.G_SHARP3;
            case "A3" -> Note.A3;
            case "A#3", "Bb3" -> Note.A_SHARP3;
            case "B3" -> Note.B3;

            case "C4" -> Note.C4;
            case "C#4", "Db4" -> Note.C_SHARP4;
            case "D4" -> Note.D4;
            case "D#4", "Eb4" -> Note.D_SHARP4;
            case "E4" -> Note.E4;

            //

            case "F4" -> Note.F4;
            case "F#4", "Gb4" -> Note.F_SHARP4;
            case "G4" -> Note.G4;
            case "G#4", "Ab4" -> Note.G_SHARP4;
            case "A4" -> Note.A4;
            case "A#4", "Bb4" -> Note.A_SHARP4;
            case "B4" -> Note.B4;

            case "C5" -> Note.C5;
            case "C#5", "Db5" -> Note.C_SHARP5;
            case "D5" -> Note.D5;
            case "D#5", "Eb5" -> Note.D_SHARP5;
            case "E5" -> Note.E5;

            //

            case "F5" -> Note.F5;
            case "F#5" -> Note.F_SHARP5;

            default -> throw new IllegalStateException("Unexpected value: " + noteLabel);
        };

        return new Note() {
            @Override
            public float getPitch() {
                return note.getPitch();
            }

            @Override
            public float getVolume() {
                return volume / 100f; //minecraft only accepts a float 0-2 for volume so I divide volume by 100
            }
        };
    }

    float getPitch();
    float getVolume();

    private static Note of(float pitch) {
        return new Note() {
            @Override
            public float getPitch() {
                return pitch;
            }

            @Override
            public float getVolume() {
                return 1;
            }
        };
    }

    private static double calculatePitch(int n) {
        return Math.pow(2, (double) n / 12);
    }
}
