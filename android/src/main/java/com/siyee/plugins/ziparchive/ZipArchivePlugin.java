package com.siyee.plugins.ziparchive;

import android.annotation.SuppressLint;
import android.app.Application;

import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

import java.io.IOException;

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
    public void zipFile(PluginCall call) {
        String src = call.getString("src");
        String zip = call.getString("zip");

        try {
            ZipUtils.zipFile(src, zip);
            call.resolve();
        } catch (IOException e) {
            call.reject(e.getMessage());
        }
    }

    @PluginMethod
    public void unzip(PluginCall call) {
        String src = call.getString("src");
        String dest = call.getString("dest");

        try {
            ZipUtils.unzipFile(src, dest);
            call.resolve();
        } catch (IOException e) {
            call.reject(e.getMessage());
        }
    }
}
