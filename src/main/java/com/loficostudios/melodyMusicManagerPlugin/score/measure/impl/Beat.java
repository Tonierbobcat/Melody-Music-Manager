package com.loficostudios.melodyMusicManagerPlugin.score.measure.impl;

import org.jetbrains.annotations.NotNull;

public interface Beat {


    Note getNote1();
    Note getNote2();
    Note getNote3();
    Note getNote4();

    static Beat of(Note note1) {

        return new Beat() {

            @Override
            public Note getNote1() {
                return note1;
            }

            @Override
            public Note getNote2() {
                return null;
            }

            @Override
            public Note getNote3() {
                return null;
            }

            @Override
            public Note getNote4() {
                return null;
            }
        };
    }

    static Beat of(Note note1, Note note2) {

        return new Beat() {

            @Override
            public Note getNote1() {
                return note1;
            }

            @Override
            public Note getNote2() {
                return note2;
            }

            @Override
            public Note getNote3() {
                return null;
            }

            @Override
            public Note getNote4() {
                return null;
            }
        };
    }

    static Beat of(Note note1, Note note2, Note note3) {

        return new Beat() {

            @Override
            public Note getNote1() {
                return note1;
            }

            @Override
            public Note getNote2() {
                return note2;
            }

            @Override
            public Note getNote3() {
                return note3;
            }

            @Override
            public Note getNote4() {
                return null;
            }
        };
    }


    static Beat of(@NotNull String note1, @NotNull String note2, @NotNull String note3, @NotNull String note4) {
        return new Beat() {

            @Override
            public Note getNote1() {
                return Note.getNote(note1);
            }

            @Override
            public Note getNote2() {
                return Note.getNote(note2);
            }

            @Override
            public Note getNote3() {
                return Note.getNote(note3);
            }

            @Override
            public Note getNote4() {
                return Note.getNote(note4);
            }
        };
    }

    static Beat of(String matrix) {

        final String[] notes = matrix.split(", ");

        //beat[ D4:100, E5:50, B3:20, A5:90 ]

        return new Beat() {





            @Override
            public Note getNote1() {
                return Note.getNote(notes[0]);
            }

            @Override
            public Note getNote2() {
                return Note.getNote(notes[1]);
            }

            @Override
            public Note getNote3() {
                return Note.getNote(notes[2]);
            }

            @Override
            public Note getNote4() {
                return Note.getNote(notes[3]);
            }
        };
    }
}
