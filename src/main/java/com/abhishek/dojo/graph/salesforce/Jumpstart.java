package com.abhishek.dojo.graph.salesforce;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * main.Jumpstart
 */

/**
 * Class which will read input from the console, and call the appropriate
 * command.
 *
 * @author interview
 */
public class Jumpstart {

    /**
     * Input stream for commands
     */
    private BufferedReader _input;

    /**
     * Output stream for results
     */
    private PrintStream _output;

    private static Map<String, Command> COMMANDS = new HashMap<>();

    static {

        COMMANDS.put("DEPEND", new DependCommand());
        COMMANDS.put("INSTALL", new InstallCommand());
        COMMANDS.put("REMOVE", new RemoveCommand());
        COMMANDS.put("LIST", new ListCommand());
    }

    /**
     * Runs the parser on the supplied test data set. Expects a file in the
     * current working directory. Output is sent to stdout
     *
     * @param args not used
     */
    public static void main(String[] args) throws Exception {

        InputStream in = null;
        in = Jumpstart.class.getResourceAsStream("/commands.dat");
        try {
            if (args.length > 0 && args[0] != null)
                in = new FileInputStream(args[0]);
        } catch (FileNotFoundException e) {
            in = Jumpstart.class.getResourceAsStream("/commands.dat");
        }
        if(in == null)
            throw new IllegalArgumentException("no input file found");

        Jumpstart parser = new Jumpstart(in, System.out);
        parser.process();
    }

    /**
     * Creates a new CommandParser, sending input and output to the specified
     * locations
     *
     * @param in  input stream for commmands
     * @param out output stream for results
     */
    public Jumpstart(InputStream in, PrintStream out) {
        _input = new BufferedReader(new InputStreamReader(in));
        _output = out;

    }

    /**
     * Processes a command from user. invalid commands are not printed, and
     * silently ignored. An invalid command includes a command which is missing
     * its argument. For example: "mkdir " is invalid.
     *
     * @param line line of text representing the command string
     */
    public void processLine(String line) {
        String[] arguments = line.split("[ ]+");
        Command cmd = COMMANDS.get(arguments[0]);
        if (cmd == null)
            throw new IllegalArgumentException("Unknown command " + line);

        _output.println(line);
        List<String> args = new LinkedList<String>(Arrays.asList(arguments));
        args.remove(0); // ditch the command piece
        Map<String, String> success = cmd.execute(args);
        success.entrySet().stream().forEach(e -> _output.println("\t" + e.getKey() + " " + e.getValue()));
    }

    /**
     * Reads all commands from the input, and executes them
     *
     * @throws IOException if a read error occurs while parsing commands
     */
    public void process() throws IOException {
        String line = _input.readLine();
        while (line != null && line.length() > 0) {
            if (line.equals("END")) {
                _output.println(line);
                break;

            }
            processLine(line);
            line = _input.readLine();
        }
    }

}