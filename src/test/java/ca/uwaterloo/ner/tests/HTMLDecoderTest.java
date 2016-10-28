package ca.uwaterloo.ner.tests;

import org.apache.commons.lang3.StringEscapeUtils;
import org.junit.Test;

public class HTMLDecoderTest
{
    @Test
    public void testDecodeHTML()
    {
        String text = "Our foremost goal is to enhance the quality of our clients&amp;#8217; lives. We zero-in on our clients&amp;#8217; goals and are disciplined and relentless in their pursuit. We apply our expertise to clients&amp;#8217; investment&amp;#160;objectives and portfolio design.&amp;#160; We are meticulous in portfolio implementation, oversight and maintenance while always remaining receptive to possible portfolio improvement.&amp;#160; Our portfolios incorporate time-tested investment strategies alongside modern techniques that take advantage of superior investment products and capabilities.&amp;#160; We invest intelligently with emphasis on stability and peace of mind, but also with attention to competitive returns and participation in economic growth. Focused clients benefit from unique, strategic investment ideas across a number of Canadian sectors including resources, health care, technology etc..., each carefully considered in the context of the current macro environment and industry cycles. We embrace change and ensure clients&amp;#8217; portfolios are dynamic enough to change, both with you and with the investment climate. Where appropriate, we employ Vertex 1 Asset Management, Picton Mahoney, Fulcra Capital and other industry leading alternative investment funds in our client&amp;apos;s portfolios. Their respective solid performance and innovative investment strategies help mitigate risk and enhance returns in all markets. However, portfolio management is only the beginning.&amp;#160; Our comprehensive financial planning capabilities ensure taxation, transfers, estate and trust issues are all taken into account.&amp;#160; The incremental value added through these vital considerations can have a significant impact on the ultimate realization of your financial goals. ~Randal van Eijnsbergen and his team&amp;#160;";
        String output = StringEscapeUtils.unescapeXml(StringEscapeUtils.unescapeXml(text));
        System.out.println(output);
    }
}
