package ca.uwaterloo.ner.processors;


import ca.uwaterloo.ner.exceptions.InternalAppException;
import ca.uwaterloo.ner.utils.Options;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.dom4j.tree.DefaultElement;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;

import java.io.File;
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

    public void findLinks(Document document) throws DocumentException
    {
        logger.info("Executing findLinks");

        List list = document.selectNodes("//value");
        for (Object object : list)
        {
            try
            {
                DefaultElement element = (DefaultElement) object;
                logger.info(element.getText());
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
