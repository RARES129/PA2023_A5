package homework.commands;

import com.fasterxml.jackson.databind.ObjectMapper;
import homework.exceptions.CommandException;
import homework.items.*;

import java.io.File;
import java.io.IOException;

/**
 * this class loads a catalog from a specific path. The catalog needs to be already present at that path.
 *
 * @throws IOException
 * @throws CommandException if the object has null for this reference.
 */
public class LoadCommand {
    public Catalog execute() throws IOException, CommandException {
        ObjectMapper objectMapper = new ObjectMapper();
        Catalog catalog = objectMapper.readValue(new File(CommonCommandBehaviour.path), Catalog.class);
        if (catalog == null) throw new CommandException("Command failed, object references are null.");

        return catalog;
    }
}
