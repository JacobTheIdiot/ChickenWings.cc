package me.alpha432.oyvey.features.command.commands;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.alpha432.oyvey.OyVey;
import me.alpha432.oyvey.features.command.Command;

public class DiscordCommand
        extends Command {
    public DiscordCommand() {
        super("Discord", new String[]{"<char>"});
    }

    @Override
    public void execute(String[] commands) {
        if (commands.length == 1) {
            Command.sendMessage(ChatFormatting.GREEN + "The Discord Server is https://discord.gg/fK5VhVY7gU feel free to join :D ");

        }


    }

    {
    }
    }