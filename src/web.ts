import { WebPlugin } from '@capacitor/core';

import type { ZipArchivePlugin } from './definitions';

export class ZipArchiveWeb extends WebPlugin implements ZipArchivePlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
