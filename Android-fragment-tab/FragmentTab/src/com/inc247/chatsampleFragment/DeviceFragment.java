package com.inc247.chatsampleFragment;



import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;


public class DeviceFragment extends Fragment  

{
	public Button btnChatAgent;
	 @Override
	 
	 /***********************************************************************
	    * Function Name        : onCreateView()
	    * Description          : Invoke to create the View
	    * Input parameters     : None
	    * output parameters    : None
	    * return values        : None
	    ************************************************************************/
	 
	 public View onCreateView(LayoutInflater inflater, ViewGroup container, 
	        Bundle savedInstanceState) 
	 {
	        
		  View V = inflater.inflate(R.layout.device_view, container, false);

	      btnChatAgent=(Button)V.findViewById(R.id.buttonChatnow);
		  btnChatAgent.setOnClickListener(new OnClickListener()
		  {
			
			@Override
			public void onClick(View v) 
			{
           
			Intent intent=new Intent(getActivity(),ChatNowActivity.class);
            startActivity(intent);
				
			}
		});
	        return V;
     }
	 
}
