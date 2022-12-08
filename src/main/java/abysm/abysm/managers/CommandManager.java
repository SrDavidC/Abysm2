package abysm.abysm.managers;


import abysm.abysm.Abysm;

import abysm.abysm.commands.*;
import co.aikar.commands.PaperCommandManager;

public class CommandManager {
   PaperCommandManager commandManager;
   public CommandManager(){
      this.commandManager = new PaperCommandManager(Abysm.getPl());
      commandManager.registerCommand(new testC());
      commandManager.registerCommand(new gamemode1());
      commandManager.registerCommand(new debugMode());
      commandManager.registerCommand(new ProbabilidadTotem());
      commandManager.registerCommand(new SetDays());
      commandManager.registerCommand(new worldSend());
      commandManager.registerCommand(new Respawn());
      commandManager.registerCommand(new GetItems());
      commandManager.registerCommand(new Config());
   }

}
