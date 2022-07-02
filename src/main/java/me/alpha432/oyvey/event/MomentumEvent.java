package me.alpha432.oyvey.event;

import net.minecraftforge.fml.common.eventhandler.Cancelable;
import net.minecraftforge.fml.common.eventhandler.Event;



@Cancelable
public class MomentumEvent extends Event {

    Stage stage;

    public MomentumEvent() {

    }

    public MomentumEvent(Stage stage) {
        this.stage = stage;
    }

    public Stage getStage() {
        return this.stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
        this.setCanceled(false);
    }

    public enum Stage {
        PRE,
        POST
    }

}