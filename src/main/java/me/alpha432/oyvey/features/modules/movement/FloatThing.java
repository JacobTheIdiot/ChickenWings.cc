package me.alpha432.oyvey.features.modules.movement;

import me.alpha432.oyvey.features.modules.Module;
import me.alpha432.oyvey.features.setting.Setting;
import me.alpha432.oyvey.util.MotionUtil;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class FloatThing
        extends Module {
    public FloatThing() {
        super("Float thing", "Somehow made this when trying to make a sprint lol", Module.Category.MOVEMENT, true, false, false);
    }



    public static Setting<Mode> mode = new Setting<>("Mode", Mode.DIRECTIONAL);

    public static Setting<Boolean> safe = new Setting<>("Safe", true);

    public static Setting<Boolean> strict = new Setting<>("Strict", false);

    @Override
    public void onUpdate() {

        // reset sprint state
        mc.player.setSprinting(false);

        // verify if the player's food level allows sprinting
        if (mc.player.getFoodStats().getFoodLevel() <= 6 && safe.getValue()) {
            return;
        }

        // verify whether or not the player can actually sprint
        if ((mc.player.isHandActive() || mc.player.isSneaking()) && strict.getValue()) {
            return;
        }

        // update player sprint state
        if (MotionUtil.isMoving()) {
            switch (mode.getValue()) {
                case DIRECTIONAL:
                    mc.player.setSprinting(true);
                    break;
                case NORMAL:
                    mc.player.setSprinting(!mc.player.collidedHorizontally && mc.gameSettings.keyBindForward.isKeyDown());
                    break;
            }
        }
    }

    @SubscribeEvent
    public void onLivingUpdate(LivingEvent.LivingUpdateEvent event) {
        if (MotionUtil.isMoving() && mode.getValue().equals(Mode.DIRECTIONAL)) {

            // verify if the player's food level allows sprinting
            if (mc.player.getFoodStats().getFoodLevel() <= 6 && safe.getValue()) {
                return;
            }

            // verify whether or not the player can actually sprint
            if ((mc.player.isHandActive() || mc.player.isSneaking()) && strict.getValue()) {
                return;
            }

            // cancel vanilla sprint direction
            event.setCanceled(true);
        }
    }

    public enum Mode {

        /**
         * Allows you to sprint in all directions
         */
        DIRECTIONAL,

        /**
         * Allows sprinting when moving forward
         */
        NORMAL
    }
}


