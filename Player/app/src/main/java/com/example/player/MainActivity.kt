package com.example.player

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.SeekBar





class MainActivity : AppCompatActivity() {

    private lateinit var runnable: Runnable
    private var handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val seekbar : SeekBar = findViewById(R.id.seekbar)
        val playButton : Button = findViewById(R.id.play)
         //create media player
        val mediaPlayer = MediaPlayer.create(this,R.raw.musix)
        //initially se seebar at 0
        //max at media duration
        seekbar.progress = 0
        seekbar.max = mediaPlayer.duration
        //now click the button
        playButton.setOnClickListener{
            // if the media is not playing paly it an change button
            if (!mediaPlayer.isPlaying){
                mediaPlayer.start()
                playButton.setBackgroundResource(R.drawable.ic_baseline_pause_24)
            }else{
                mediaPlayer.pause()
                playButton.setBackgroundResource(R.drawable.ic_baseline_play_arrow_24)
            }
            //now set up the media to play at any time by changing seekBar position

            seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
                override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                    // if hte position of seekBar changed change the media time
                    if (p2){
                        mediaPlayer.seekTo(p1)

                    }
                }

                override fun onStartTrackingTouch(p0: SeekBar?) {

                }

                override fun onStopTrackingTouch(p0: SeekBar?) {

                }


            })

            // now set progress of seek bar whit time
            runnable = Runnable {
              seekbar.progress = mediaPlayer.currentPosition
              handler.postDelayed(runnable,1000)
            }
            //now set the time when the media duration ended
            handler.postDelayed(runnable, 1000)
            mediaPlayer.setOnCompletionListener {
                mediaPlayer.pause()
                playButton.setBackgroundResource(R.drawable.ic_baseline_play_arrow_24)
            }
        }
    }
}