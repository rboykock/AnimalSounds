package com.rboyko.animalsounds;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.text.method.KeyListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{
	protected SoundPool mSoundPool;
	protected int bearSound,catSound,chikenSound,cowSound,dogSound,pigSound,sheepSound,playSound,mStreamId;
	protected AudioManager audioManager;
	protected float curVolume, maxVolume, leftVolume, rightVolume;
	protected int priority = 1;
	protected int no_loop = 0;
	protected float normal_playback_rate = 1f;
	
	@SuppressWarnings("deprecation")
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ImageView[] iv=new ImageView[9];
		iv[0]=(ImageView) findViewById(R.id.imageBear);
		iv[1]=(ImageView) findViewById(R.id.imageCat);
		iv[2]=(ImageView) findViewById(R.id.imageChiken);
		iv[3]=(ImageView) findViewById(R.id.imageCow);
		iv[4]=(ImageView) findViewById(R.id.imageDog);
		iv[5]=(ImageView) findViewById(R.id.imageFox);
		iv[6]=(ImageView) findViewById(R.id.imagePig);
		iv[7]=(ImageView) findViewById(R.id.imageRabbit);
		iv[8]=(ImageView) findViewById(R.id.imageSheep);
		
		for(ImageView i : iv){
			i.setOnClickListener(this);
		}

		mSoundPool=new SoundPool(1,AudioManager.STREAM_MUSIC,0);
		
		bearSound = mSoundPool.load(this, R.raw.bear, 1);
		catSound =mSoundPool.load(this, R.raw.cat2, 1);
		dogSound=mSoundPool.load(this, R.raw.dog,1);
		sheepSound=mSoundPool.load(this, R.raw.sheep,1);
		pigSound=mSoundPool.load(this, R.raw.pigs, 1);
		cowSound=mSoundPool.load(this, R.raw.cow, 1);
		chikenSound=mSoundPool.load(this, R.raw.rooster, 1);
		
		AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        curVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        leftVolume = curVolume / maxVolume;
        rightVolume = curVolume / maxVolume;


	}
	
	protected void onDestroy() {
		super.onDestroy();
		mSoundPool.release();
	}

	public void onClick(View v) {
		String str="";
		
		switch (v.getId()) {
		case R.id.imageCat:
			str="The Cat";
			playSound=catSound;
			break;
		case R.id.imageBear:
			str="The Bear";
			playSound=bearSound;
			break;
		case R.id.imageChiken:
			str="The Chiken";
			playSound=chikenSound;
			break;	
		case R.id.imageCow:
			str="The Cow";
			playSound=cowSound;
			break;
		case R.id.imageDog:
			str="The Dog";
			playSound=dogSound;
			break;
		case R.id.imageFox:
			str="The Fox";
			playSound=0;
			break;
		case R.id.imagePig:
			str="The Pig";
			playSound=pigSound;
			break;
		case R.id.imageRabbit:
			str="The Rabbit";
			playSound=0;
			break;
		case R.id.imageSheep:
			str="The Sheep";
			playSound=sheepSound;
			break;
		}
		
		mStreamId=mSoundPool.play(playSound, leftVolume, rightVolume, priority, no_loop, normal_playback_rate);
		
		 Toast.makeText(this, str, Toast.LENGTH_LONG).show();
		 
	}
}
