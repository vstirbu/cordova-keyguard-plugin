# KeyGuardPlugin

Cordova keyguard plugin

# Installation

If using `cordova-cli` 5.0 or newer:

```bash
cordova plugin add cordova-keyguard-plugin
```

for older versions:

```bash
cordova plugin add https://github.com/vstirbu/cordova-keyguard-plugin.git
```

# JavaScript API

The plugin exposes the keyguard state for the application as `navigator.keyguard` object.

## Reading the keyguard state

```javascript
navigator.keyguard;
```

## Changing the keyguard state

To activate the keyguard use the following:

```javascript
navigator.keyguard = true;
```

To deactivate the keyguard use the following:

```javascript
navigator.keyguard = false;
```

## `keyguard` event

The plugin emits `keyguard` events whenever the state change has completed. You can reister for this events:

```javascript
document.addEventListener('keyguard', function (state) {
  // state can be true or false;
});
```

## Suported platforms

* Android

## License

The plugin is available under MIT license.