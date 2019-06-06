package xyz.litespring.beans.support;

import xyz.litespring.beans.BeanDefinition;

/**
 * Created by Jiaxin Li on 6/5/19.
 */
public interface BeanDefinitionRegistry {

    BeanDefinition getBeanDefinition(String beanID);
    void registerBeanDefinition(String beanID, BeanDefinition bd);
}
