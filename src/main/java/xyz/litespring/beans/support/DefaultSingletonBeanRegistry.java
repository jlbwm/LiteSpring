package xyz.litespring.beans.support;

import xyz.litespring.beans.factory.config.SingletonBeanRegistry;
import xyz.litespring.util.Assert;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Jiaxin Li on 6/6/19.
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry{
    private final Map<String, Object> singletonObjects = new ConcurrentHashMap<String, Object>(64);

    public void registrySingleton(String beanName, Object singletonObject) {
        Assert.notNull(beanName, "'beanName' must not be null");

        Object oldObject = this.singletonObjects.get(beanName);

        if (oldObject != null) {
            throw new IllegalStateException("Could not register object [" + singletonObject + "] under bean name '"
            + beanName + "': there is already object [" + oldObject + "]");
        }
        this.singletonObjects.put(beanName, singletonObject);
    }

    public Object getSingleton(String beanName) {
        return this.singletonObjects.get(beanName);
    }
}
