package com.example.huidiao;

/**
 * Created by 胡玉娇 on 2017/4/16.
 */

public class HuiDiaoClass {

	private HuiDiao_Demo_01 mHuiDiao;

	public void setText(HuiDiao_Demo_01 huidiao,String data){

		this.mHuiDiao = huidiao;
		if (data == null){
			this.mHuiDiao.Data("你这个傻逼，这么不加数据呢");
		}
		else {
			this.mHuiDiao.Data(data);
		}
	}
}
