package ru.artem.alaverdyan.fullscreenborderless.elements;

import aoh.kingdoms.history.mainGame.Game;
import aoh.kingdoms.history.mainGame.setting.SettingsDesktop;
import aoh.kingdoms.history.menu_element.button.ButtonGame2;
import aoh.kingdoms.history.textures.Images;

public class PlusicElementTest extends ButtonGame2 {
    public PlusicElementTest(String sText, int fontID, int iTextPositionX, int iPosX, int iPosY, int nWidth, boolean isClickable) {
        super(sText, fontID, iTextPositionX, iPosX, iPosY, nWidth, isClickable);
    }

    public PlusicElementTest(String sText, int fontID, int iTextPositionX, int iPosX, int iPosY, int nWidth, boolean isClickable, int nHeight) {
        super(sText, fontID, iTextPositionX, iPosX, iPosY, nWidth, isClickable, nHeight);
    }

    public PlusicElementTest(String sText, int fontID, int iTextPositionX, int iPosX, int iPosY, int nWidth, boolean isClickable, int nHeight, boolean checkBox) {
        super(sText, fontID, iTextPositionX, iPosX, iPosY, nWidth, isClickable, nHeight, checkBox);
    }

    public PlusicElementTest(String sText, int fontID, int iTextPositionX, int iPosX, int iPosY, int nWidth, boolean isClickable, boolean checkBox) {
        super(sText, fontID, iTextPositionX, iPosX, iPosY, nWidth, isClickable, checkBox);
    }

    public boolean getCheckboxState() {
        return PTCFG.fullscreenBorderless;
    }

    public void actionElement() {
        PTCFG.fullscreenBorderless = !PTCFG.fullscreenBorderless;
        if (PTCFG.fullscreenBorderless) SettingsDesktop.fullscreen = false;
        SettingsDesktop.saveConfig();
        Game.menuManager.addToastGold(Game.lang.get("GameNeedsToBeRestartedToApplyTheChanges"), Images.settings);
    }
}
