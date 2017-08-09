package com.gzdmg.xmt.pyinterface.util;

public class CommonUtil {

	public static String getStatusDesc(int status){
		String statusDesc = "";
		switch (status) {
		case 1:
			statusDesc="未支付";
			break;
		case 2:
			statusDesc="已支付";
			break;
		case 3:
			statusDesc="待发货";
			break;
		case 4:
			statusDesc="已发货";
			break;
		case 5:
			statusDesc="订单完成";
			break;
		case 6:
			statusDesc="订单取消";
			break;
		case 7:
			statusDesc="支付失败";
			break;
		default:
			break;
		}
		
		return statusDesc;
	}
}
