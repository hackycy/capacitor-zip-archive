package com.siyee.plugins.ziparchive;

import android.annotation.SuppressLint;
import android.app.Application;
import android.text.TextUtils;
import android.util.Log;
import com.getcapacitor.JSArray;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import java.util.List;

@CapacitorPlugin(name = "ZipArchive")
public class ZipArchivePlugin extends Plugin {

    @SuppressLint("StaticFieldLeak")
    private static Application sApp;

    @Override
    public void load() {
        sApp = this.getActivity().getApplication();
        super.load();
    }

    /**
     * Return the Application object.
     * <p>Main process get app by UtilsFileProvider,
     * and other process get app by reflect.</p>
     *
     * @return the Application object
     */
    public static Application getApp() {
        return sApp;
    }

    @PluginMethod
    public void zip(PluginCall call) {
        String zipFilePath = call.getString("zipFilePath");
        if (TextUtils.isEmpty(zipFilePath)) {
            call.reject("zipFilePath is required");
            return;
        }
        JSArray srcFilePaths = call.getArray("srcFilePaths");
        if (srcFilePaths == null || srcFilePaths.length() <= 0) {
            call.reject("srcFilePaths is required");
            return;
        }

        try {
            ZipUtils.zipFiles(srcFilePaths.toList(), zipFilePath);
            call.resolve();
        } catch (Exception e) {
            call.reject("unable to zip");
        }
    }

    @PluginMethod
    public void unzip(PluginCall call) {
        String zipFilePath = call.getString("zipFilePath");
        String destDirPath = call.getString("destDirPath");

        if (TextUtils.isEmpty(zipFilePath)) {
            call.reject("zipFilePath is required");
            return;
        }

        if (TextUtils.isEmpty("destDirPath")) {
            call.reject("destDirPath is required");
            return;
        }

        try {
            ZipUtils.unzipFile(zipFilePath, destDirPath);
            call.resolve();
        } catch (Exception e) {
            call.reject("unable to unzip");
        }
    }
}
