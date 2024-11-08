package com.loficostudios.melodyMusicManagerPlugin;

import com.loficostudios.melodyMusicManagerPlugin.manager.MusicManager;
import com.loficostudios.melodyapi.MelodyPlugin;
import lombok.Getter;

public final class MelodyMusicManagerPlugin extends MelodyPlugin<MelodyMusicManagerPlugin> {

    @Getter
    private static MelodyMusicManagerPlugin instance;

    @Getter
    private final MusicManager musicManager = new MusicManager(this);

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
    }

    @Override
    public void onDisable() {
    }
}
