package ca.uwaterloo.ner.tests;

import ca.uwaterloo.ner.bean.Annotation;
import ca.uwaterloo.ner.utils.IllinoisNERHelper;
import edu.illinois.cs.cogcomp.core.datastructures.ViewNames;
import edu.illinois.cs.cogcomp.ner.NERAnnotator;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class NERAnnotatorTest
{
    @Test
    public void testNERAnnotator()
        throws IOException
    {

        String text = "Mr. Bean is the best comedian ever. He works for NBC. ";
        String corpus = "corpus-1";
        String textId = "1";

        NERAnnotator nerAnnotator = new NERAnnotator(ViewNames.NER_CONLL);
        nerAnnotator.doInitialize();

        List<Annotation> annotations = IllinoisNERHelper.tagDocument(text, corpus, textId, nerAnnotator);
        System.out.println(annotations);
        assert annotations != null;
    }
}
