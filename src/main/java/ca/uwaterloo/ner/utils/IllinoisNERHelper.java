package ca.uwaterloo.ner.utils;

import edu.illinois.cs.cogcomp.annotation.TextAnnotationBuilder;
import edu.illinois.cs.cogcomp.core.datastructures.ViewNames;
import edu.illinois.cs.cogcomp.core.datastructures.textannotation.Constituent;
import edu.illinois.cs.cogcomp.core.datastructures.textannotation.TextAnnotation;
import edu.illinois.cs.cogcomp.core.datastructures.textannotation.View;
import edu.illinois.cs.cogcomp.ner.NERAnnotator;
import edu.illinois.cs.cogcomp.nlp.tokenizer.IllinoisTokenizer;
import edu.illinois.cs.cogcomp.nlp.utility.TokenizerTextAnnotationBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class IllinoisNERHelper
{
    private static Logger logger = LogManager.getLogger(ca.uwaterloo.ner.utils.IllinoisNERHelper.class);

    public static void tagDocument(String text, String corpus, String textId, NERAnnotator annotator)
    {
        TextAnnotationBuilder annotationBuilder = new TokenizerTextAnnotationBuilder(new IllinoisTokenizer());
        TextAnnotation textAnnotation = annotationBuilder.createTextAnnotation(corpus, textId, text);

        annotator.addView(textAnnotation);

        View taggedText = textAnnotation.getView(ViewNames.NER_CONLL);
        List<Constituent> constituents = taggedText.getConstituents();
        for (Constituent constituent : constituents)
        {
            logger.info(constituent);
            logger.info(constituent.getLabel());
        }
    }
}
