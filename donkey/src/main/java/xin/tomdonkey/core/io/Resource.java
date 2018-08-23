package xin.tomdonkey.core.io;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public interface Resource extends InputStreamResources
{
    boolean exists();

    default boolean isReadable()
    {
        return exists();
    }

    default boolean isFile()
    {
        return false;
    }

    default boolean isOpen()
    {
        return false;
    }

    URL getURL() throws IOException;

    URI getURI() throws IOException;

    File getFile() throws IOException;

    default ReadableByteChannel readableChannel() throws IOException
    {
        return Channels.newChannel(getInputStream());
    }

    long contentLength() throws IOException;

    long lastModified() throws IOException;

    Resource createRelative(String relativePath) throws IOException;

    String getFileName();

    String getDescription();

}
