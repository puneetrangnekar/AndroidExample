package com.inc247.chatsampleFragment;

import com.inc247.ChatSDK;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends FragmentActivity 
{
	 private FragmentTabHost mTabHost;
	 
	 /***********************************************************************
	     * Function Name        : onCreate()
	     * Description          : Invoke to create the Activity
	     * Input parameters     : None
	     * output parameters    : None
	     * return values        : None
	     ***********************************************************************/ 
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	    mTabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
	    mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
	        
	    mTabHost.addTab(mTabHost.newTabSpec("chat").setIndicator("Chat"),
	          BatteryFragment.class, null);
	        
	    mTabHost.addTab(mTabHost.newTabSpec("songs").setIndicator("Songs"),
		      NetworkFragment.class, null);
	        
	    mTabHost.addTab(mTabHost.newTabSpec("videos").setIndicator("Videos"),
	          DeviceFragment.class, null);
	        
	     
	}

	 /***********************************************************************
     * Function Name        : onConfigurationChanged()
     * Description          : Notifies the application when the application configuration changes has been minimized.
     * Input parameters     : Configuration newConfig
     * output parameters    : None
     * return values        : None
     ***********************************************************************/ 
	
	@Override
	public void onConfigurationChanged(Configuration newConfig)
	{
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);
	    ChatSDK.getSDKInstance().orientationChanged();
	}
	
	/***********************************************************************
     * Function Name        : onCreateOptionsMenu()
     * Description          : Invoke to create the items in menu
     * Input parameters     : Menu
     * output parameters    : 
     * return values        : Create items in the Menu
     ***********************************************************************/  
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		
		MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.layout.menu, menu);
		return true;
	}

	/***********************************************************************
     * Function Name        : onOptionsItemSelected()
     * Description          : Invoke to create the events on selection of menuitem.
     * Input parameters     : MenuItem
     * output parameters    : 
     * return values        : Specified event mention in the code.
     ***********************************************************************/
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) 
	{
		  switch (item.getItemId()) 
          {
                  //Menu option Chat
              case R.id.menu_chat: 
              	mTabHost.setCurrentTab(0);
                  return true;

                  //Menu option Songs
              case R.id.menu_songs:    
              	mTabHost.setCurrentTab(1);
                  return true;

                  //Menu option Videos
              case R.id.menu_videos:  
              	mTabHost.setCurrentTab(2);
                  return true;

              default:
                  return super.onOptionsItemSelected(item);
          }

	}
	
	 /*****************************************************************************************
     * Function Name        : onRestart()
     * Description          : Gets called when Activity comes in foreground from background .
     * Input parameters     : None
     * output parameters    : None
     * return values        : None
     *****************************************************************************************/
	
	@Override
	protected void onRestart() 
	{
		// TODO Auto-generated method stub
		super.onRestart();
		ChatSDK.getSDKInstance().addChat(this);
	}
	
}
