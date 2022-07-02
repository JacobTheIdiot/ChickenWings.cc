package me.alpha432.oyvey.util;


import me.alpha432.oyvey.mixin.mixins.MixinInterface;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;


public class MessageUtil implements MixinInterface {

    public static void sendClientMessage(String message) {
        mc.ingameGUI.getChatGUI().printChatMessageWithOptionalDeletion(new TextComponentString(TextFormatting.DARK_PURPLE + "[ChickenWings.cc] " + TextFormatting.RESET + message), 69);
    }

    public static void sendRawClientMessage(String message) {
        mc.ingameGUI.getChatGUI().printChatMessageWithOptionalDeletion(new TextComponentString(message), 69);
    }

    public static void sendPublicMessage(String message) {
        mc.player.sendChatMessage(message);
    }

    public static void addOutput(String message) {

    }

    public static void usageException(String usage, String specialUsage) {

    }

    public static String toUnicode(String s) {
        return s.toLowerCase()
                .replace("a", "\u1d00")
                .replace("b", "\u0299")
                .replace("c", "\u1d04")
                .replace("d", "\u1d05")
                .replace("e", "\u1d07")
                .replace("f", "\ua730")
                .replace("g", "\u0262")
                .replace("h", "\u029c")
                .replace("i", "\u026a")
                .replace("j", "\u1d0a")
                .replace("k", "\u1d0b")
                .replace("l", "\u029f")
                .replace("m", "\u1d0d")
                .replace("n", "\u0274")
                .replace("o", "\u1d0f")
                .replace("p", "\u1d18")
                .replace("q", "\u01eb")
                .replace("r", "\u0280")
                .replace("s", "\ua731")
                .replace("t", "\u1d1b")
                .replace("u", "\u1d1c")
                .replace("v", "\u1d20")
                .replace("w", "\u1d21")
                .replace("x", "\u02e3")
                .replace("y", "\u028f")
                .replace("z", "\u1d22");
    }
}