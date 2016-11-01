package ca.uwaterloo.ner.processors;


import ca.uwaterloo.ner.bean.Annotation;
import ca.uwaterloo.ner.bean.Article;
import ca.uwaterloo.ner.utils.IllinoisNERHelper;
import ca.uwaterloo.ner.utils.Options;
import ca.uwaterloo.ner.utils.XMLHelper;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.illinois.cs.cogcomp.core.datastructures.ViewNames;
import edu.illinois.cs.cogcomp.ner.NERAnnotator;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class IllinoisNERProcessor extends Processor
{
    private static Logger logger = LogManager.getLogger(IllinoisNERProcessor.class);
    private static ObjectMapper mapper = new ObjectMapper();

    public void process()
        throws Exception
    {
        logger.info("IllinoisNERProcessor Execution begun");

        List<Article> articles = XMLHelper.getObjects(Options.getInstance().getXmlFilePath());
        logger.info("There are a total of " + articles.size() + " articles to annotate");

        List<Article> annotatedArticles = annotateArticles(articles);

        String articlesJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(annotatedArticles);

        FileUtils.writeStringToFile(new File(Options.getInstance().getOutputFilePath()), articlesJson,
                                    Charset.defaultCharset());

        logger.info("IllinoisNERProcessor Execution complete");
    }

    private List<Article> annotateArticles(List<Article> articles)
        throws Exception
    {
        logger.info("Executing annotateArticles");

        Integer counter = 0;
        Integer docId;
        String articleText;

        NERAnnotator nerAnnotator = new NERAnnotator(ViewNames.NER_CONLL);
        nerAnnotator.doInitialize();

        Article annotatedArticle;
        List<Annotation> annotations;
        List<Article> annotatedArticles = new ArrayList<>();

        for (Article article: articles)
        {
            try
            {
                docId = counter++;
                logger.info("Working on article " + docId + ", articleID: " + article.getArticleid());

                articleText = StringEscapeUtils.unescapeXml(StringEscapeUtils.unescapeXml(article.getValue()));
                annotations = IllinoisNERHelper.tagDocument(articleText, "corpus-1", docId.toString(), nerAnnotator);

                if(null != annotations && annotations.size() > 0)
                {
                    annotatedArticle =
                        new Article(articleText, article.getTitle(), article.getComment(), article.getUserid(),
                                    article.getArticleid(), article.getVersion(), article.getDate(), annotations);
                    annotatedArticles.add(annotatedArticle);
                }
            }
            catch (Exception e)
            {
                logger.error("Skipping article " + article.getArticleid());
                logger.error(e);
            }
        }

        logger.info(annotatedArticles);
        logger.info("Finished annotateArticles");

        return annotatedArticles;
    }
}
