package com.example.httpdemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

	private Context mContext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mContext = this;
		this.initView();
	}

	/**
	 * 初始化view
	 */
	public void initView(){
		Button button = (Button)findViewById(R.id.button_main);
		button.setOnClickListener(new buttonClick());
	}

	class  buttonClick implements View.OnClickListener{

		@Override
		public void onClick(View v) {
			Toast.makeText(mContext,"点击我干嘛",Toast.LENGTH_LONG).show();
			this.upActivity();
		}
		public void upActivity(){

			Intent mIntent=new Intent();
			mIntent.setClass(mContext,TwoAcitivity.class);
			startActivity(mIntent);
		}
	}
}
