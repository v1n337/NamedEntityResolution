package ca.uwaterloo.ner;


import ca.uwaterloo.ner.processors.IllinoisNERProcessor;
import ca.uwaterloo.ner.processors.Processor;
import ca.uwaterloo.ner.utils.Options;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NamedEntityResolver
{
    private static Logger logger = LogManager.getLogger(NamedEntityResolver.class);

    public static void main(String[] args)
    {
        try
        {
            Options.initializeInstance(args);
            Processor processor = new IllinoisNERProcessor();
            processor.process();
        }
        catch (Exception e)
        {
            logger.error(e);
            System.exit(1);
        }
    }
}
