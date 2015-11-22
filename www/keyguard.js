var exec = require('cordova/exec');

var _enabled = false;

Object.defineProperty(navigator, 'keyguard', {
  enumerable: true,
  get: function () {
    return _enabled;
  },
  set: function (enabled) {
    exec(function () {
      _enabled = enabled;
    }, function () {}, 'KeyGuard', 'set', [enabled]);
  }
});

document.addEventListener('deviceready', function() {
  exec(function (enabled) {
    _enabled = enabled;
  }, function (err) {}, 'KeyGuard', 'enabled', []);
});

module.exports = navigator;
