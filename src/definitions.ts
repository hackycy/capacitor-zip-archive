export interface ZipFileOptions {
  src: string;
  zip: string;
}

export interface UnzipOptions {
  src: string;
  dest: string;
}

export interface ZipArchivePlugin {
  zipFile(options: ZipFileOptions): Promise<void>;

  unzip(options: UnzipOptions): Promise<void>;
}
