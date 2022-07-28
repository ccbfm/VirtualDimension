package com.ccbfm.virtual.dimension.utils;

import android.util.Log;

public final class LogUtils {
    private static final String TAG = "VirtualD";
    private static final boolean DEBUG = true;

    public static void d(String tag, String msg) {
        d(tag, msg, null);
    }

    public static void d(String tag, String msg, boolean debug) {
        d(tag, msg, null, debug);
    }

    public static void d(String tag, String msg, Throwable th) {
        d(tag, msg, th, true);
    }

    public static void d(String tag, String msg, Throwable th, boolean debug) {
        if (!DEBUG || !debug) {
            return;
        }
        if (th != null) {
            Log.d(TAG, tag + ">" + msg, th);
        } else {
            Log.d(TAG, tag + ">" + msg);
        }
    }

    public static void w(String tag, String msg) {
        w(tag, msg, null);
    }

    public static void w(String tag, String msg, boolean debug) {
        w(tag, msg, null, debug);
    }

    public static void w(String tag, String msg, Throwable th) {
        w(tag, msg, th, true);
    }

    public static void w(String tag, String msg, Throwable th, boolean debug) {
        if (!DEBUG || !debug) {
            return;
        }
        if (th != null) {
            Log.w(TAG, tag + ">" + msg, th);
        } else {
            Log.w(TAG, tag + ">" + msg);
        }
    }

    public static void e(String tag, String msg) {
        e(tag, msg, null);
    }

    public static void e(String tag, String msg, boolean debug) {
        e(tag, msg, null, debug);
    }

    public static void e(String tag, String msg, Throwable th) {
        e(tag, msg, th, true);
    }

    public static void e(String tag, String msg, Throwable th, boolean debug) {
        if (!DEBUG || !debug) {
            return;
        }
        if (th != null) {
            Log.e(TAG, tag + ">" + msg, th);
        } else {
            Log.e(TAG, tag + ">" + msg);
        }
    }
}
