package com.globus.fragments;

import com.globus.ActivityHome;
import com.globus.R;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class FragmentSubCategory extends Fragment{
	View view;
	ImageView imgBack;
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_subcategory, container,false);
		init();
		return view;
	}
	private void init() {
		imgBack=(ImageView)view.findViewById(R.id.imgBack);
		imgBack.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				ActivityHome activity=(ActivityHome)getActivity();
				activity.displayView(0,null);
			}
		});
	}
}
