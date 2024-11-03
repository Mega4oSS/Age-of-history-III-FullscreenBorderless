package ru.artem.alaverdyan.fullscreenborderless.mixins;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import javassist.*;
import ru.artem.alaverdyan.Mixin;
import ru.artem.alaverdyan.fullscreenborderless.elements.PTCFG;
import ru.artem.alaverdyan.injections.At;
import ru.artem.alaverdyan.injections.DirectInject;
import ru.artem.alaverdyan.injections.Inject;

@Mixin(value = "aoc.kingdoms.lukasz.jakowski.desktop.DesktopLauncher")
public class PlusicTest2 {
    @DirectInject
    public static void directInject(CtClass cc) {
        String code2 = "if(tempR[0].equals(\"SCREENMODE\")) {ru.artem.alaverdyan.fullscreenborderless.elements.PTCFG.screenMode = Integer.parseInt(tempR[1]);System.out.println(\"SCREENMODE: \" + ru.artem.alaverdyan.fullscreenborderless.elements.PTCFG.screenMode);}";
        String code4 = "fr = new java.io.FileReader(\"mods/FullscreenBorderless/settings/Config.txt\");";
        try {
            CtMethod method = cc.getDeclaredMethod("main");
            method.insertAt(54, code4);
            method.insertAt(60, code2);
        } catch (NotFoundException | CannotCompileException e) {
            throw new RuntimeException(e);
        }
    }

    @Inject(method = "main", at = @At(value = "BY", by = 104))
    public static void injected(Lwjgl3ApplicationConfiguration config) {
        if (PTCFG.screenMode == 1) {
            config.setFullscreenMode(Lwjgl3ApplicationConfiguration.getDisplayMode());
        }
        if (PTCFG.screenMode == 2) {
            config.setDecorated(false); //Немного кода и вот работает, ну что за позор, Лукаш, целую игру захерачил, а легкую опцию не смог :(
            config.setWindowedMode(Lwjgl3ApplicationConfiguration.getDisplayMode().width, Lwjgl3ApplicationConfiguration.getDisplayMode().height);
        }
    }
}
