package me.alpha432.oyvey.event.events;

import me.alpha432.oyvey.event.EventStage;

/**
 * @author fuckyouthinkimboogieman
 */

public class EventKey extends EventStage {
    public boolean info;
    public boolean pressed;
    private final int key;

    public EventKey(int key) {
        this.key = key;
    }

    public int getKey() { return key; }

    public void setInfo(boolean info) {
        this.info = info;
    }

    public void setPressed(boolean pressed) {
        this.pressed = pressed;
    }

    public boolean isPressed() {
        return pressed;
    }

    public boolean isInfo() {
        return info;
    }
}