package ca.uwaterloo.ner;


import ca.uwaterloo.ner.processors.IllinoisNERProcessor;
import ca.uwaterloo.ner.processors.Processor;
import ca.uwaterloo.ner.utils.Options;

public class NamedEntityResolver
{
    public static void main(String[] args)
        throws Exception
    {
        Options.initializeInstance(args);
        Processor processor = new IllinoisNERProcessor();
        processor.process();
    }
}
