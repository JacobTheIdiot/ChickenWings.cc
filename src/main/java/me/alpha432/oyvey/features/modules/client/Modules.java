package me.alpha432.oyvey.features.modules.client;

import me.alpha432.oyvey.features.command.Command;
import me.alpha432.oyvey.features.modules.Module;

public class Modules
        extends Module {
    public Modules() {
        super("Modules", "Sends in chat all modules!", Category.CLIENT, true, false, false);

    }
    public void onEnable() {
        Command.sendMessage("AntiFacePlace, AutoArmor, AutoMinecart, AutoTrap, AutoWeb, Burrow (no work), Criticals, HoleFiler, KillAura, offHand, OffhandRewrite, OyVey ca, Surround, AutoNice, BuildHeight, ChatSuffix, Duel, ExtraTab, HitBoxIgnore, MCF, NoHandShake, PearlNotify, PopCounter, ShulkerViewer, AurrowESP, BlockHighlight, ESP, HandChams, HoleESP, Skeleton, Trajectories, WireFrame, WorseViewmodel, AutoWalk, AutoWalk2, FloatThing, NoVoid, ReverseStep, Scaffold, Speed, Sprint, FakePlayer, FastPLace, LiquidInteract, MiddleClickLOSE, MultiTask, Replenish, SpeedMine, TpsSync, ClickGui, CustomFont, HUD, Modules, Notifications.");
        Command.sendMessage("My arm hurts from typing all of that");

    }

}

