package me.alpha432.oyvey.event.events;

import me.alpha432.oyvey.event.EventStage;

public class ChorusEvent
        extends EventStage {
    private final double chorusX;
    private final double chorusY;
    private final double chorusZ;

    public ChorusEvent(double x, double y, double z) {
        this.chorusX = x;
        this.chorusY = y;
        this.chorusZ = z;
    }

    public double getChorusX() {
        return this.chorusX;
    }

    public double getChorusY() {
        return this.chorusY;
    }

    public double getChorusZ() {
        return this.chorusZ;
    }
}