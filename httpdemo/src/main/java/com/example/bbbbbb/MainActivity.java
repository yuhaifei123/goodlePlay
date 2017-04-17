package com.example.bbbbbb;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.bbbbbb.http.AsyncHttpClient;
import com.example.bbbbbb.http.AsyncHttpResponseHandler;
import com.example.bbbbbb.http.RequestParams;

import org.apache.http.Header;

import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity {

	private Context mContext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mContext = this;
	   Button button = (Button) findViewById(R.id.button_main);
		button.setOnClickListener(new buttonClick());

		getHttpa();

	}
	public void getHttpa(){

		String path = "http://192.168.0.101:8080/yuhf/app_common.do";
		AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
		RequestParams requestParams = new RequestParams();
		requestParams.add("name","123");
		asyncHttpClient.post(path, requestParams, new AsyncHttpResponseHandler() {
			@Override
			public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {


				String s = null;
				try {
					s = new String(responseBody, "utf-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				Toast.makeText(mContext,s,Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
				Toast.makeText(mContext,"失敗",Toast.LENGTH_SHORT).show();
				String s = null;
				try {
					s = new String(responseBody,"utf-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				Toast.makeText(mContext,s,Toast.LENGTH_SHORT).show();
			}
		});
	}

	public void initView(){

	}



	class  buttonClick implements View.OnClickListener {

		@Override
		public void onClick(View v) {

			Toast.makeText(mContext,"fsfs",Toast.LENGTH_SHORT).show();
		//	getHttp();
		}

		public void getHttp(){

			String path = "192.168.0.101:8080/hfmiswechat/app_common.do";
			AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
			RequestParams requestParams = new RequestParams();
			requestParams.add("name","123");
			asyncHttpClient.post(path, requestParams, new AsyncHttpResponseHandler() {
				@Override
				public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

					Toast.makeText(mContext,"請求",Toast.LENGTH_SHORT).show();
				}

				@Override
				public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
					Toast.makeText(mContext,"失敗",Toast.LENGTH_SHORT).show();
					String s = null;
					try {
						s = new String(responseBody,"utf-8");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					Toast.makeText(mContext,s,Toast.LENGTH_SHORT).show();
				}
			});
		}
	}
}
