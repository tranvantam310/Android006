package com.windys.myapplication.Util;

// Nếu phải dùng đi, dùng lại các hàm thì Viết vào hàm Util

import android.content.Context;
import android.content.res.Resources;

import com.windys.myapplication.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;

public class Util {

    public static JSONObject fileToJson(int fileName, Context context) {

        try {
            Resources res = context.getResources();
            InputStream in_s = res.openRawResource(fileName);
            byte[] b = new byte[in_s.available()];

            in_s.read(b);
            String strData = new String(b);
            return new JSONObject(strData);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}