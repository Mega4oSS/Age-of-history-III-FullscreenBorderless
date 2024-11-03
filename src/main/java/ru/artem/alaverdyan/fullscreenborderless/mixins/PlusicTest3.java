package ru.artem.alaverdyan.fullscreenborderless.mixins;

import ru.artem.alaverdyan.Mixin;
import ru.artem.alaverdyan.fullscreenborderless.elements.PTCFG;
import ru.artem.alaverdyan.injections.At;
import ru.artem.alaverdyan.injections.Inject;

@Mixin(value = "aoc.kingdoms.lukasz.jakowski.setting.SettingsDesktop")
public class PlusicTest3 {

    @Inject(method = "readConfig", at = @At(value = "AFTER"))
    public static void reReadConfig() {
        PTCFG.readConfig();
    }

    @Inject(method = "saveConfig", at = @At(value = "AFTER"))
    public static void reSaveConfig() {
        PTCFG.saveConfig();
    }
}
