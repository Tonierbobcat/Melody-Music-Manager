package com.loficostudios.melodyMusicManagerPlugin.enums;


import org.bukkit.Sound;

@SuppressWarnings("LombokGetterMayBeUsed")
public enum Instrument {

    BASS(Sound.BLOCK_NOTE_BLOCK_BASS),
    SNARE_DRUM(Sound.BLOCK_NOTE_BLOCK_SNARE),
    HI_HAT(Sound.BLOCK_NOTE_BLOCK_HAT),
    BASS_DRUM(Sound.BLOCK_NOTE_BLOCK_BASEDRUM),
    BELLS(Sound.BLOCK_NOTE_BLOCK_BELL),
    FLUTE(Sound.BLOCK_NOTE_BLOCK_FLUTE),
    CHIMES(Sound.BLOCK_NOTE_BLOCK_CHIME),
    GUITAR(Sound.BLOCK_NOTE_BLOCK_GUITAR),
    XYLOPHONE(Sound.BLOCK_NOTE_BLOCK_XYLOPHONE),
    VIBRAPHONE(Sound.BLOCK_NOTE_BLOCK_IRON_XYLOPHONE),
    COW_BELL(Sound.BLOCK_NOTE_BLOCK_COW_BELL),
    DIDGERIDOO(Sound.BLOCK_NOTE_BLOCK_DIDGERIDOO),
    BIT(Sound.BLOCK_NOTE_BLOCK_BIT),
    BANJO(Sound.BLOCK_NOTE_BLOCK_BANJO),
    PIANO(Sound.BLOCK_NOTE_BLOCK_PLING);

    private final Sound sound;

    Instrument(Sound sound) {
        this.sound = sound;
    }

    public Sound getSound() {
        return sound;
    }
}
