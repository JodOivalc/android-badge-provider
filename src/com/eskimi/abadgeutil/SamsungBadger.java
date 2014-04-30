package com.eskimi.abadgeutil;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

public class SamsungBadger extends ABadgerProvider {
    private static final Uri CONTENT_URI = Uri.parse("content://com.sec.badge/apps");
    private static final String COLUMN_PACKAGE = "package";
    private static final String COLUMN_CLASS = "class";
    private static final String COLUMN_BADGECOUNT = "badgecount";

    protected SamsungBadger(Context context) {
        super(context);
    }

    @Override
    boolean setBadge(int count) {
        ContentValues cv = getContentValues();
        cv.put(COLUMN_BADGECOUNT, count);

        if (hasBadge())
            context.getContentResolver().update(CONTENT_URI, cv, "package=?", new String[] { getPackageName() });
        else
            context.getContentResolver().insert(CONTENT_URI, cv);

        return true;
    }

    @Override
    boolean removeBadge() {
        if (!hasBadge())
            return true;

        context.getContentResolver().delete(CONTENT_URI, "package=?", new String[] { getPackageName() });

        return true;
    }

    private ContentValues getContentValues() {
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_PACKAGE, getPackageName());
        cv.put(COLUMN_CLASS, getLauncherClass());

        return cv;
    }

    private boolean hasBadge() {
        Cursor cursor = context.getContentResolver().query(CONTENT_URI, null, "package=?", new String[] { getPackageName() }, null);

        return cursor != null && cursor.getCount() > 0;
    }

    static boolean isAvailable(Context context) {
        return context.getContentResolver().query(CONTENT_URI, null, null, null, null) != null;
    }
}
