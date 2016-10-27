package ca.uwaterloo.ner.utils;

import ca.uwaterloo.ner.exceptions.InternalAppException;
import ca.uwaterloo.ner.exceptions.InvalidConfigurationError;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

/**
 * This class reads and processes the command line arguments
 */
public class Options
{
    private static Options instance = null;
    private static Logger logger = LogManager.getLogger(Options.class);

    @Option(name = "-help", usage = "help", metaVar = "HELP")
    private Boolean help = false;

    @Option(name = "-xmlFilePath", usage = "XML File Path", metaVar = "XML_FILE_PATH",
        required = true)
    private String xmlFilePath;

    public static void initializeInstance(String[] args)
        throws InvalidConfigurationError
    {
        if(null == instance)
        {
            instance = new Options(args);
        }
    }

    public static Options getInstance()
        throws InternalAppException
    {
        if(null == instance)
        {
            throw new InternalAppException("Tried accessing options without initializing it first.");
        }
        return instance;
    }

    private Options(String[] args)
        throws InvalidConfigurationError
    {
        CmdLineParser parser = new CmdLineParser(this);

        if(help)
        {
            parser.printUsage(System.out);
            System.exit(0);
        }

        try
        {
            parser.parseArgument(args);
        }
        catch (CmdLineException e)
        {
            logger.error("CmdLineException while reading options", e);
            throw new InvalidConfigurationError(
                    "CmdLineException while reading options", e
            );
        }

        logger.info("Options successfully read");
    }
}
