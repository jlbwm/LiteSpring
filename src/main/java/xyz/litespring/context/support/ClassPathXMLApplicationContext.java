package xyz.litespring.context.support;

import xyz.litespring.core.io.ClassPathResource;
import xyz.litespring.core.io.Resource;

/**
 * Created by Jiaxin Li on 6/5/19.
 */
public class ClassPathXMLApplicationContext extends AbstractApplicationContext {

    public ClassPathXMLApplicationContext(String configFile) {
        super(configFile);
    }

    protected Resource getResourcePath(String configFile) {
        return new ClassPathResource(configFile, this.getBeanClassLoader());
    }
}
