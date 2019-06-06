package xyz.litespring.beans.factory.config;

import xyz.litespring.beans.factory.BeanFactory;

/**
 * Created by Jiaxin Li on 6/5/19.
 */
public interface ConfigurableBeanFactory extends BeanFactory {

    void setBeanClassLoader(ClassLoader beanClassLoader);
    ClassLoader getBeanClassLoader();
}
