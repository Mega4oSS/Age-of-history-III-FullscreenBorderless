package ru.artem.alaverdyan.fullscreenborderless.elements;
import aoh.kingdoms.history.mainGame.CFG;
import aoh.kingdoms.history.mainGame.setting.SettingsDesktop;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import ru.artem.alaverdyan.PlusicAPI;

import java.io.File;

public class PTCFG {
    public static int screenMode = 2;
    public static boolean fullscreenBorderless = false;
    public static String pathToConfig = "";

    static {
        for (int i = 0; i < PlusicAPI.mods.size(); i++) {
            if(PlusicAPI.mods.get(i).getName().equals("FullscreenBorderless")) {
                pathToConfig = PlusicAPI.mods.get(i).getRoot() + File.separator + "settings" + File.separator +  "Config.txt";
            }
        }
    }

    public static void readConfig() {
        try {
            if (Gdx.files.absolute(pathToConfig).exists()) {
                final FileHandle file = Gdx.files.absolute(pathToConfig);
                final String tempTags = file.readString();
                final String[] tSplited = tempTags.replace("\n", "").split(";");
                for (int i = 0; i < tSplited.length; ++i) {
                    final String[] tempR = tSplited[i].split("=");
                    try {
                        if (tempR[0].equals("SCREENMODE")) {
                            SettingsDesktop.fullscreen = Integer.parseInt(tempR[1]) == 1 ? true : false;
                            PTCFG.fullscreenBorderless = Integer.parseInt(tempR[1]) == 2 ? true : false;
                        }
                        else if (tempR[0].equals("WIDTH")) {
                            SettingsDesktop.iWidth = Integer.parseInt(tempR[1]);
                        }
                        else if (tempR[0].equals("HEIGHT")) {
                            SettingsDesktop.iHeight = Integer.parseInt(tempR[1]);
                        }
                        else if (tempR[0].equals("VSYNC")) {
                            SettingsDesktop.vSync = Boolean.parseBoolean(tempR[1]);
                        }
                    }
                    catch (final IndexOutOfBoundsException ex) {
                        SettingsDesktop.iWidth = -1;
                        SettingsDesktop.iHeight = -1;
                        SettingsDesktop.fullscreen = true;
                        PTCFG.fullscreenBorderless = false;
                        break;
                    }
                    catch (final IllegalArgumentException ex2) {
                        SettingsDesktop.iWidth = -1;
                        SettingsDesktop.iHeight = -1;
                        SettingsDesktop.fullscreen = true;
                        PTCFG.fullscreenBorderless = false;
                        break;
                    }
                }
            }
        }
        catch (final Exception ex3) {
            CFG.exceptionStack(ex3);
        }
    }

    public static void saveConfig() {
        int sMode = 0;
        if(SettingsDesktop.fullscreen == true) sMode = 1;
        if(fullscreenBorderless == true) sMode = 2;
        final FileHandle fileSave = Gdx.files.absolute(pathToConfig);
        fileSave.writeString("SCREENMODE=" + sMode + ";\n", false);
        fileSave.writeString("WIDTH=" + SettingsDesktop.iWidth + ";\n", true);
        fileSave.writeString("HEIGHT=" + SettingsDesktop.iHeight + ";\n", true);
        fileSave.writeString("VSYNC=" + SettingsDesktop.vSync + ";", true);
    }
}
