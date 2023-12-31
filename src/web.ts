import { WebPlugin } from '@capacitor/core';

import type { ZipArchivePlugin } from './definitions';

export class ZipArchiveWeb extends WebPlugin implements ZipArchivePlugin {
  zip(): Promise<void> {
    throw new Error('Method not implemented.');
  }
  unzip(): Promise<void> {
    throw new Error('Method not implemented.');
  }
}
