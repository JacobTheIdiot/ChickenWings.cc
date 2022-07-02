package me.alpha432.oyvey.event.events;

import me.alpha432.oyvey.event.MomentumEvent;
import net.minecraft.network.Packet;
import net.minecraftforge.fml.common.eventhandler.Cancelable;


@Cancelable
public class PacketSendEvent extends PacketEvent2 {
    public PacketSendEvent(Packet<?> packet, MomentumEvent.Stage stage) {
        super(packet, stage);
    }
}