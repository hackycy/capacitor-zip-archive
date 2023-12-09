package com.siyee.plugins.ziparchive;

import android.annotation.SuppressLint;
import android.app.Application;

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
        try {
            String zipFilePath = call.getString("zipFilePath");
            List<String> srcFilePaths = call.getArray("srcFilePaths").toList();

            ZipUtils.zipFiles(srcFilePaths, zipFilePath);
            call.resolve();
        } catch (Exception e) {
            call.reject(e.getMessage());
        }
    }

    @PluginMethod
    public void unzip(PluginCall call) {
        try {
            String zipFilePath = call.getString("zipFilePath");
            String destDirPath = call.getString("destDirPath");

            ZipUtils.unzipFile(zipFilePath, destDirPath);
            call.resolve();
        } catch (Exception e) {
            call.reject(e.getMessage());
        }
    }
}
