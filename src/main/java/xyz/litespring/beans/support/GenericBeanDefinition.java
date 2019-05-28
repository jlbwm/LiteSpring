package xyz.litespring.beans.support;

import xyz.litespring.beans.BeanDefinition;

/**
 * Created by Jiaxin Li on 5/27/19.
 */
public class GenericBeanDefinition implements BeanDefinition {

    private String id;
    private String beanClassName;

    public GenericBeanDefinition(String id, String beanClassName) {
        this.id = id;
        this.beanClassName = beanClassName;
    }

    public String getBeanClassName() {
        return this.beanClassName;
    }
}
