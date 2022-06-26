# StarSDK
The star sdk is written in kotlin to make the prominent stars in the sky more prominent. :)

## Features
- You can specify what kind of star you want (Small or large).
- If you want more than 10 stars, the sky does not allow it. An alarm feedback is returned to you.
- Star information is displayed whenever a star is requested. (logging)

## Usage
**Add Star:**
```kotlin
StarSdk.addStarInterface(StarSizeType.B) { alertCallback ->
    // Alert callback size 10 than big -> true ?: false
}
