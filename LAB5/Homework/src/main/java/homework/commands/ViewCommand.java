package homework.commands;

import homework.exceptions.CommandException;
import homework.items.Item;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;

/**
 * this class opens the location for a specified item from an existing catalog.
 * if the location for that item is a web URL, this will be opened
 * if the location is on the disk, that file will be searched and opened.
 *
 * @throws CommandException if the item is null after cast.
 */
public class ViewCommand extends CommonCommandBehaviour {
    @Override
    void run() throws IOException, CommandException {
        Item item = (Item) super.obj.get(0);
        if (item == null) throw new CommandException("Command failed, object references are null.");
        String path = item.getLocation();
        File file = null;
        Desktop desktop = null;
        try {
            file = new File(path);
            desktop = Desktop.getDesktop();
            if (path.contains("http")) {
                URI uri = URI.create(path);
                desktop.browse(uri);
            } else {
                desktop.open(file);
            }
        } finally {
            file = null;
            desktop = null;

        }
    }
}
