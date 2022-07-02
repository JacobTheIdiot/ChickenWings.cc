//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package me.alpha432.oyvey.mixin.mixins;

import java.util.List;
import net.minecraft.client.gui.ChatLine;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiNewChat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin({GuiNewChat.class})
public class MixinGuiNewChat extends Gui {
    public MixinGuiNewChat() {
    }

    @Redirect(
            method = {"drawChat"},
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/GuiNewChat;drawRect(IIIII)V"
            )
    )
    private void drawRectHook(int left, int top, int right, int bottom, int color) {
    }

    @Redirect(
            method = {"setChatLine"},
            at = @At(
                    value = "INVOKE",
                    target = "Ljava/util/List;size()I",
                    ordinal = 0
            )
    )
    public int drawnChatLinesSize(List<ChatLine> list) {
        return 0;
    }

    @Redirect(
            method = {"setChatLine"},
            at = @At(
                    value = "INVOKE",
                    target = "Ljava/util/List;size()I",
                    ordinal = 2
            )
    )
    public int chatLinesSize(List<ChatLine> list) {

        return 0;
    }
}
