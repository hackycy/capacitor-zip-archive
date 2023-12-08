export interface ZipArchivePlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
