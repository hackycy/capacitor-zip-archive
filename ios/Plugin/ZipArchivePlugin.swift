import Foundation
import Capacitor
import SSZipArchive

/**
 * Please read the Capacitor iOS Plugin Development Guide
 * here: https://capacitorjs.com/docs/plugins/ios
 */
@objc(ZipArchivePlugin)
public class ZipArchivePlugin: CAPPlugin {

    @objc func zip(_ call: CAPPluginCall) {
        guard let srcFilePaths = call.getArray("srcFilePaths") as? [String], srcFilePaths.count > 0 else {
            call.reject("srcFilePaths is required")
            return
        }

        guard let zipFilePath = call.getString("zipFilePath") else {
            call.reject("zipFilePath is required")
            return
        }

        if SSZipArchive.createZipFile(atPath: zipFilePath, withFilesAtPaths: srcFilePaths) {
            call.resolve()
        } else {
            call.reject("unable to zip")
        }
    }

    @objc func unzip(_ call: CAPPluginCall) {
        guard let zipFilePath = call.getString("zipFilePath") else {
            call.reject("zipFilePath is required")
            return
        }

        guard let destDirPath = call.getString("destDirPath") else {
            call.reject("destDirPath is required")
            return
        }

        if SSZipArchive.unzipFile(atPath: zipFilePath, toDestination: destDirPath) {
            call.resolve()
        } else {
            call.reject("unable to unzip")
        }
    }
}
