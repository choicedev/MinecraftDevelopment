package com.choice.minecraftdevelopment.config;

import com.choice.minecraftdevelopment.manager.ConfigManager;
import com.choice.minecraftdevelopment.model.User;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.plugin.java.JavaPlugin;


public class LoginConfig extends ConfigManager {
    public static final String USER_KEY = "user";
    public static final String USERNAME_KEY = "name";
    public static final String PASSWORD_KEY = "password";
    public static final String ONLINE_KEY = "online";
    public static final String LASTLOGIN_KEY = "last_login";
    public static final String TIMESTAMP_KEY = "timestamp";

    public LoginConfig(JavaPlugin plugin, String fileName) {
        super(plugin, "/accounts/"+fileName+".yml");
    }

    public LoginConfig(JavaPlugin plugin) {
        super(plugin, "/accounts/readme.yml");
    }


    public void setLastLogin(String lastLogin){
        ConfigurationSection loginSection = getFileConfig().getConfigurationSection(USER_KEY);
        assert loginSection != null;
        loginSection.set(LASTLOGIN_KEY, lastLogin);
        saveConfig();
    }

    public void setOnline(boolean isOnline){
        ConfigurationSection loginSection = getFileConfig().getConfigurationSection(USER_KEY);
        assert loginSection != null;
        loginSection.set(ONLINE_KEY, isOnline);
        saveConfig();
    }

    public void saveUser(User user){
        getFileConfig().set(USER_KEY + "." + USERNAME_KEY, user.getUsername());
        getFileConfig().set(USER_KEY + "." + PASSWORD_KEY, user.getPassword());
        getFileConfig().set(USER_KEY + "." + ONLINE_KEY, user.isOnline());
        getFileConfig().set(USER_KEY + "." + LASTLOGIN_KEY, user.getLastLogin());
        getFileConfig().set(USER_KEY + "." + TIMESTAMP_KEY, user.getTimestamp());
        saveConfig();
    }

    public User loadUser(){
        ConfigurationSection loginSection = getFileConfig().getConfigurationSection(USER_KEY);
        if (loginSection == null) {
            return null;
        }

        String name = loginSection.getString(USERNAME_KEY);
        String password = loginSection.getString(PASSWORD_KEY);
        Boolean isOnline = loginSection.getBoolean(ONLINE_KEY);
        String last_login = loginSection.getString(LASTLOGIN_KEY);
        String timestamp = loginSection.getString(TIMESTAMP_KEY);

        return new User(name, password, isOnline, last_login, timestamp);
    }
}
