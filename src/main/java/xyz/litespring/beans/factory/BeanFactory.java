package xyz.litespring.beans.factory;

import xyz.litespring.beans.BeanDefinition;

/**
 * Created by Jiaxin Li on 5/27/19.
 */
public interface BeanFactory {

//    BeanDefinition getBeanDefinition(String beanID);

    Object getBean(String beanID);
}
