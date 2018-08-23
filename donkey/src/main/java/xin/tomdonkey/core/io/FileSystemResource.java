package xin.tomdonkey.core.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;

public class FileSystemResource extends AbstractResource
{
    private final File file;

    public FileSystemResource (File file)
    {
        this.file = file;
    }

    @Override
    public boolean isFile()
    {
        return this.file.isFile();
    }

    @Override
    public URL getURL() throws IOException
    {
        return this.getURI().toURL();
    }

    @Override
    public URI getURI() throws IOException
    {
        return this.file.toURI();
    }

    @Override
    public File getFile() throws IOException
    {
        return this.file;
    }

    @Override
    public long lastModified() throws IOException
    {
        return file.lastModified();
    }

    @Override
    public String getFileName()
    {
        return this.file.getName();
    }

    @Override
    public String getDescription()
    {
        return "file [" + (this.file != null ? this.file.getAbsolutePath() : this.file.getAbsolutePath()) + "]";
    }

    @Override
    public Resource createRelative(String relativePath) throws IOException
    {
        return new FileSystemResource(new File(relativePath));
    }

    @Override
    public String toString()
    {
        return super.toString();
    }

    @Override
    public boolean exists()
    {
        return this.file.exists();
    }

    @Override
    public boolean isReadable()
    {
        return this.file.canRead();
    }


    @Override
    public long contentLength() throws IOException
    {
        return Files.size(this.file.toPath());
    }

    @Override
    public InputStream getInputStream() throws IOException
    {
        return new FileInputStream(file);
    }
}
