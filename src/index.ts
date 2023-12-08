import { registerPlugin } from '@capacitor/core';

import type { ZipArchivePlugin } from './definitions';

const ZipArchive = registerPlugin<ZipArchivePlugin>('ZipArchive', {
  web: () => import('./web').then(m => new m.ZipArchiveWeb()),
});

export * from './definitions';
export { ZipArchive };
