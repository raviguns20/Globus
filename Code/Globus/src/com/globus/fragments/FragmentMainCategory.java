package com.globus.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.globus.ActivityHome;
import com.globus.R;

public class FragmentMainCategory extends Fragment {
	View view;
	TextView textView1;
	
	RelativeLayout RLKids,RLWomen,RLMen;
	
	@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_main_category, container,false);
		init();
		return view;
	}

	private void init() {
		
		RLMen=(RelativeLayout)view.findViewById(R.id.RLMen);
		RLWomen=(RelativeLayout)view.findViewById(R.id.RLWomen);
		RLKids=(RelativeLayout)view.findViewById(R.id.RLKids);
		
		RLMen.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				ActivityHome activity=(ActivityHome)getActivity();
				activity.displayView(1,null);
			}
		});
		
		RLWomen.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				ActivityHome activity=(ActivityHome)getActivity();
				activity.displayView(1,null);
			}
		});
		
		RLKids.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				ActivityHome activity=(ActivityHome)getActivity();
				activity.displayView(1,null);
			}
		});
		
	}
}
