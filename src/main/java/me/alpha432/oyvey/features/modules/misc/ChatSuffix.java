package me.alpha432.oyvey.features.modules.misc;

import me.alpha432.oyvey.features.modules.Module;
import me.alpha432.oyvey.event.events.PacketSendEvent;
import me.alpha432.oyvey.util.MessageUtil;
import net.minecraft.network.play.client.CPacketChatMessage;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;



public class ChatSuffix extends Module {
    public ChatSuffix() {
        super("ChatSuffix", "Makes you say a ChickenWings.cc suffix :O.", Category.MISC, true, false, false);
    }

    public String suffix = "ChickenWings.cc";

    @SubscribeEvent
    public void onPacketSend(PacketSendEvent event) {
        if (event.getPacket() instanceof CPacketChatMessage) {
            if (((CPacketChatMessage) event.getPacket()).getMessage().startsWith("/") || ((CPacketChatMessage) event.getPacket()).getMessage().startsWith("!") || ((CPacketChatMessage) event.getPacket()).getMessage().startsWith("$") || ((CPacketChatMessage) event.getPacket()).getMessage().startsWith("?") || ((CPacketChatMessage) event.getPacket()).getMessage().startsWith(".") || ((CPacketChatMessage) event.getPacket()).getMessage().startsWith(","))
                return;

            ((CPacketChatMessage) event.getPacket()).message = ((CPacketChatMessage) event.getPacket()).getMessage() + " \u23d0 " + MessageUtil.toUnicode(suffix);
        }
    }
}