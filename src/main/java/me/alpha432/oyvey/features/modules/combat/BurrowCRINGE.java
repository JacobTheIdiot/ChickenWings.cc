package me.alpha432.oyvey.features.modules.combat;

import me.alpha432.oyvey.features.modules.Module;
import me.alpha432.oyvey.features.setting.Setting;
import me.alpha432.oyvey.util.BlockUtil;
import net.minecraft.init.Blocks;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;

public class BurrowCRINGE
        extends Module {
    private final Setting<Boolean> packet = this.register(new Setting<Boolean>("PacketPlace", Boolean.FALSE));

    public BurrowCRINGE() {
        super("Burrow (no work)", "SelfFills yourself in a hole.", Module.Category.COMBAT, true, false, true);
    }

    @Override
    public void onEnable() {
        BurrowCRINGE.mc.player.jump();
        BurrowCRINGE.mc.player.jump();
    }

    @Override
    public void onUpdate() {
        BlockPos pos = new BlockPos(BurrowCRINGE.mc.player.posX, BurrowCRINGE.mc.player.posY, BurrowCRINGE.mc.player.posZ);
        if (BurrowCRINGE.mc.world.getBlockState(pos.down()).getBlock() == Blocks.AIR && BlockUtil.isPositionPlaceable(pos.down(), false) == 3) {
            BlockUtil.placeBlock(pos.down(), EnumHand.MAIN_HAND, false, this.packet.getValue(), false);
        }
        if (BurrowCRINGE.mc.world.getBlockState(pos.down()).getBlock() == Blocks.OBSIDIAN) {
            BurrowCRINGE.mc.player.connection.sendPacket(new CPacketPlayer.Position(BurrowCRINGE.mc.player.posX, BurrowCRINGE.mc.player.posY - 1.3, BurrowCRINGE.mc.player.posZ, false));
            BurrowCRINGE.mc.player.setPosition(BurrowCRINGE.mc.player.posX, BurrowCRINGE.mc.player.posY - 1.3, BurrowCRINGE.mc.player.posZ);
            this.toggle();
        }
    }
}

