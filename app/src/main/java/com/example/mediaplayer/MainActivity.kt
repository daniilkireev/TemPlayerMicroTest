package com.example.mediaplayer

import android.media.AudioAttributes
import android.media.MediaPlayer
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    private lateinit var autumn: Button
    private lateinit var amor: Button

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        autumn = findViewById(R.id.autumn)
        amor = findViewById(R.id.amor)


        val amorMediaPlayer: MediaPlayer =
            MediaPlayer.create(applicationContext, R.raw.amor).apply {
                setAudioAttributes(
                    AudioAttributes.Builder()
                        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                        .setUsage(AudioAttributes.USAGE_MEDIA)
                        .build()
                )
            }
        val autumnMediaPlayer: MediaPlayer =
            MediaPlayer.create(applicationContext, R.raw.autumn).apply {
                setAudioAttributes(
                    AudioAttributes.Builder()
                        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                        .setUsage(AudioAttributes.USAGE_MEDIA)
                        .build()
                )
            }


        autumnMediaPlayer.setOnPreparedListener {
            it.setPlaybackParams(autumnMediaPlayer.getPlaybackParams().setPitch(1.0f));
            it.setPlaybackParams(autumnMediaPlayer.getPlaybackParams().setSpeed(1.14f));
        }

        amorMediaPlayer.setOnPreparedListener {
            it.setPlaybackParams(autumnMediaPlayer.getPlaybackParams().setPitch(1.0f));
            it.setPlaybackParams(autumnMediaPlayer.getPlaybackParams().setSpeed(0.88f));
        }

        autumn.performClick()
        amor.performClick()

        autumn.setOnClickListener {
            if (autumnMediaPlayer.isPlaying) {
                autumnMediaPlayer.pause()
            } else {
                autumnMediaPlayer.start()
            }
        }

        amor.setOnClickListener {
            if (amorMediaPlayer.isPlaying) {
                amorMediaPlayer.pause()
            } else {
                amorMediaPlayer.start()
            }
        }


    }
}