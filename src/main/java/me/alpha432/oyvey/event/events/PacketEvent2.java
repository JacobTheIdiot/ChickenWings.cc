package me.alpha432.oyvey.event.events;

import me.alpha432.oyvey.event.MomentumEvent;
import net.minecraft.network.Packet;
import net.minecraftforge.fml.common.eventhandler.Cancelable;


@Cancelable
public class PacketEvent2 extends MomentumEvent {

    Packet<?> packet;

    public PacketEvent2(Packet<?> packet, Stage stage) {
        super(stage);
        this.packet = packet;
    }

    public Packet<?> getPacket(){
        return this.packet;
    }

}