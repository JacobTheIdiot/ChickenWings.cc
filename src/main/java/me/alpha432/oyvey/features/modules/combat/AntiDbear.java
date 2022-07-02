//
// Decompiled by Procyon v0.5.36
//

package me.alpha432.oyvey.features.modules.combat;

import me.alpha432.oyvey.features.modules.Module;
import me.alpha432.oyvey.features.setting.Setting;
import me.alpha432.oyvey.util.*;
import net.minecraft.block.BlockEnderChest;
import net.minecraft.block.BlockObsidian;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AntiDbear extends Module {
    private static final BlockPos[] surroundOffset;
    private static AntiDbear INSTANCE;

    static {
        AntiDbear.INSTANCE = new AntiDbear();
        surroundOffset = BlockUtil.toBlockPos(EntityUtil.getOffsets(0, true));
    }

    private final Setting<Integer> range;
    private final Setting<Integer> delay;
    private final Setting<Integer> blocksPerTick;
    private final Timer offTimer;
    private final Timer timer;
    private final Map<BlockPos, Integer> retries;
    private final Timer retryTimer;
    private int blocksThisTick;
    private ArrayList<BlockPos> holes;
    private int trie;

    public AntiDbear() {
        super("AntiAntiSurround", "Fills holes around you (so dbear cant get in them).", Category.COMBAT, true, false, true);
        this.range = (Setting<Integer>) this.register(new Setting("PlaceRange", 8, 0, 10));
        this.delay = (Setting<Integer>) this.register(new Setting("Delay", 50, 0, 250));
        this.blocksPerTick = (Setting<Integer>) this.register(new Setting("BlocksPerTick", 20, 8, 30));
        this.offTimer = new Timer();
        this.timer = new Timer();
        this.blocksThisTick = 0;
        this.retries = new HashMap<BlockPos, Integer>();
        this.retryTimer = new Timer();
        this.holes = new ArrayList<BlockPos>();
        this.setInstance();
    }

    public static AntiDbear getInstance() {
        if (AntiDbear.INSTANCE == null) {
            AntiDbear.INSTANCE = new AntiDbear();
        }
        return AntiDbear.INSTANCE;
    }

    private void setInstance() {
        AntiDbear.INSTANCE = this;
    }

    @Override
    public void onEnable() {
        if (fullNullCheck()) {
            this.disable();
        }
        this.offTimer.reset();
        this.trie = 0;
    }

    @Override
    public void onTick() {
        if (this.isOn()) {
            this.doHoleFill();
        }
    }

    @Override
    public void onDisable() {
        this.retries.clear();
    }

    private void doHoleFill() {
        if (this.check()) {
            return;
        }
        this.holes = new ArrayList<BlockPos>();
        final Iterable<BlockPos> blocks = BlockPos.getAllInBox(AntiDbear.mc.player.getPosition().add(-this.range.getValue(), -this.range.getValue(), -this.range.getValue()), AntiDbear.mc.player.getPosition().add(this.range.getValue(), this.range.getValue(), this.range.getValue()));
        for (final BlockPos pos : blocks) {
            if (!AntiDbear.mc.world.getBlockState(pos).getMaterial().blocksMovement() && !AntiDbear.mc.world.getBlockState(pos.add(0, 1, 0)).getMaterial().blocksMovement()) {
                final boolean solidNeighbours = (AntiDbear.mc.world.getBlockState(pos.add(1, 0, 0)).getBlock() == Blocks.BEDROCK | AntiDbear.mc.world.getBlockState(pos.add(1, 0, 0)).getBlock() == Blocks.OBSIDIAN) && (AntiDbear.mc.world.getBlockState(pos.add(0, 0, 1)).getBlock() == Blocks.BEDROCK | AntiDbear.mc.world.getBlockState(pos.add(0, 0, 1)).getBlock() == Blocks.OBSIDIAN) && (AntiDbear.mc.world.getBlockState(pos.add(-1, 0, 0)).getBlock() == Blocks.BEDROCK | AntiDbear.mc.world.getBlockState(pos.add(-1, 0, 0)).getBlock() == Blocks.OBSIDIAN) && (AntiDbear.mc.world.getBlockState(pos.add(0, 0, -1)).getBlock() == Blocks.BEDROCK | AntiDbear.mc.world.getBlockState(pos.add(0, 0, -1)).getBlock() == Blocks.OBSIDIAN) && AntiDbear.mc.world.getBlockState(pos.add(0, 0, 0)).getMaterial() == Material.AIR && AntiDbear.mc.world.getBlockState(pos.add(0, 1, 0)).getMaterial() == Material.AIR && AntiDbear.mc.world.getBlockState(pos.add(0, 2, 0)).getMaterial() == Material.AIR;
                if (!solidNeighbours) {
                    continue;
                }
                this.holes.add(pos);
            }
        }
        this.holes.forEach(this::placeBlock);
        this.toggle();
    }

    private void placeBlock(final BlockPos pos) {
        for (final Entity entity : AntiDbear.mc.world.getEntitiesWithinAABBExcludingEntity(null, new AxisAlignedBB(pos))) {
            if (entity instanceof EntityLivingBase) {
                return;
            }
        }
        if (this.blocksThisTick < this.blocksPerTick.getValue()) {
            final int obbySlot = InventoryUtil.findHotbarBlock(BlockObsidian.class);
            final int eChestSot = InventoryUtil.findHotbarBlock(BlockEnderChest.class);
            if (obbySlot == -1 && eChestSot == -1) {
                this.toggle();
            }
            final int originalSlot = AntiDbear.mc.player.inventory.currentItem;
            AntiDbear.mc.player.inventory.currentItem = ((obbySlot == -1) ? eChestSot : obbySlot);
            AntiDbear.mc.playerController.updateController();
            TestUtil.placeBlock(pos);
            if (AntiDbear.mc.player.inventory.currentItem != originalSlot) {
                AntiDbear.mc.player.inventory.currentItem = originalSlot;
                AntiDbear.mc.playerController.updateController();
            }
            this.timer.reset();
            ++this.blocksThisTick;
        }
    }

    private boolean check() {
        if (fullNullCheck()) {
            this.disable();
            return true;
        }
        this.blocksThisTick = 0;
        if (this.retryTimer.passedMs(2000L)) {
            this.retries.clear();
            this.retryTimer.reset();
        }
        return !this.timer.passedMs(this.delay.getValue());
    }
}
