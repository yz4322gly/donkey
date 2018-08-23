package xin.tomdonkey.core.io;

import java.io.*;
import java.util.Arrays;

public class ByteArrayResource extends AbstractResource
{
    private final byte[] bytes;
    private final String description;

    public ByteArrayResource(byte[] bytes)
    {
        this.bytes = bytes;
        this.description = "this is a ByteArrayResource";
    }

    public ByteArrayResource(byte[] bytes,String description)
    {
        this.bytes = bytes;
        this.description = "this byteArrayResource is" + description;
    }

    public final byte[] getByteArray()
    {
        return this.bytes;
    }

    @Override
    public InputStream getInputStream()
    {
        return new ByteArrayInputStream(this.bytes);
    }

    @Override
    public boolean exists()
    {
        return true;
    }

    @Override
    public long contentLength() throws IOException
    {
        return this.bytes.length;
    }

    @Override
    public String getDescription()
    {
        return description;
    }


    @Override
    public int hashCode()
    {
        return Arrays.hashCode(bytes);
    }
}
