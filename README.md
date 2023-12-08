# capacitor-zip-archive

Zip archive utility for capacitor

## Install

```bash
npm install capacitor-zip-archive
npx cap sync
```

## API

<docgen-index>

* [`zipFile(...)`](#zipfile)
* [`unzip(...)`](#unzip)
* [Interfaces](#interfaces)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### zipFile(...)

```typescript
zipFile(options: ZipFileOptions) => Promise<void>
```

| Param         | Type                                                      |
| ------------- | --------------------------------------------------------- |
| **`options`** | <code><a href="#zipfileoptions">ZipFileOptions</a></code> |

--------------------


### unzip(...)

```typescript
unzip(options: UnzipOptions) => Promise<void>
```

| Param         | Type                                                  |
| ------------- | ----------------------------------------------------- |
| **`options`** | <code><a href="#unzipoptions">UnzipOptions</a></code> |

--------------------


### Interfaces


#### ZipFileOptions

| Prop      | Type                |
| --------- | ------------------- |
| **`src`** | <code>string</code> |
| **`zip`** | <code>string</code> |


#### UnzipOptions

| Prop       | Type                |
| ---------- | ------------------- |
| **`src`**  | <code>string</code> |
| **`dest`** | <code>string</code> |

</docgen-api>
