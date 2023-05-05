package com.choice.minecraftdevelopment.base;

import com.choice.minecraftdevelopment.manager.CommandManager;
import com.choice.minecraftdevelopment.manager.EventManager;

public interface BaseMain {

    void initCommands(CommandManager cm);

    void initListeners(EventManager em);
}
