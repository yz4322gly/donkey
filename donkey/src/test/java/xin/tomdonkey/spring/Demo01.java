package xin.tomdonkey.spring;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class Demo01
{
    @Test
    public void testSimpleLoad()
    {
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("SpringConfig.xml"));
        System.out.println(beanFactory.getBean("si"));
    }
}
