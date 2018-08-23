package xin.tomdonkey.spring.resource;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 测试Spring的ClassPathResource
 */
public class ClassPathResourceTest
{
    @Test
    public void testConstructor()
    {
        //采用此种构造方式构造，使用默认的classloader构造，和resource2一致，使用AppClassLoader
        Resource resource0 = new ClassPathResource("SpringConfig.xml");
        //采用类的.getClass().getResource()取目录，不写/拿到的是类所在的目录,即包目录
        Resource resource1x = new ClassPathResource("SpringConfig.xml",ClassPathResourceTest.class);
        Resource resource1xx = new ClassPathResource("SpringConfig.xml",String.class);
        Resource resource1 = new ClassPathResource("SpringConfig.xml", ClassPathResourceTest.class);
        Resource resource2 = new ClassPathResource("SpringConfig.xml", ClassPathResourceTest.class.getClassLoader());

        //ClassLoader不支持/取到根目录，因为ClassLoader就在根目录上，spring会自动把/去掉防止出错
        Resource resource01 = new ClassPathResource("/SpringConfig.xml");
        //使用class加载路径时，使用根目录会定位到包的起始位置，即classloader的默认位置
        Resource resource11 = new ClassPathResource("/SpringConfig.xml", ClassPathResourceTest.class);
        Resource resource21 = new ClassPathResource("/SpringConfig.xml", ClassPathResourceTest.class.getClassLoader());

        printInfo(resource0);
        printInfo(resource1x);
        printInfo(resource1xx);
        printInfo(resource1);
        printInfo(resource2);

        printInfo(resource01);
        printInfo(resource11);
        printInfo(resource21);
    }

    private void printInfo(Resource resource)
    {
        System.out.println(resource.exists() + "---" + resource.getDescription());
    }
}
