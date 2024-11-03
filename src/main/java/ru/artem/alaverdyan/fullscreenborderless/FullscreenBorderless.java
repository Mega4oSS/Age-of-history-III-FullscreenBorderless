package ru.artem.alaverdyan.fullscreenborderless;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import ru.artem.alaverdyan.PlusicAPI;
import ru.artem.alaverdyan.PlusicMod;
import ru.artem.alaverdyan.fullscreenborderless.elements.PTCFG;
import ru.artem.alaverdyan.fullscreenborderless.elements.PlusicElementTest;
import ru.artem.alaverdyan.fullscreenborderless.mixins.*;

public class FullscreenBorderless extends PlusicMod {
    public void preInit() {
        PlusicAPI.registerClass(PlusicElementTest.class, this);
        PlusicAPI.registerClass(PTCFG.class,this);
        PlusicAPI.registerMixin(PlusicTest.class);
        PlusicAPI.registerMixin(PlusicTest2.class);
        PlusicAPI.registerMixin(PlusicTest3.class);
        PlusicAPI.registerMixin(PlusicTest4.class);
    }

    public void create() {
    }

    public void render(SpriteBatch batch) {

    }

    public void dispose() {
    }
}
