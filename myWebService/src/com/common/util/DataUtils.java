/**
 * 
 */
package com.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;

/**
 * @author tengchao
 * 日期工具类型
 */
public class DataUtils {
	
	public static String getCurTimes() {
		Date d = new Date();
		long longtime = d.getTime();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss"); 
		return sdf.format(longtime);
	}
	
	public static String getCurDate() {
		Date d = new Date();
		long longtime = d.getTime();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd"); 
		return sdf.format(longtime);
	}
	
	public static String getStandardCurTimes() {
		Date d = new Date();
		long longtime = d.getTime();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		return sdf.format(longtime);
	}
	
	public static String getStandardCurTimes(String dataStr) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		return sdf.format(dataStr);
	}
	
	public static String getStandardCurDate() {
		Date d = new Date();
		long longtime = d.getTime();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); 
		return sdf.format(longtime);
	}
	//获取昨天的日期
	public static String getYesterDate() {
		Calendar   cal   =   Calendar.getInstance();
		 cal.add(Calendar.DATE,   -1);
		String yeaterDay=new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime()); 
		return yeaterDay;
	}
	
	public static String getStandardDateAndTime(String dateStr){
		Date d = new Date();
		long longtime = d.getTime();
		SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss"); 
		String timeStr = sdf.format(longtime);
		
		return dateStr.substring(0, 10) + " " + timeStr;
	}
	//2016-12-06 donghd add 根据8位日期获取带年月日的日期
	public static String getYYYYMMDDDate(String mDate) {
		String tempS = "";
		if(!"".equals(mDate) || mDate.length() == 8){
			tempS = mDate.substring(0,4) + "年" + mDate.substring(4,6) + "月" + mDate.substring(6,8) + "日";
			return tempS;
		}else{
			return mDate;
		}
	}
	
	/**
	 * 获取当期服务器IP
	 * @return
	 */
	public static String getLocalIP() {
	    String localIP = "127.0.0.1";
	    try {
	        OK:
	        for (Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces(); interfaces.hasMoreElements(); ) {
	            NetworkInterface networkInterface = interfaces.nextElement();
	            if (networkInterface.isLoopback() || networkInterface.isVirtual() || !networkInterface.isUp()) {
	                continue;
	            }
	            Enumeration<InetAddress> addresses = networkInterface.getInetAddresses();
	            while (addresses.hasMoreElements()) {
	                InetAddress address = addresses.nextElement();
	                if (address instanceof Inet4Address) {
	                    localIP = address.getHostAddress();
	                    break OK;
	                }
	            }
	        }
	    } catch (SocketException e) {
	        e.printStackTrace();
	    }
	    return localIP;
	}
	
	
}
