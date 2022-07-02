package me.alpha432.oyvey.features.modules.movement;

import me.alpha432.oyvey.features.modules.Module;
import net.minecraft.client.settings.KeyBinding;


public class AutoWalk2
        extends Module {
    public AutoWalk2() {
        super("AutoWalk2", "Makes you auto walk (other way this time) :O.", Category.MOVEMENT, true, false, false);
    }

    public void onUpdate() {
        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), true);
    }

    public void onDisable() {
        KeyBinding.setKeyBindState(mc.gameSettings.keyBindBack.getKeyCode(), false);
    }
}
