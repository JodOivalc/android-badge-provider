package com.eskimi.abadgeutil;

import android.content.Context;

/**
 * Failback class
 */
public class SilentBadger extends ABadgerProvider {
    protected SilentBadger(Context context) {
        super(context);
    }

    @Override
    boolean setBadge(int count) {
        return false;
    }

    @Override
    boolean removeBadge() {
        return false;
    }
}
