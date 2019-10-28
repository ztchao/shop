package com.common.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class FileUtils {
	
	/**
	 * 文件下载 
	 * @param httpUrl 下载路径
	 * @param saveFile 服务存储地址
	 * @param reqType 请求类型 GET POST
	 * @return
	 */
	public static boolean httpDownload(String httpUrl, String saveFile, String reqType) {
        // 1.下载网络文件
        int byteRead;
        URL url;
        try {
            url = new URL(httpUrl);
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
            return false;
        }
        try {
            //2.获取链接
            //URLConnection conn = url.openConnection();
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod(reqType);
            
            //3.输入流
            InputStream inStream = httpURLConnection.getInputStream();       
            //3.写入文件
            FileOutputStream fs = new FileOutputStream(saveFile);
            
            byte[] buffer = new byte[1024];
            while ((byteRead = inStream.read(buffer)) != -1) {
                fs.write(buffer, 0, byteRead);
            }
            inStream.close();
            fs.close();
            System.out.println("sucess-u-OK");
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

}
