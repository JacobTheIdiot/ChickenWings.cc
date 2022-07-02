package me.alpha432.oyvey.features.modules.render;

import me.alpha432.oyvey.features.modules.Module;
import me.alpha432.oyvey.features.setting.Setting;

public class WorseViewmodel
        extends Module {
    private static WorseViewmodel INSTANCE = new WorseViewmodel();
    public Setting<Float> offX = this.register(new Setting<Float>("OffHandX", Float.valueOf(0.0f), Float.valueOf(-1.0f), Float.valueOf(1.0f)));
    public Setting<Float> offY = this.register(new Setting<Float>("OffHandY", Float.valueOf(0.0f), Float.valueOf(-1.0f), Float.valueOf(1.0f)));
    public Setting<Float> mainX = this.register(new Setting<Float>("MainHandX", Float.valueOf(0.0f), Float.valueOf(-1.0f), Float.valueOf(1.0f)));
    public Setting<Float> mainY = this.register(new Setting<Float>("MainHandY", Float.valueOf(0.0f), Float.valueOf(-1.0f), Float.valueOf(1.0f)));

    public WorseViewmodel() {
        super("WorseViewmodel", "Makes you offhand lower.", Module.Category.RENDER, false, false, false);
        this.setInstance();
    }

    public static WorseViewmodel getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new WorseViewmodel();
        }
        return INSTANCE;
    }

    private void setInstance() {
        INSTANCE = this;
    }
}

