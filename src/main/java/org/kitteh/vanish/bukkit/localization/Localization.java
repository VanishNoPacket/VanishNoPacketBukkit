package org.kitteh.vanish.bukkit.localization;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Localization {
    
    /**
     * The prefix of fully qualified names for bundles
     */
    private static final String BUNDLE_NAME_PREFIX = "org.kitteh.vanish.bukkit.localization.";

    /**
     * Resource bundle for the selected language used to grab localized strings
     */
    private static ResourceBundle RESOURCE_BUNDLE;
    
    /**
     * Used to default back to English bundle in case of missing localizations
     */
    private static ResourceBundle ENGLISH_RESOURCE_BUNDLE;

    public Localization(String language) {
        language = language.toLowerCase();
        RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME_PREFIX + language);
        if (language.equalsIgnoreCase("english")) {
            ENGLISH_RESOURCE_BUNDLE = RESOURCE_BUNDLE;
        } else {
            ENGLISH_RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME_PREFIX + "english");
        }
    }

    public static String getString(String key) {
        try {
            return RESOURCE_BUNDLE.getString(key);
        } catch (MissingResourceException e) {
            if (RESOURCE_BUNDLE.equals(ENGLISH_RESOURCE_BUNDLE)) {
                return '!' + key + '!';
            }
            try {
                return ENGLISH_RESOURCE_BUNDLE.getString(key);
            } catch (MissingResourceException ex) {
                return '!' + key + '!';
            }
        }
    }
    
    public static String getString(String key, Object... substitutes) {
        try {
            return String.format(RESOURCE_BUNDLE.getString(key), substitutes);
        } catch (MissingResourceException e) {
            if (RESOURCE_BUNDLE.equals(ENGLISH_RESOURCE_BUNDLE)) {
                return '!' + key + '!';
            }
            try {
                return String.format(ENGLISH_RESOURCE_BUNDLE.getString(key), substitutes);
            } catch (MissingResourceException ex) {
                return '!' + key + '!';
            }
        }
    }
    
}
