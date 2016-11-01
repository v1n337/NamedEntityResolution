package ca.uwaterloo.ner.utils;

import ca.uwaterloo.ner.bean.Annotation;
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

import java.util.ArrayList;
import java.util.List;

public class IllinoisNERHelper
{
    private static Logger logger = LogManager.getLogger(ca.uwaterloo.ner.utils.IllinoisNERHelper.class);

    public static List<Annotation> tagDocument(String text, String corpus, String textId, NERAnnotator annotator)
    {
        TextAnnotationBuilder annotationBuilder = new TokenizerTextAnnotationBuilder(new IllinoisTokenizer());
        TextAnnotation textAnnotation = annotationBuilder.createTextAnnotation(corpus, textId, text);

        annotator.addView(textAnnotation);
        View taggedText = textAnnotation.getView(ViewNames.NER_CONLL);

        List<Constituent> constituents = taggedText.getConstituents();
        List<Annotation> annotations = new ArrayList<>();

        for (Constituent constituent : constituents)
        {
            annotations.add(new Annotation(constituent.toString(), constituent.getLabel()));
        }

        return annotations;
    }
}
