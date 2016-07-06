package com.rboyko.animalsounds;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class SplashScreenActivity extends Activity {

	public static final int TIMESLEEP=2;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);
		
		Thread background=new Thread(){
			public void run() {
				try{
					sleep(SplashScreenActivity.TIMESLEEP*1000);
					
					Intent i=new Intent(getBaseContext(),MainActivity.class);
					startActivity(i);
					
					finish();
					
				}catch(Exception e){
					
				}
			}
		};
		
		background.start();
	}

	protected void onDestroy() {
		super.onDestroy();
	}
}
