package game.utility;

import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Soundtrack {
	
	private Clip traccia;
	private AudioInputStream audioInput;
	
	public Soundtrack(String nomeTraccia) {
		try {
			audioInput = AudioSystem.getAudioInputStream(getClass().getResourceAsStream("/audio/"+ nomeTraccia));
			traccia = AudioSystem.getClip();
			traccia.open(audioInput);
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			traccia = null;
			e.printStackTrace();
		}
	}

	public void loop() {
		if (traccia != null) {
			traccia.loop(Clip.LOOP_CONTINUOUSLY);
		}
	}
	
	public void play() {
		if (traccia != null) {
			if (traccia.getFramePosition() == traccia.getFrameLength())
				traccia.setFramePosition(0);
			traccia.start();
		}
	}
	
	public void playNoLoop() {
		if (traccia != null) {
			traccia.start();
		}
	}

	public void stop() {
		if (traccia != null) {
			traccia.stop();
		}
	}

	public void restart() {
		if (traccia != null) {
			traccia.stop();
			traccia.setFramePosition(0);
			traccia.start();
		}
	}
	
	public void abbassaVolume() {
		if (traccia != null) {
			FloatControl gainControl = (FloatControl) traccia.getControl(FloatControl.Type.MASTER_GAIN);
			float valore = gainControl.getValue();
			valore -= 0.50f;
			if (valore >= gainControl.getMinimum())
				gainControl.setValue(valore);
		}
	}

	public void alzaVolume() {
		if (traccia != null) {
			FloatControl gainControl = (FloatControl) traccia.getControl(FloatControl.Type.MASTER_GAIN);
			float valore = gainControl.getValue();
			valore += 0.50f;
			if (valore <= gainControl.getMaximum())
				gainControl.setValue(valore);
		}
	}

	public void setVolume (float volume) {
		if (traccia != null) {
			FloatControl gainControl = (FloatControl) traccia.getControl(FloatControl.Type.MASTER_GAIN);
			volume = gainControl.getValue();
			gainControl.setValue(volume);
		}
	}
	
	

}
