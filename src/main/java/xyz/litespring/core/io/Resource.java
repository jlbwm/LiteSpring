package xyz.litespring.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Jiaxin Li on 6/5/19.
 */
public interface Resource {

    public InputStream getInputStream() throws IOException;

    public String getDescription();
}
