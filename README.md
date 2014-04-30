ABadgeUtil
=============

Simple class that abstracts interfacing with various launcher's badge providers including Samsung, Sony xperia and Android Apex launchers

**This code is in ALPHA version, do not recommend using for production**

Setup
=============

Add the following permissions to your application's AndroidManifest.xml:

    <uses-permission android:name="com.sec.android.provider.badge.permission.READ" />
    <uses-permission android:name="com.sec.android.provider.badge.permission.WRITE" />
    <uses-permission android:name="com.anddoes.launcher.permission.UPDATE_COUNT" />
    <uses-permission android:name="com.sonyericsson.home.permission.BROADCAST_BADGE" />

Usage
============

    ABadgeUtil.setBadge(context, 5); //show

    ABadgeUtil.removeBadge(context); //remove badge

**This code doesn't guarantee to show badge. Badges is not official supported**

Credit
===========

**Daniel Ochoa**: http://stackoverflow.com/a/20136484/312161 <br/>
**Marcus Forsberg**: http://marcusforsberg.net/blog/android-notification-badge-app-icon-sony/ <br/>
**dennisxl**: http://forum.xda-developers.com/showthread.php?t=1930365

