package xin.tomdonkey.sax;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.*;
import java.io.IOException;

public class Demo01
{
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException
    {
        InputSource inputSource = new InputSource(new ClassPathResource("SpringConfig.xml").getInputStream());

//        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
//        SAXParser saxParser = saxParserFactory.newSAXParser();
//        saxParser.parse(inputSource,new DefaultHandler());

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document= builder.parse(inputSource);

        System.out.println(document.getDocumentElement().getAttributes());
    }
}
