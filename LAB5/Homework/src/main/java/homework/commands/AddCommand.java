package homework.commands;

import homework.exceptions.CommandException;
import homework.items.Catalog;
import homework.items.Item;

/**
 * This class adds an item to an existing catalog
 *
 * @throws CommandException if the objects cannot be modified from Object to desired type.
 */
public class AddCommand extends CommonCommandBehaviour {
    @Override
    public void run() throws CommandException {
        Catalog catalog = (Catalog) super.obj.get(0);
        Item item = (Item) super.obj.get(1);
        if (catalog == null || item == null) throw new CommandException("Command failed, object references are null.");
        catalog.add(item);
    }
}
