package ru.artem.alaverdyan.fullscreenborderless.mixins;

import aoc.kingdoms.lukasz.jakowski.Game;
import aoc.kingdoms.lukasz.jakowski.setting.SettingsDesktop;
import aoc.kingdoms.lukasz.textures.Images;
import ru.artem.alaverdyan.Mixin;
import ru.artem.alaverdyan.fullscreenborderless.elements.PTCFG;
import ru.artem.alaverdyan.injections.AfterCall;
import ru.artem.alaverdyan.injections.At;
import ru.artem.alaverdyan.injections.Inject;

@Mixin(value = "aoc.kingdoms.lukasz.menus.Settings.Settings_Menu$2")
public class PlusicTest4 {

    @Inject(method = "actionElement", at = @At(value = "BEFORE"), afterCall = AfterCall.RETURN)
    public static void newActionElement() {
        SettingsDesktop.fullscreen = !SettingsDesktop.fullscreen;
        if (SettingsDesktop.fullscreen) PTCFG.fullscreenBorderless = false;
        SettingsDesktop.saveConfig();
        Game.menuManager.addToastGold(Game.lang.get("GameNeedsToBeRestartedToApplyTheChanges"), Images.settings);
    }

}
