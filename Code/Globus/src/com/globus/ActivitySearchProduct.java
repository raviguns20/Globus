package com.globus;

import java.util.ArrayList;

import com.globus.base.BaseClass;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;

public class ActivitySearchProduct extends BaseClass implements OnClickListener{
	private Toolbar mToolbar;
	RelativeLayout btnVoiceSearch,btnBarcodeSearch;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity_search_product);
		init();
	}

	private void init() {
		mToolbar = (Toolbar)findViewById(R.id.main_toolbar);
		setSupportActionBar(mToolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);

		btnBarcodeSearch = (RelativeLayout)findViewById(R.id.btn_barcode_serach);
		btnBarcodeSearch.setOnClickListener(this);
		btnVoiceSearch = (RelativeLayout)findViewById(R.id.btn_voice_serach);
		btnVoiceSearch.setOnClickListener(this);


	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) { 
		switch (item.getItemId()) {
		case android.R.id.home: 
			onBackPressed();
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_barcode_serach:
			break;
		case R.id.btn_voice_serach:
			System.out.println("Clicked on search");
			//	onSearchRequested();
			startVoiceRecognitionActivity();
			break;

		default:
			break;
		}
	}
	private static final int VOICE_RECOGNITION_REQUEST_CODE = 1234;

	private void startVoiceRecognitionActivity() {
		Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
		// identifying your application to the Google service
		intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, getClass().getPackage().getName());
		// hint in the dialog
		intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Globus Search");
		// hint to the recognizer about what the user is going to say
		intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
				RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
		// number of results
		intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 5);
		// recognition language
		intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE,"en-US");
		startActivityForResult(intent, VOICE_RECOGNITION_REQUEST_CODE);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == VOICE_RECOGNITION_REQUEST_CODE && resultCode == RESULT_OK) {
			ArrayList<String> matches = data.getStringArrayListExtra(
					RecognizerIntent.EXTRA_RESULTS);
			// do whatever you want with the results
			for (int i = 0; i < matches.size(); i++) {
				System.out.println(matches.get(i));

			}
		}
		super.onActivityResult(requestCode, resultCode, data);
	}
}
