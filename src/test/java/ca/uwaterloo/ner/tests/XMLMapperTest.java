package ca.uwaterloo.ner.tests;

import ca.uwaterloo.ner.bean.Article;
import ca.uwaterloo.ner.utils.XMLHelper;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

public class XMLMapperTest
{
    @Test
    public void testXmlMapper()
        throws Exception
    {
        String filePath = "/home/v2john/Documents/Veriday/11-articles-canaccord-REJECT.xml";

        List<Article> articles = XMLHelper.getObjects(filePath);

//        System.out.println(articles);

        Iterator iterator = articles.iterator();

        while (iterator.hasNext())
        {
            try
            {
                Article article = (Article) iterator.next();
                System.out.println(article.getValue());
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
