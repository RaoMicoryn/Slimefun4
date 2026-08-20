package io.github.thebusybiscuit.slimefun4.implementation;

import io.github.thebusybiscuit.slimefun4.utils.NumberUtils;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.ParametersAreNonnullByDefault;

/**
 * This class stores some startup warnings we occasionally need to print.
 * If you setup your server the recommended way, you are never going to see
 * any of these messages.
 *
 * @author TheBusyBiscuit
 *
 */
final class StartupWarnings {

    private static final String BORDER = "****************************************************";
    private static final String PREFIX = "* ";

    private StartupWarnings() {}

    @ParametersAreNonnullByDefault
    static void discourageCSCoreLib(Logger logger) {
        logger.log(Level.SEVERE, BORDER);
        logger.log(Level.SEVERE, PREFIX + "CS-CoreLib appears to be installed.");
        logger.log(Level.SEVERE, PREFIX);
        logger.log(Level.SEVERE, PREFIX + "CS-CoreLib has not been required since 2021/01/30.");
        logger.log(Level.SEVERE, PREFIX + "Uninstall CS-CoreLib for Slimefun to run correctly.");
        logger.log(Level.SEVERE, BORDER);
    }

    @ParametersAreNonnullByDefault
    static void invalidMinecraftVersion(Logger logger, String detectedVer, String slimefunVersion) {
        logger.log(Level.SEVERE, BORDER);
        logger.log(Level.SEVERE, PREFIX + "Slimefun failed to load!");
        logger.log(Level.SEVERE, PREFIX + "You are using an unsupported Minecraft version!");
        logger.log(Level.SEVERE, PREFIX);
        logger.log(Level.SEVERE, PREFIX + "You are using Minecraft {0}", detectedVer);
        logger.log(Level.SEVERE, PREFIX + "Slimefun {0} only supports the following versions:", slimefunVersion);
        logger.log(Level.SEVERE, PREFIX + "Minecraft {0}", String.join(" / ", Slimefun.getSupportedVersions()));
        logger.log(Level.SEVERE, BORDER);
    }

    @ParametersAreNonnullByDefault
    static void invalidServerSoftware(Logger logger) {
        logger.log(Level.SEVERE, BORDER);
        logger.log(Level.SEVERE, PREFIX + "Slimefun failed to load!");
        logger.log(Level.SEVERE, PREFIX + "CraftBukkit servers are no longer supported!");
        logger.log(Level.SEVERE, PREFIX);
        logger.log(Level.SEVERE, PREFIX + "Use Paper or one of its forks");
        logger.log(Level.SEVERE, PREFIX + "(Paper is recommended)");
        logger.log(Level.SEVERE, BORDER);
    }

    @ParametersAreNonnullByDefault
    static void oldJavaVersion(Logger logger, int recommendedJavaVersion) {
        int javaVersion = NumberUtils.getJavaVersion();

        logger.log(Level.WARNING, BORDER);
        logger.log(Level.WARNING, PREFIX + "The Java version in use (Java {0}) is outdated.", javaVersion);
        logger.log(Level.WARNING, PREFIX);
        logger.log(Level.WARNING, PREFIX + "Newer Minecraft versions require Java {0}.", recommendedJavaVersion);
        logger.log(Level.WARNING, PREFIX + "We recommend upgrading to Java {0} soon.", recommendedJavaVersion);
        logger.log(Level.WARNING, PREFIX + "To use features from newer Java versions,");
        logger.log(
                Level.WARNING,
                PREFIX + "Slimefun will also require Java {0} in the near future.",
                recommendedJavaVersion);
        logger.log(Level.WARNING, PREFIX + "Please update soon to avoid future issues!");
        logger.log(Level.WARNING, BORDER);
    }
}
