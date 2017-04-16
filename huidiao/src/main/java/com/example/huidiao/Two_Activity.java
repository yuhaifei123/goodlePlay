package com.example.huidiao;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by 胡玉娇 on 2017/4/16.
 */

public class Two_Activity extends Activity{

	private Context mcontext;
	private Activity mactivity;
	private HuiDiao_Demo_01 mHuiDiao;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.two_activity);

		mcontext = this;
		mactivity = this;

		//	initview();
		final EditText text = (EditText)findViewById(R.id.edittext_two);

	}

	private void initview() {

		Button button = (Button)findViewById(R.id.button_two);
		button.setOnClickListener(new buttonClick());
	}

	class buttonClick implements View.OnClickListener{

		@Override
		public void onClick(View v) {
			mactivity.finish();
		}
	}
}
