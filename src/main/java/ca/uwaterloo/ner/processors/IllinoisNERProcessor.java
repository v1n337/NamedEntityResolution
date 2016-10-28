package ca.uwaterloo.ner.processors;


import ca.uwaterloo.ner.utils.IllinoisNERHelper;
import ca.uwaterloo.ner.utils.Options;
import edu.illinois.cs.cogcomp.core.datastructures.ViewNames;
import edu.illinois.cs.cogcomp.ner.NERAnnotator;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.dom4j.tree.DefaultElement;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class IllinoisNERProcessor extends Processor
{
    private static Logger logger = LogManager.getLogger(IllinoisNERProcessor.class);

    public void process()
        throws Exception
    {
        logger.info("Execution begun");

        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new File(Options.getInstance().getXmlFilePath()));

        findLinks(document);
    }

    public void findLinks(Document document)
        throws DocumentException, IOException
    {
        logger.info("Executing findLinks");
        List list = document.selectNodes("//value");
        Integer counter = 0;
        Integer docId = null;
        String docText = null;

        NERAnnotator nerAnnotator = new NERAnnotator(ViewNames.NER_CONLL);

        for (Object object : list)
        {
            try
            {
                DefaultElement element = (DefaultElement) object;
                docId = counter++;
                docText = StringEscapeUtils.unescapeXml(StringEscapeUtils.unescapeXml(element.getText()));
                IllinoisNERHelper.tagDocument(docText, "corpus-1", docId.toString(), nerAnnotator);
                logger.debug(docText);
            }
            catch (Exception e)
            {
                logger.error("skipping element " + object);
                logger.error(e);
            }
        }

        logger.info("Finished findLinks");
    }
}
