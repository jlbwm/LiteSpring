package xyz.litespring.beans.support;

import xyz.litespring.beans.BeanDefinition;

/**
 * Created by Jiaxin Li on 5/27/19.
 */
public class GenericBeanDefinition implements BeanDefinition {

    private String id;
    private String beanClassName;

    private Boolean singleton = true;
    private Boolean prototype = false;
    private String scope = SCOPE_DEFAULT;

    public GenericBeanDefinition(String id, String beanClassName) {
        this.id = id;
        this.beanClassName = beanClassName;
    }

    public String getBeanClassName() {
        return this.beanClassName;
    }

    public boolean isSingleton() {
        return this.singleton;
    }

    public boolean isPrototype() {
        return this.prototype;
    }

    public void setScope(String scope) {
        this.scope = scope;
        this.singleton = SCOPE_SINGLETON.equals(scope) || SCOPE_DEFAULT.equals(scope);
        this.prototype = SCOPE_PROTOTYPE.equals(scope);
    }

    public String getScope() {
        return this.scope;
    }
}
