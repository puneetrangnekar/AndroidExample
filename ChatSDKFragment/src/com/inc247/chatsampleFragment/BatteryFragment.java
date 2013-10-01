package com.inc247.chatsampleFragment;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.TextView;

import com.inc247.ChatSDK;
import com.inc247.ChatSDKEventsListener;
import com.inc247.errors.ChatSDKError;

public class BatteryFragment extends Fragment implements ChatSDKEventsListener 
{
	
	ChatSDK sdkObject;
	Button btnChat;
	public JSONObject jsonObject;
	TextView textStatus;
	Button btnnativeChat;
	TextView textCustomStatus;
	private boolean flag=false;

	
	/***********************************************************************
     * Function Name        : onCreateView()
     * Description          : Invoke to create the View
     * Input parameters     : None
     * output parameters    : None
     * return values        : None
    ************************************************************************/
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) 
	{

		// Inflate the layout for this fragment
		View V = inflater.inflate(R.layout.battery_view, container, false);
		
		 /*Invokes the method to create the ChatSDK object.*/
		sdkObject = ChatSDK.initializeChat(getActivity());
		
        /*Invoke to check the availability of Agent.*/
		sdkObject.checkAgentAvailability();
		sdkObject.setChatEventsListener(this);

		
		textStatus = (TextView) V.findViewById(R.id.textStatus);
		btnnativeChat = (Button) V.findViewById(R.id.nativeChatbtn);
		textCustomStatus = (TextView) V.findViewById(R.id.customminimizestatus);
		textCustomStatus.setText(R.string.chatsdk_customminimizestate);

		
		jsonObject = new JSONObject();

		try {
			jsonObject.put("username", "value");
			jsonObject.put("email", "value2");
			jsonObject.put("accountnumber", "value3");

		} catch (Exception e) {
			Log.e("Error", "Exception " + e);
		}

		final Activity act = getActivity();

		btnChat = (Button) V.findViewById(R.id.btnChat);
		
		 /*Invoke the event on the click of the button.*/
		btnChat.setOnClickListener(new OnClickListener() 
		{
			
			@Override
			public void onClick(View v) 
			{
				Log.e("WorkingFine", "Fine!!");
				sdkObject.startChat(jsonObject, act);
			}
		});

		
		 /*Invoke the event on the click of the button.*/
		btnnativeChat.setOnClickListener(new OnClickListener() 
		{

			@Override
			public void onClick(View v) 
			{
				sdkObject.maximizeChat();

			}
		});

	
		if (flag == true)
			btnnativeChat.setVisibility(View.VISIBLE);
		else
			btnnativeChat.setVisibility(View.INVISIBLE);

		return V;
	
	}

	
	/***********************************************************************
     * Function Name        : onAgentMessage()
     * Description          : Notifies application when new agent message has been received in the chat.
     * Input parameters     : JSONObject arg0
     * output parameters    : None
     * return values        : None
     ***********************************************************************/ 
	
	@Override
	public void onAgentMessage(JSONObject arg0) 
	{
		 Log.d("OnAgentMessage:", "Inside onAgentMessage Function");

	}

	
	/***********************************************************************
     * Function Name        : onChatAgentAvailabilty()
     * Description          : Notifies the availability of agent for chat.
     * Input parameters     : JSONObject data
     * output parameters    : None
     * return values        : None
     ***********************************************************************/
	
	@Override
	public void onChatAgentAvailability(boolean isAvailable) 
	{
		Log.e("OnChatAgentAvailability:","onChatAgentAvailability: JSON Data== "+isAvailable ); 
//		 boolean agentStatusString= isAvailable;
		 
//		 if(agentStatusString) 
         {
           /*  agentStatusString is true i.e. Chat Agent is available */

             /* btnChat (Chat Start Button) gets visible */
//             btnChat.setVisibility(View.VISIBLE);

             /* Change the textStatus (No Agent Is Available) to invisible */
//             textStatus.setVisibility(View.INVISIBLE);
         }
//         else
//         {
             /* agentStatusString is false i.e. Chat Agent is not available*/

             /* btnChat (Chat Start Button) gets invisible */
//             btnChat.setVisibility(View.INVISIBLE);

             /* Change the textStatus (No Agent Is Available) to visible */
//             textStatus.setText("No Agent Is Available");
//            textStatus.setVisibility(View.VISIBLE);
 //        }
	}

	
	/***********************************************************************
     * Function Name        : onChatEnded()
     * Description          : Notifies application when chat is ended and the view has been closed.
     * Input parameters     : JSONObject arg0
     * output parameters    : None
     * return values        : None
     ***********************************************************************/
	
	@Override
	public void onChatEnded(JSONObject arg0) 
	{
		Log.d("OnChatEnded:", "Inside onChatEnded Function");
		flag=false;
		Handler handler = new Handler(Looper.getMainLooper());
		handler.post(new Runnable() {

			@Override
			public void run() 
			{
				btnnativeChat.setVisibility(View.GONE);

			}
		});

	}

	
	/***********************************************************************
     * Function Name        : onChatError()
     * Description          : Notifies application developer when the error has occurred
     * Input parameters     : ChatSDKError arg0
     * output parameters    : None
     * return values        : None
     ***********************************************************************/  
	
	@Override
	public void onChatError(ChatSDKError arg0)
	{
		 Log.d("OnChatError:", "Inside function onChatError "+arg0.getErrorMsg());
	}

	
	/***********************************************************************
     * Function Name        : onChatMaximized()
     * Description          : Notifies the application when the chatview has been maximized..
     * Input parameters     : JSONObject arg0
     * output parameters    : None
     * return values        : None
     ***********************************************************************/   
	
	@Override
	public void onChatMaximized(JSONObject arg0) 
	{
		Log.d("OnChatMaximized:", "Inside onChatMaximized Function");

	}

	
	/***********************************************************************
     * Function Name        : onChatMinimized()
     * Description          : Notifies the application when the chatview has been minimized.
     * Input parameters     : JSONObject arg0
     * output parameters    : None
     * return values        : None
     ***********************************************************************/
	
	@Override
	public void onChatMinimized(JSONObject arg0) {
		Log.d("OnChatMinimized:", "Inside onChatMinimized Function");
		
		if (textCustomStatus.getText().equals("false")) 
		{
			btnnativeChat.setVisibility(View.INVISIBLE);
		}

		else if (textCustomStatus.getText().equals("true")) 
		{
			flag = true;
			btnnativeChat.setVisibility(View.VISIBLE);
		}

	}

	
	/***********************************************************************
     * Function Name        : onChatStarted()
     * Description          : Notifies application when chat has started.
     * Input parameters     : JSONObject data
     * output parameters    : None
     * return values        : None
     ***********************************************************************/
	
	@Override
	public void onChatStarted(JSONObject data) 
	{
		   Log.e("OnChatStarted: JSON Data", ""+data);
	}

	
	/***********************************************************************
     * Function Name        : onNavigationRequest()
     * Description          : Notifies application when a request to navigate to a new page in the application is received in the chat & has been clicked by the end user.
     * Input parameters     : JSONObject arg0
     * output parameters    : None
     * return values        : None
     ***********************************************************************/  
	
	@Override
	public void onNavigationRequest(JSONObject arg0) {
		String url = null;
		try {
			url = arg0.getString("url");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Log.d("onNavigationRequest:",
				"Inside onNavigationRequest Function URL " + url);

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
