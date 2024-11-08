package com.loficostudios.melodyMusicManagerPlugin.score.measure;

import com.loficostudios.melodyMusicManagerPlugin.score.measure.impl.Beat;
import org.jetbrains.annotations.Nullable;

public class Measure {

    private final Beat beat1;

    private final Beat beat2;

    private final Beat beat3;

    private final Beat beat4;

    public @Nullable Beat getBeat(int index) {
        return switch (index) {
            case 0 -> beat1;
            case 1 -> beat2;
            case 2 -> beat3;
            case 3 -> beat4;
            default -> null;
        };
    }

    public Measure(Beat beat1, Beat beat2, Beat beat3, Beat beat4) {
        this.beat1 = beat1;
        this.beat2 = beat2;
        this.beat3 = beat3;
        this.beat4 = beat4;
    }
}
