'use strict';

const Generator = require('yeoman-generator');
const mkdirp = require('mkdirp');
const yosay = require('yosay');
const chalk = require('chalk');

module.exports = Generator.extend({
  initializing: function () {
    this.props = {};
  },
  prompting: function () {
    this.log(yosay(
      'Welcome to ' + chalk.red('MVVM Kotlin Starter') + ' generator!'
    ));

    const prompts = [
      {
        name: 'name',
        message: 'What are you calling your app?',
        store: true,
        default: this.appname // Default to current folder name
      },
      {
        name: 'package',
        message: 'What package will you be publishing the app under?',
        store: true,
        default: 'com.mycompany.app'
      },
      {
        name: 'targetSdk',
        message: 'What Android SDK will you be targeting?',
        store: true,
        default: 26 // Android 8.0 (O(7.1+))
      },
      {
        name: 'minSdk',
        message: 'What is the minimum Android SDK you wish to support?',
        store: true,
        default: 14 // Android 4.0 (Ice Cream Sandwich)
      }];

    return this.prompt(prompts).then(props => {
      this.props.appPackage = props.package;
      this.props.appName = props.name;
      this.props.appPackage = props.package;
      this.props.androidTargetSdkVersion = props.targetSdk;
      this.props.androidMinSdkVersion = props.minSdk;
    });
  },

  writing: function () {
    var packageDir = this.props.appPackage.replace(/\./g, '/');
    var appFolder = 'template-mvvm-kotlin';

    mkdirp('app');
    mkdirp('app/src/main/java/' + packageDir);
    mkdirp('app/src/main/core/kotlin/' + packageDir);
    mkdirp('app/src/main/core/res/layout');
    mkdirp('app/src/main/core/res/values');
    mkdirp('app/src/androidTest/java/' + packageDir);
    mkdirp('app/src/test/java/' + packageDir);
    var appPath = this.sourceRoot() + '/' + appFolder + '/';
    this.fs.copy(appPath + 'README.md', 'README.md');
    this.fs.copy(appPath + 'build.gradle', 'build.gradle');
    this.fs.copy(appPath + 'gradle.properties', 'gradle.properties');
    this.fs.copy(appPath + 'gradlew', 'gradlew');
    this.fs.copy(appPath + 'gradlew.bat', 'gradlew.bat');
    this.fs.copy(appPath + 'settings.gradle', 'settings.gradle');
    this.fs.copy(appPath + 'app/proguard-rules.pro', 'app/proguard-rules.pro');

    this.fs.copy(appPath + 'gradle', 'gradle');
    this.fs.copy(appPath + 'app/src/main/res', 'app/src/main/res');
    this.fs.copy(appPath + 'app/src/main/core/res', 'app/src/main/core/res');

    this.fs.copyTpl(appPath + 'app/build.gradle', 'app/build.gradle', this.props);
    this.fs.copyTpl(appPath + 'app/src/main/AndroidManifest.xml', 'app/src/main/AndroidManifest.xml', this.props);
    this.fs.copyTpl(appPath + 'app/src/androidTest/java/io/ditclear/app', 'app/src/androidTest/java/' + packageDir, this.props);
    this.fs.copyTpl(appPath + 'app/src/test/java/io/ditclear/app', 'app/src/test/java/' + packageDir, this.props);
    this.fs.copyTpl(appPath + 'app/src/main/java/io/ditclear/app', 'app/src/main/java/' + packageDir, this.props);
    this.fs.copyTpl(appPath + 'app/src/main/core/kotlin/io/ditclear/app', 'app/src/main/core/kotlin/' + packageDir, this.props);

    this.fs.copyTpl(appPath + 'app/src/main/res/layout', 'app/src/main/res/layout', this.props);
    this.fs.copyTpl(appPath + 'app/src/main/core/res/layout', 'app/src/main/core/res/layout', this.props);
    this.fs.copyTpl(appPath + 'app/src/main/res/values/strings.xml', 'app/src/main/res/values/strings.xml', this.props);
    this.fs.copyTpl(appPath + 'app/src/main/core/res/layout', 'app/src/main/core/res/layout', this.props);
  }
});
