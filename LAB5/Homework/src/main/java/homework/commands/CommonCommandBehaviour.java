package homework.commands;

import freemarker.template.TemplateException;
import homework.exceptions.CommandException;
import homework.exceptions.InitializationException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

/**
 * this class creates the common behaviour for all future commands.
 */
public abstract class CommonCommandBehaviour implements Command {
    public static final String path = "C:/Users/dasca/Desktop/GREEN_GUM/JAVA/PA2023_A5/LAB5/Homework/catalog.json";
    List<Object> obj;

    /**
     * this method makes a list of Objects from what is given at the call time.
     *
     * @param objects objects passed during calling the methods
     * @throws IOException
     * @throws TemplateException
     * @throws URISyntaxException
     * @throws CommandException
     * @throws InitializationException
     */
    public void execute(Object... objects) throws IOException, TemplateException, URISyntaxException, CommandException,
            InitializationException {
        this.obj = Arrays.stream(objects).toList();
        if (obj == null) throw new InitializationException("The initial list of Objects is null");
        run();
    }

    /**
     * this method is actually the main method for all commands (specific behaviour for each one)
     *
     * @throws IOException
     * @throws URISyntaxException
     * @throws TemplateException
     * @throws CommandException
     */
    abstract void run() throws IOException, URISyntaxException, TemplateException, CommandException;

}
