
        package me.alpha432.oyvey.features.modules.movement;

        import me.alpha432.oyvey.features.modules.Module;
        import net.minecraft.client.settings.KeyBinding;
        import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
        import net.minecraftforge.fml.common.gameevent.TickEvent;

        public class Sprint extends Module {

        public Sprint() {super("Sprint", "Makes you auto sprint.", Category.MOVEMENT, true, false, false);
        }

        @SubscribeEvent
        public void onPlayerTick(TickEvent.PlayerTickEvent e) {
        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), true);
        }

        @Override
        public void onDisable() {
        super.onDisable();
        KeyBinding.setKeyBindState(mc.gameSettings.keyBindSprint.getKeyCode(), false);
        }
        }
