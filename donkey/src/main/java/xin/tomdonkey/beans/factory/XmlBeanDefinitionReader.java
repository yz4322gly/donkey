package xin.tomdonkey.beans.factory;

import org.w3c.dom.Document;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import xin.tomdonkey.core.io.FileSystemResource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XmlBeanDefinitionReader
{
    private Document doLoadDocument() throws ParserConfigurationException, IOException, SAXException
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        factory.setValidating(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        builder.setEntityResolver((publicId, systemId) -> new InputSource(new FileSystemResource(new File("C:\\java\\projects\\git\\donkey\\donkey\\src\\main\\resources\\xsd\\donkey-beans.xsd")).getInputStream()));
        Document document = builder.parse(new InputSource(new FileSystemResource(new File("C:\\java\\projects\\git\\donkey\\donkey\\src\\main\\resources\\donkey-config.xml")).getInputStream()));
        System.out.println(document.getDocumentElement());
        return document;
    }

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException
    {
        System.out.println(XmlBeanDefinitionReader.class.getClassLoader().getResource("").getPath());
    }
}
