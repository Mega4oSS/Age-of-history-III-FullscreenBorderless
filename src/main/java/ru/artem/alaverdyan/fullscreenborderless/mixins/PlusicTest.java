package ru.artem.alaverdyan.fullscreenborderless.mixins;

import aoc.kingdoms.lukasz.jakowski.CFG;
import aoc.kingdoms.lukasz.jakowski.Game;
import aoc.kingdoms.lukasz.menu_element.MenuElement;
import javassist.CannotCompileException;
import javassist.CtClass;
import javassist.NotFoundException;
import ru.artem.alaverdyan.LocalCapture;
import ru.artem.alaverdyan.Mixin;
import ru.artem.alaverdyan.fullscreenborderless.elements.PlusicElementTest;
import ru.artem.alaverdyan.injections.*;

import java.util.List;

@Mixin(value = "aoc.kingdoms.lukasz.menus.Settings.Settings_Menu")
public class PlusicTest {
    @Inject(method = "Settings_Menu", at = @At(value = "BY", by = 123), returnTo = @ReturnTo(to = "buttonY"))
    public int injected(List<MenuElement> menuElements, int buttonY, int menuWidth, int paddingLeft) {
        menuElements.add(new PlusicElementTest(Game.lang.get("FullscreenBorderless"), CFG.FONT_REGULAR, -1, paddingLeft, buttonY, menuWidth - paddingLeft * 2, true, CFG.BUTTON_HEIGHT, true));
        return buttonY + ( menuElements.get(menuElements.size() - 1)).getHeight() + (CFG.PADDING);
    }

    //@DirectInject
    //public static void directInject(CtClass ctClass) throws NotFoundException, CannotCompileException {
    //    ctClass.getDeclaredConstructor(new CtClass[] {}).insertAt(123,
    //            "buttonY += ((aoc.kingdoms.lukasz.menu_element.MenuElement) menuElements.get(menuElements.size() - 1)).getHeight() + (aoc.kingdoms.lukasz.jakowski.CFG.PADDING);");
    //}

}
