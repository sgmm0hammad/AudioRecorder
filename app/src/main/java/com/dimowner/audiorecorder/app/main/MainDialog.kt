package com.dimowner.audiorecorder.app.main

import android.app.Dialog
import android.content.Context
import android.content.Context.AUDIO_SERVICE
import android.media.AudioManager
import android.os.Bundle
import android.view.ViewGroup
import android.view.Window
import android.widget.SeekBar
import com.dimowner.audiorecorder.R
import kotlinx.android.synthetic.main.main_dialog.*


class MainDialog(
        private val _context: Context,
        private val initInstrumentVolume: Int,
        private val initVoiceVolume: Int,
) : Dialog(_context) {

    private var onInstrumentVolumeChangedListener: ((Int) -> Unit)? = null
    private var onVoiceVolumeChangedListener: ((Int) -> Unit)? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.main_dialog)
        setDialogSize()

        val am = _context.getSystemService(AUDIO_SERVICE) as AudioManager?
        val deviceVolume = am!!.getStreamVolume(AudioManager.STREAM_MUSIC)

        pbInstrumentVolume.progress = initInstrumentVolume.takeIf { it != -1 } ?: deviceVolume
        pbVoiceVolume.progress = initVoiceVolume.takeIf { it != -1 } ?: deviceVolume

        pbInstrumentVolume.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                onInstrumentVolumeChangedListener?.invoke(p1)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })

        pbVoiceVolume.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                onVoiceVolumeChangedListener?.invoke(p1)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })
    }

    private fun setDialogSize(width: Float? = null, height: Float? = null) {
        val w = width?.let { (_context.resources.displayMetrics.widthPixels * it).toInt() }
        val h = height?.let { (_context.resources.displayMetrics.heightPixels * it).toInt() }
        window?.setLayout(
                w ?: ViewGroup.LayoutParams.MATCH_PARENT,
                h ?: ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }

    fun setOnInstrumentVolumeChangedListener(listener: (Int) -> Unit) {
        onInstrumentVolumeChangedListener = listener
    }

    fun setOnVoiceVolumeChangedListener(listener: (Int) -> Unit) {
        onVoiceVolumeChangedListener = listener
    }

    fun removeOnInstrumentVolumeChangedListener() {
        onInstrumentVolumeChangedListener = null
    }

    fun removeOnVoiceVolumeChangedListener() {
        onVoiceVolumeChangedListener = null
    }
}