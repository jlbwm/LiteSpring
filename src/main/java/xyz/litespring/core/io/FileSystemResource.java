package xyz.litespring.core.io;


import xyz.litespring.util.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Jiaxin Li on 6/5/19.
 */
public class FileSystemResource implements Resource {

    private final String PATH;
    private final File FILE;

    public FileSystemResource(String path) {
        Assert.notNull(path, "path must not be null");
        this.FILE = new File(path);
        this.PATH = path;
    }


    public InputStream getInputStream() throws IOException {
        return new FileInputStream(this.FILE);
    }

    public String getDescription() {
        return "file: [" + this.FILE.getAbsolutePath() + "]";
    }
}
