package homework.commands;

import homework.exceptions.CommandException;
import homework.items.Catalog;

/**
 * this class displays a catalog given as a parameter
 *
 * @throws CommandException if the catalog is null after casting
 */
public class ListCommand extends CommonCommandBehaviour {
    @Override
    void run() throws CommandException {
        Catalog catalog = (Catalog) super.obj.get(0);
        if (catalog == null) throw new CommandException("Command failed, objects references are null.");
        System.out.println(catalog.getItems());
    }
}
