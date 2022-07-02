package me.alpha432.oyvey.features.modules.misc;

import java.util.Arrays;

import me.alpha432.oyvey.features.modules.Module;
import org.lwjgl.input.Keyboard;


import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Suffix extends Module {

    public Suffix() {
        super ("chatSuffix", "adds postman suffix to all of ur chat msg's.", Category.MISC, true, false, false);

    }

    @SubscribeEvent
    public void onChat(final ClientChatEvent event) {
        for (final String s : Arrays.asList("/", ".", "-", ",", ":", ";", "'", "\"", "+", "\\", "@", "#")) {
            if (event.getMessage().startsWith(s)) return;
        }
        event.setMessage(event.getMessage() + "| ꜀ₕᵢ꜀ₖₑₙwᵢₙ₉ₛ.꜀꜀");
    }

    @Override
    public void onEnable() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public void onDisable() {
        MinecraftForge.EVENT_BUS.unregister(this);
    }
}