package xyz.litespring.beans.factory.config;

/**
 * Created by Jiaxin Li on 6/6/19.
 */
public interface SingletonBeanRegistry {

    void registrySingleton(String beanName, Object singletonObject);

    Object getSingleton(String beanName);

}
