package xyz.litespring.beans.factory;

import xyz.litespring.beans.BeansException;

/**
 * Created by Jiaxin Li on 5/27/19.
 */
public class BeanDefinitionStoreException extends BeansException{

    public BeanDefinitionStoreException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
