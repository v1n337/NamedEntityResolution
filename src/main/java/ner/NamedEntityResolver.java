package main.java.ner;


import main.java.ner.processors.IllinoisNERProcessor;
import main.java.ner.utils.Options;
import main.java.ner.exceptions.InvalidConfigurationError;
import main.java.ner.processors.Processor;

public class NamedEntityResolver
{
    public static void main(String[] args)
        throws InvalidConfigurationError
    {
        Options.initializeInstance(args);
        Processor processor = new IllinoisNERProcessor();
        processor.process();
    }
}
