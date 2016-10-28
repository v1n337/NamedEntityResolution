package ca.uwaterloo.ner.tests;

import ca.uwaterloo.ner.bean.Article;
import ca.uwaterloo.ner.utils.XMLHelper;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class XMLMapperTest
{
    @Test
    public void testXmlMapper()
        throws IOException
    {
        String filePath = "/home/v2john/Documents/Veriday/11-articles-canaccord-REJECT.xml";

        List<Article> articles = XMLHelper.getObjects(filePath);

        System.out.println(articles);
    }
}
