package com.inc247.chatsampleFragment;

import com.inc247.ChatSDK;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;

public class ChatNowActivity extends Activity 
{

	ChatSDK sdkObject;
	
	 /***********************************************************************
     * Function Name        : onCreate()
     * Description          : Invoke to create the Activity
     * Input parameters     : None
     * output parameters    : None
     * return values        : None
     ************************************************************************/
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		sdkObject=ChatSDK.getSDKInstance();
		sdkObject.addChat(ChatNowActivity.this);
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
		sdkObject.orientationChanged();
	}
	
	
}
