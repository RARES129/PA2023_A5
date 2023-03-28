package homework.commands;

import freemarker.template.TemplateException;
import homework.exceptions.CommandException;
import homework.exceptions.InitializationException;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * describes how a command should look like in the first place.
 */
public interface Command {
    void execute(Object... objects) throws IOException, TemplateException, URISyntaxException, CommandException, InitializationException;
}