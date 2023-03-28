package homework.commands;

import com.fasterxml.jackson.databind.ObjectMapper;
import homework.exceptions.CommandException;
import homework.items.*;

import java.io.File;
import java.io.IOException;

/**
 * this lass saves an existing catalog on the disk, to a specified path
 *
 * @throws CommandException if the catalog is null
 */
public class SaveCommand extends CommonCommandBehaviour {
    @Override
    void run() throws IOException, CommandException {
        Catalog catalog = (Catalog) super.obj.get(0);
        if (catalog == null) throw new CommandException("Command failed, object references are null.");
        String path = CommonCommandBehaviour.path;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(path), catalog);
    }
}
