package com.loficostudios.melodyMusicManagerPlugin.score;

import com.loficostudios.melodyMusicManagerPlugin.score.measure.Measure;
import lombok.Getter;

import java.util.*;

public class Score {

    //I want to be able to put Note.F_SHARP3 and Instrument.PIANO

    @Getter
    private final String artist;
    @Getter
    private final int Bpm;

    private List<Measure> measures = new ArrayList<>();

    public Score(String artist, int bpm) {
        this.artist = artist;
        Bpm = bpm;
    }


    public Integer getMeasureAmount() {
        return this.measures.size();
    }

    public Measure getMeasure(int index) {
        return measures.get(index);
    }


    public Score then(Measure measure) {
        this.measures.add(measure);
        return this;
    }
}

