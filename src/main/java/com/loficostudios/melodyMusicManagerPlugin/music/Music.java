package com.loficostudios.melodyMusicManagerPlugin.music;


import com.loficostudios.melodyMusicManagerPlugin.score.Score;
import com.loficostudios.melodyMusicManagerPlugin.score.measure.Measure;
import com.loficostudios.melodyMusicManagerPlugin.score.measure.impl.Beat;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Music {
    public final Score ZELDA_MUSIC = new Score("Nintendo", 100)
            .then(new Measure(
                    Beat.of("G3, A3, B3, C#4"),
                    Beat.of("G3, A3, B3, C#4"),
                    Beat.of("A3, B3, C#4, D#4"),
                    Beat.of("A3, B3, C#4, D#4")
            ))
            .then(new Measure(
                    Beat.of("B3, C#4, D#4, F4"),
                    Beat.of("C4, D4, E4, F#4"),
                    Beat.of("C#4, D#4, F4, G4"),
                    Beat.of("D4, E4, F#4, G#4")
            ))
            .then(new Measure(
                    Beat.of("*, *, *, *"),
                    Beat.of("*, *, *, *"),
                    Beat.of("A4, *, A#4, *"),
                    Beat.of("B4, *, C5, *")
            ));


    public static final Score YASASHII_SUISEI = new Score("Yoasobi", 94)
            .then(new Measure(
                    Beat.of("*, *, *, *"),
                    Beat.of("*, *, *, *"),
                    Beat.of("*, *, *, *"),
                    Beat.of("C4, D4, *, *")
            ))
            .then(new Measure(
                    Beat.of("*, *, F4, *"),
                    Beat.of("F4, *, F4, *"),
                    Beat.of("E4, *, F4, *"),
                    Beat.of("G4, *, A4, A4")
            ))
            .then(new Measure(
                    Beat.of("*, D4, F4, *"),
                    Beat.of("*, *, *, F4"),
                    Beat.of("Eb4, *, F4, G4"),
                    Beat.of("*, *, F4, D4")
            ))
            .then(new Measure(
                    Beat.of("*, *, *, *"),
                    Beat.of("*, *, A#4, *"),
                    Beat.of("A4, *, G4, *"),
                    Beat.of("F4, *, G4, *")
            ))
            .then(new Measure(
                    Beat.of("G4, *, *, *"),
                    Beat.of("F4, *, *, *"),
                    Beat.of("A#4, *, *, *"),
                    Beat.of("A4, *, *, *")
            ))
            //左隣あなたの
            .then(new Measure(
                    Beat.of("*, *, F4, *"),
                    Beat.of("F4, *, F4, *"),
                    Beat.of("E4, *, F4, *"),
                    Beat.of("G4, *, A4, A4")
            ))
            //横顔を
            .then(new Measure(
                    Beat.of("*, D4, F4, *"),
                    Beat.of("*, *, F4, *"),
                    Beat.of("A4, *, A#4, *"),
                    Beat.of("C5, *, G4, *")
            ))
            //月がてらした
            .then(new Measure(
                    Beat.of("*, *, F4, *"),
                    Beat.of("D4, *, F4, *"),
                    Beat.of("A#4, *, A4, *"),
                    Beat.of("D4, *, F4, *")
            ))
            .then(new Measure(
                    Beat.of("*, *, F4, *"),
                    Beat.of("G4, *, A4, *"),
                    Beat.of("C5, *, F5, *"),
                    Beat.of("C4, *, D4, *")
            ));
}
