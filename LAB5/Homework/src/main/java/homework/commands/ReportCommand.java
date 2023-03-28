package homework.commands;

import freemarker.template.*;
import freemarker.template.Template;
import homework.exceptions.CommandException;
import homework.items.Catalog;

import java.io.*;
import java.net.URISyntaxException;

/**
 * this class generates a HTML report of an existing catalog (catalog + items)
 * it uses template.ftl from resources
 */
public class ReportCommand extends CommonCommandBehaviour {
    @Override
    void run() throws IOException, URISyntaxException, TemplateException, CommandException {
        Catalog catalog = (Catalog) super.obj.get(0);
        if (catalog == null) throw new CommandException("Command failed, objects references are null.");
        Configuration configuration = new Configuration();
        configuration.setDirectoryForTemplateLoading(new File(ReportCommand.class.getResource("/templates").toURI()));

        Template template = configuration.getTemplate("template.ftl");
        Writer writer = null;
        try {
            writer = new FileWriter(new File("C:\\Users\\dasca\\Desktop\\template.html"));
            template.process(catalog, writer);
        } finally {
            if (writer != null) {
                writer.flush();
                writer.close();
            }

        }

    }
}
