package xyz.litespring.context.support;

import xyz.litespring.beans.factory.xml.XMLBeanDefinitionReader;
import xyz.litespring.beans.support.DefaultBeanFactory;
import xyz.litespring.context.ApplicationContext;
import xyz.litespring.core.io.Resource;
import xyz.litespring.util.ClassUtils;

/**
 * Created by Jiaxin Li on 6/5/19.
 */
public abstract class AbstractApplicationContext implements ApplicationContext{
    private DefaultBeanFactory factory = null;
    private ClassLoader beanClassLoader;

    public AbstractApplicationContext(String configFile) {

        factory = new DefaultBeanFactory();
        XMLBeanDefinitionReader reader = new XMLBeanDefinitionReader(factory);
        Resource resource = this.getResourcePath(configFile);
        reader.loadBeanDefinitions(resource);
        factory.setBeanClassLoader(this.getBeanClassLoader());
    }

    protected abstract Resource getResourcePath(String configFile);

    public Object getBean(String beanID) {
        return factory.getBean(beanID);
    }

    public ClassLoader getBeanClassLoader() {
        return this.beanClassLoader != null ? this.beanClassLoader : ClassUtils.getDefaultClassLoader();
    }

    public void setBeanClassLoader(ClassLoader beanClassLoader) {
        this.beanClassLoader = beanClassLoader;
    }
}
