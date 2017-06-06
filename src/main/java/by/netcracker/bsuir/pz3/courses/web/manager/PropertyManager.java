package by.netcracker.bsuir.pz3.courses.web.manager;

import by.netcracker.bsuir.pz3.courses.web.constant.WebPagePropertiesAndKeys;

import java.util.ResourceBundle;

public enum  PropertyManager {
    INSTANCE;

    private final ResourceBundle bundle = ResourceBundle.getBundle(WebPagePropertiesAndKeys.PAGE_PROPERTIES_FILE_NAME);

    PropertyManager() {
    }

    public String getPageLocation(String propertyKey) {
        return bundle.getString(propertyKey);
    }
}
