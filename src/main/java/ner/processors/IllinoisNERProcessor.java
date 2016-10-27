package main.java.ner.processors;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class IllinoisNERProcessor extends Processor
{
    private static Logger logger = LogManager.getLogger(IllinoisNERProcessor.class);

    public void process()
    {
        logger.info("Execution begun");
    }
}
