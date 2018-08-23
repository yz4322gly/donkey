package xin.tomdonkey.core.io;

import org.junit.Test;

public class ByteArrayResourceTest
{
    @Test
    public void test()
    {
        byte[] bytes = {12,31,14,23,33};
        Resource resource = new ByteArrayResource(bytes);
    }

}