package com.inc247.chatsampleFragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class NetworkFragment extends Fragment 
{
	
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

		View view = inflater.inflate(R.layout.network_view, container, false);
		// Inflate the layout for this fragment
		return view;
	}
	
}
