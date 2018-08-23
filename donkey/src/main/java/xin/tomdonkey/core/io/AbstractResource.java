package xin.tomdonkey.core.io;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URL;

public abstract class AbstractResource implements Resource
{

    @Override
    public boolean isFile()
    {
        return false;
    }

    @Override
    public boolean isOpen()
    {
        return false;
    }

    @Override
    public URL getURL() throws IOException
    {
        throw new FileNotFoundException();
    }

    @Override
    public URI getURI() throws IOException
    {
        throw new FileNotFoundException();
    }

    @Override
    public File getFile() throws IOException
    {
        throw new FileNotFoundException();
    }

    @Override
    public long lastModified() throws IOException
    {
        if (getFile().lastModified() != 0L)
            return getFile().lastModified();
        else
            return 0L;
    }

    @Override
    public String getFileName()
    {
        return null;
    }

    @Override
    public Resource createRelative(String relativePath) throws IOException {
        throw new FileNotFoundException("Cannot create a relative resource for " + getDescription());
    }

    @Override
    public String toString()
    {
        return getDescription();
    }
}
