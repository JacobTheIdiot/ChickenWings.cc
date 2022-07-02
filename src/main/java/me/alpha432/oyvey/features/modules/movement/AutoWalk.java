package me.alpha432.oyvey.features.modules.movement;

import me.alpha432.oyvey.features.modules.Module;
import net.minecraft.client.settings.KeyBinding;


public class AutoWalk
        extends Module {
    public AutoWalk() {
        super("AutoWalk", "Makes you auto walk :O.", Category.MOVEMENT, true, false, false);
    }

    public void onUpdate() {
        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
    }

    public void onDisable() {
        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), false);
    }
}
