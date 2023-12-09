export interface ZipFileOptions {
  /**
   * The paths of source files
   */
  srcFilePaths: string[];

  /**
   * The path of ZIP file
   */
  zipFilePath: string;
}

export interface UnzipOptions {
  /**
   * The path of ZIP file
   */
  zipFilePath: string;

  /**
   * The path of destination directory
   */
  destDirPath: string;
}

export interface ZipArchivePlugin {
  zip(options: ZipFileOptions): Promise<void>;

  unzip(options: UnzipOptions): Promise<void>;
}
