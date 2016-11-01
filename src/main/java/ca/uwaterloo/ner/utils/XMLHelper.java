package ca.uwaterloo.ner.utils;

import ca.uwaterloo.ner.bean.Article;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class XMLHelper
{
    public static List<Article> getObjects(String xmlFilePath)
        throws IOException
    {
        List<Article> articles = null;

        File file = new File(xmlFilePath);
        XmlMapper xmlMapper = new XmlMapper();
        String xml = FileUtils.readFileToString(file, Charset.defaultCharset());
        articles = xmlMapper.readValue(xml, new TypeReference<ArrayList<Article>>(){});

        return articles;
    }
}
