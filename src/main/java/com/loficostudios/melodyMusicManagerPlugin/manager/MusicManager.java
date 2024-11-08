package com.loficostudios.melodyMusicManagerPlugin.manager;

import com.loficostudios.melodyMusicManagerPlugin.MelodyMusicManagerPlugin;
import com.loficostudios.melodyMusicManagerPlugin.score.Score;
import com.loficostudios.melodyMusicManagerPlugin.score.measure.Measure;
import com.loficostudios.melodyMusicManagerPlugin.enums.Instrument;
import com.loficostudios.melodyMusicManagerPlugin.score.measure.impl.Beat;
import com.loficostudios.melodyMusicManagerPlugin.score.measure.impl.Note;
import com.loficostudios.melodyapi.utils.Common;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.Map;

public class MusicManager {
    MelodyMusicManagerPlugin plugin;
    public MusicManager(MelodyMusicManagerPlugin plugin) {
        this.plugin = plugin;
    }

    public void playerScore(Player player, Score score) {
        new BukkitRunnable() {
            int ticks = 0;

            int beatIndex = 0;
            int measureIndex = 0;

            private Measure currentMeasure;
            private Beat currentBeat;
            @Override
            public void run() {

                if (ticks % 4 == 0) {
                    if (beatIndex % 4 == 0) {
                        beatIndex = 0;
                        //player.playSound(player.getLocation(), Instrument.BELLS.getSound(), 1, 1);

                        if (measureIndex == score.getMeasureAmount()) {
                            this.cancel();
                            return;
                        }

                        currentMeasure = score.getMeasure(measureIndex);

                        measureIndex++;
                    }
                    //player.playSound(player.getLocation(), Instrument.HI_HAT.getSound(), 1, 1);

                    currentBeat = currentMeasure.getBeat(beatIndex);
                    beatIndex++;



                    player.sendMessage("Beats: " + beatIndex + " measureIndex: " + measureIndex);
                }

                ticks++;

                Common.broadcast(String.valueOf(ticks));


                if (currentBeat != null) {

                    Note note = switch (ticks) {
                        case 1 -> currentBeat.getNote1();
                        case 2 -> currentBeat.getNote2();
                        case 3 -> currentBeat.getNote3();
                        case 4 -> currentBeat.getNote4();
                        default -> null;
                    };

                    if (note != null) {

                        Instrument instrument = Instrument.PIANO;
                        float pitch = note.getPitch();

                        player.playSound(player.getLocation(), instrument.getSound(), 1, pitch);

                    }
                }

                if (ticks == 4) {
                    ticks = 0;
                }

                //Play Notes
                //player.playSound(player.getLocation(), Instrument.PIANO.getSound(), 1, 1.5f);
            }
        }.runTaskTimerAsynchronously(plugin, 0, ((60 * 20) / (score.getBpm() * 4L)));
    }

    public void startBpm(Player player) {

        //20 ticks in a second //60 beats per minute
        //20 * 60 = 1200 ticks

        //formula to get bpm = (60 * 20) / bpm

        int bpm = 100;

        new BukkitRunnable() {

            int ticks = 0;

            int beats = 0;
            int measures = 0;


            //



            @Override
            public void run() {

                if (ticks % 4 == 0) {
                    if (beats % 4 == 0) {
                        beats = 0;
                        player.playSound(player.getLocation(), Instrument.BELLS.getSound(), 1, 1);
                        measures++;
                    }
                    player.playSound(player.getLocation(), Instrument.HI_HAT.getSound(), 1, 1);
                    beats++;

                    player.sendMessage("Beats: " + beats + " measures: " + measures);
                }

                ticks++;

                //Play Notes
                player.playSound(player.getLocation(), Instrument.PIANO.getSound(), 1, 1.5f);
            }
        }.runTaskTimerAsynchronously(plugin, 0, ((60 * 20) / bpm) / 4);
    }

    public BukkitTask playMusicMap(Player player, @Nullable Block blockSource, Map<Integer, Note> map, @Nullable Runnable onComplete) {
        Location source = blockSource != null
                ? blockSource.getLocation()
                : player.getLocation();

        return new BukkitRunnable() {

            final int maxTicks = Collections.max(map.keySet());
            int ticks = 0;

            @Override
            public void run() {
                if (ticks <= maxTicks) {
                    float pitch = map.get(this.ticks).getPitch();

                    playNote(player, source, pitch);

                    ticks++;
                }
                else {
                    this.cancel();
                    if (onComplete != null) {
                        Bukkit.getScheduler().runTask(plugin, onComplete);
                    }
                }
            }
        }.runTaskTimerAsynchronously(plugin, 0, 1);
    }

    private void playNote(Player player, Location location, float pitch) {
        player.playSound(
                location,
                Sound.BLOCK_NOTE_BLOCK_PLING,
                2, pitch);
    }
}
