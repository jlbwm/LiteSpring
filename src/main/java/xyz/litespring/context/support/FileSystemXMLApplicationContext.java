package xyz.litespring.context.support;

import xyz.litespring.core.io.FileSystemResource;
import xyz.litespring.core.io.Resource;

/**
 * Created by Jiaxin Li on 6/5/19.
 */
public class FileSystemXMLApplicationContext extends AbstractApplicationContext {

    public FileSystemXMLApplicationContext(String configFile) {
        super(configFile);
    }

    protected Resource getResourcePath(String configFile) {
        return new FileSystemResource(configFile);
    }
}
