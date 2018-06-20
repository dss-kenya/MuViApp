package com.android.dhara.muviapp.home.event;

public class ToggleUpdateEvent {
    private boolean isDrawerToggleIndicatorEnabled;

    public static ToggleUpdateEvent create(final boolean isDrawerToggleIndicatorEnabled) {
        final ToggleUpdateEvent event = new ToggleUpdateEvent();
        event.setDrawerToggleIndicatorEnabled(isDrawerToggleIndicatorEnabled);
        return event;
    }

    public boolean isDrawerToggleIndicatorEnabled() {
        return isDrawerToggleIndicatorEnabled;
    }

    private void setDrawerToggleIndicatorEnabled(final boolean drawerToggleIndicatorEnabled) {
        isDrawerToggleIndicatorEnabled = drawerToggleIndicatorEnabled;
    }
}
