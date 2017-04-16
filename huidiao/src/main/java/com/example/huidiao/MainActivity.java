package com.example.huidiao;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

	Context mcontext;
	Activity mactivity;
	EditText text;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mcontext = this;
		mactivity = this;

		initVIew();

		text = (EditText)findViewById(R.id.editText_main);
		if (text.getText().toString() != null){

			HuiDiaoClass huiDiaoClass = new HuiDiaoClass();
			huiDiaoClass.setText(new HuiDiao_Demo_01() {
				@Override
				public void Data(String data) {
					Toast.makeText(mcontext,data,Toast.LENGTH_LONG).show();
				}
			},null);
		}
	}

	private void initVIew() {

		Button button = (Button)findViewById(R.id.button_main);
		button.setOnClickListener(new buttonClick());
	}

	private  HuiDiao_Demo_01 mHuiDiao;

	public void setText(HuiDiao_Demo_01 huiDiao){

		this.mHuiDiao = huiDiao;
		this.mHuiDiao.Data(text.getText().toString());
	}

	class buttonClick implements View.OnClickListener{

		@Override
		public void onClick(View v) {

			upView();
		}

		private void upView() {

			Intent intent = new Intent();
			intent.setClass(mcontext,Two_Activity.class);
			startActivity(intent);
		}


	}
}
