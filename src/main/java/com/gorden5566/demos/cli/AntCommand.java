package com.gorden5566.demos.cli;

import org.apache.commons.cli.*;

/**
 * @author gorden5566
 * @date 2020/06/05
 */
public class AntCommand {
    public static void main(String[] args) {
        Option help = new Option("help", "print this message");
        Option projecthelp = new Option("projecthelp", "print project help information");
        Option version = new Option("version", "print the version information and exit");
        Option quiet = new Option("quiet", "be extra quiet");
        Option verbose = new Option("verbose", "be extra verbose");
        Option debug = new Option("debug", "print debugging information");
        Option emacs = new Option("emacs", "produce logging information without adornments");

        Option logfile = Option.builder("logfile").argName("file")
            .hasArg()
            .desc("use given file for log")
            .build();

        Option logger = Option.builder("logger").argName("classname")
            .hasArg()
            .desc("the class which it to perform "
                + "logging")
            .build();

        Option listener = Option.builder("listener").argName("classname")
            .hasArg()
            .desc("add an instance of class as "
                + "a project listener")
            .build();

        Option buildfile = Option.builder("buildfile").argName("file")
            .hasArg()
            .desc("use given buildfile")
            .build();

        Option find = Option.builder("find").argName("file")
            .hasArg()
            .desc("search for buildfile towards the "
                + "root of the filesystem and use it")
            .build();

        Option property = Option.builder("D").argName("property=value")
            .numberOfArgs(2)
            .valueSeparator()
            .desc("use value for given property")
            .build();

        Options options = new Options();

        options.addOption(help);
        options.addOption(projecthelp);
        options.addOption(version);
        options.addOption(quiet);
        options.addOption(verbose);
        options.addOption(debug);
        options.addOption(emacs);
        options.addOption(logfile);
        options.addOption(logger);
        options.addOption(listener);
        options.addOption(buildfile);
        options.addOption(find);
        options.addOption(property);

        // create the parser
        CommandLineParser parser = new DefaultParser();
        try {
            // parse the command line arguments
            CommandLine line = parser.parse(options, args);

            // has the buildfile argument been passed?
            if (line.hasOption("buildfile")) {
                // initialise the member variable
//                this.buildfile = line.getOptionValue("buildfile");
                System.out.println(line.getOptionValue("buildfile"));
            }

            // automatically generate the help statement
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp( "ant", options, true);


        } catch (ParseException exp) {
            // oops, something went wrong
            System.err.println("Parsing failed.  Reason: " + exp.getMessage());
        }
    }
}
