package cmo.zect.sample;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class SamplePlugin extends JavaPlugin {

    @Override
    public void onLoad() {
        getLogger().info("onLoad is called");
            
        CommandAPI.onLoad(true); //Load with verbose output
        
        new CommandAPICommand("ping")
            .executes((sender, args) -> {
                sender.sendMessage("pong!");
            })
            .register();
    }
    
    @Override
    public void onEnable() {
        CommandAPI.onEnable(this);
        
        // Plugin startup logic
        getLogger().info("onEnable is called");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("onDisable is called");
    }

    // onCommand は plugin.yml に記載されたコマンドが呼ばれた時に実行
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if(cmd.getName().equalsIgnoreCase("sampleone")){
            // qiitaコマンド が実行された時に実行
            sender.sendMessage("Sample Command No.1!");
            return true;
        }
        if(cmd.getName().equalsIgnoreCase("sampletwo")){
            // sampleコマンド が実行された時に実行
            sender.sendMessage("Sample Command No.2!");
            return true;
        }
        return false;
    }
}
