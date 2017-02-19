package com.ksimeo.givorost.impl.utilites;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static com.ksimeo.givorost.impl.utilites.CharsetHelper.UTF_8toISO_8859_1;
import static com.ksimeo.givorost.impl.utilites.CharsetHelper.cp1251toUTF_8;
import static com.ksimeo.givorost.impl.utilites.CharsetHelper.correctI;

/**
 * @author Ksimeo. Created on 22.01.2017 at 19:07 for "web-store-market" project.
 * @version 1.0
 * @since 1.0
 */
public class RequestsHelper {

    // HTTP GET request
    public static String sendGet(String url) throws Exception {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        // optional default is GET
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        String str = cp1251toUTF_8(response.toString());
        str = correctI(str);
        return str;
    }

    // HTTP POST request
    public static String sendPost(String url, String data) throws Exception {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
//        con.setRequestProperty("Accept-Charset", "utf-8");
        data = UTF_8toISO_8859_1(data);
//        data = new String(data.getBytes("utf-8"), "ISO-8859-1");
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(data);
        wr.flush();
        wr.close();
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return cp1251toUTF_8(response.toString());
    }
}