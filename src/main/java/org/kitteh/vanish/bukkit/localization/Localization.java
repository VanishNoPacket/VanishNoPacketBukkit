package org.kitteh.vanish.bukkit.localization;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Localization {
    
    private static final String BUNDLE_NAME_PREFIX = "org.kitteh.vanish.bukkit.localization.";

    private static ResourceBundle RESOURCE_BUNDLE;

    public Localization(String language) {
        RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME_PREFIX + language);
    }

    public static String getString(String key) {
        try {
            return RESOURCE_BUNDLE.getString(key);
        } catch (MissingResourceException e) {
            return '!' + key + '!';
        }
    }
    
    public static String getString(String key, Object... substitutes) {
        try {
            return String.format(RESOURCE_BUNDLE.getString(key), substitutes);
        } catch (MissingResourceException e) {
            return '!' + key + '!';
        }
    }
    
}
