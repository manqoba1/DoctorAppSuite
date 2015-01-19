package com.sifiso.codetribe.dvs.doctorlib.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.util.Log;

import com.google.gson.Gson;
import com.sifiso.codetribe.dvs.doctorlib.dto.DoctorDTO;

import java.util.Date;

public class SharedUtil {

    public static DoctorDTO getDoctor(Context ctx) {
        SharedPreferences sp = PreferenceManager
                .getDefaultSharedPreferences(ctx);
        String j = sp.getString(Constants.DOCTOR, null);
        Gson g = new Gson();
        if (j != null) {
            return g.fromJson(j, DoctorDTO.class);
        }

        return null;
    }

    public static void setSessionID(Context ctx, String sessionID) {
        SharedPreferences sp = PreferenceManager
                .getDefaultSharedPreferences(ctx);

        Editor ed = sp.edit();
        ed.putString(Statics.SESSION_ID, sessionID);
        ed.commit();

        Log.w("SharedUtil", "#### web socket session id saved: " + sessionID);

    }

    public static String getSessionID(Context ctx) {
        SharedPreferences sp = PreferenceManager
                .getDefaultSharedPreferences(ctx);
        String j = sp.getString(Statics.SESSION_ID, null);

        return j;
    }

    public static void setDoctor(Context ctx, DoctorDTO student) {
        SharedPreferences sp = PreferenceManager
                .getDefaultSharedPreferences(ctx);
        Gson g = new Gson();
        String json = g.toJson(student);
        Editor ed = sp.edit();
        ed.putString(Constants.DOCTOR, json);
        ed.commit();

    }

    public static Date getLastCompletionDate(Context ctx) {
        SharedPreferences sp = PreferenceManager
                .getDefaultSharedPreferences(ctx);
        long cnt = sp.getLong(Constants.LAST_COMPLETION_DATE, 0);
        if (cnt == 0) return null;
        Date date = new Date(cnt);
        return date;
    }

    public static void setLastCompletionDate(Context ctx) {
        SharedPreferences sp = PreferenceManager
                .getDefaultSharedPreferences(ctx);
        Editor ed = sp.edit();
        ed.putLong(Constants.LAST_COMPLETION_DATE, new Date().getTime());
        ed.commit();

    }

    public static long getPhotoUploadDate(Context ctx) {
        SharedPreferences sp = PreferenceManager
                .getDefaultSharedPreferences(ctx);
        long cnt = sp.getInt(Constants.PHOTO_UPLOAD_DATE, 0);

        return cnt;
    }

    public static void setPhotoUploadDate(Context ctx) {
        SharedPreferences sp = PreferenceManager
                .getDefaultSharedPreferences(ctx);
        Editor ed = sp.edit();
        ed.putLong(Constants.PHOTO_UPLOAD_DATE, new Date().getTime());
        ed.commit();

    }

    public static int getCoursePressHoldCount(Context ctx) {
        SharedPreferences sp = PreferenceManager
                .getDefaultSharedPreferences(ctx);
        int cnt = sp.getInt(Constants.PRESS_HOLD_COURSE_COUNT, 0);

        return cnt;
    }

    public static void incrementCoursePressHoldCount(Context ctx) {
        SharedPreferences sp = PreferenceManager
                .getDefaultSharedPreferences(ctx);
        int cnt = sp.getInt(Constants.PRESS_HOLD_COURSE_COUNT, 0);
        cnt++;
        Editor ed = sp.edit();
        ed.putInt(Constants.PRESS_HOLD_COURSE_COUNT, cnt);
        ed.commit();

    }

    public static int getCategoryPressHoldCount(Context ctx) {
        SharedPreferences sp = PreferenceManager
                .getDefaultSharedPreferences(ctx);
        int cnt = sp.getInt(Constants.PRESS_HOLD_CATEGORY_COUNT, 0);

        return cnt;
    }

    public static void incrementCategoryPressHoldCount(Context ctx) {
        SharedPreferences sp = PreferenceManager
                .getDefaultSharedPreferences(ctx);
        int cnt = sp.getInt(Constants.PRESS_HOLD_CATEGORY_COUNT, 0);
        cnt++;
        Editor ed = sp.edit();
        ed.putInt(Constants.PRESS_HOLD_CATEGORY_COUNT, cnt);
        ed.commit();

    }


    public static String getImageUri(Context ctx) {

        SharedPreferences sp = PreferenceManager
                .getDefaultSharedPreferences(ctx);
        String s = sp.getString(Constants.IMAGE_URI, null);

        return s;
    }

    public static String getThumbUri(Context ctx) {

        SharedPreferences sp = PreferenceManager
                .getDefaultSharedPreferences(ctx);
        String s = sp.getString(Constants.THUMB_URI, null);

        return s;
    }

    public static void saveImageUri(Context ctx, Uri uri) {
        SharedPreferences sp = PreferenceManager
                .getDefaultSharedPreferences(ctx);
        Editor ed = sp.edit();
        ed.putString(Constants.IMAGE_URI, uri.toString());
        ed.commit();
    }

    public static void saveThumbUri(Context ctx, Uri uri) {
        SharedPreferences sp = PreferenceManager
                .getDefaultSharedPreferences(ctx);
        Editor ed = sp.edit();
        ed.putString(Constants.THUMB_URI, uri.toString());
        ed.commit();
    }

    public static void saveCalendarID(Context ctx, long id) {
        SharedPreferences sp = PreferenceManager
                .getDefaultSharedPreferences(ctx);
        Editor ed = sp.edit();
        ed.putLong(Constants.CALENDAR_ID, id);
        ed.commit();
    }

    public static long getCalendarID(Context ctx) {
        SharedPreferences sp = PreferenceManager
                .getDefaultSharedPreferences(ctx);
        long s = sp.getLong(Constants.CALENDAR_ID, -1);
        return s;
    }


    private static final Gson gson = new Gson();
}
