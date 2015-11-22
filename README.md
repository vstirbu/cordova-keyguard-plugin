# KeyGuardPlugin

Cordova keyguard plugin

# Installation

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
