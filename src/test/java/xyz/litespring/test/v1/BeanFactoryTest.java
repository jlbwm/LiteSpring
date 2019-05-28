package xyz.litespring.test.v1;

import org.junit.Assert;
import org.junit.Test;
import xyz.litespring.beans.BeanDefinition;
import xyz.litespring.beans.factory.BeanCreationException;
import xyz.litespring.beans.factory.BeanDefinitionStoreException;
import xyz.litespring.beans.factory.BeanFactory;
import xyz.litespring.beans.support.DefaultBeanFactory;
import xyz.litespring.service.v1.PetStoreService;

/**
 * Created by Jiaxin Li on 5/27/19.
 */
public class BeanFactoryTest {

    @Test
    public void testGetBean(){
        BeanFactory factory = new DefaultBeanFactory("petstore-ver1.xml");
        BeanDefinition bd = factory.getBeanDefinition("petStore");

        Assert.assertEquals("xyz.litespring.service.v1.PetStoreService", bd.getBeanClassName());

        PetStoreService petStore = (PetStoreService) factory.getBean("petStore");

        Assert.assertNotNull(petStore);

    }

    @Test
    public void testInvalidBean() {
        BeanFactory factory = new DefaultBeanFactory("petstore-ver1.xml");
        try {
            factory.getBean("invalidBean");
        }catch (BeanCreationException e) {
            return;
        }
        Assert.fail("expect BeanCreationException");
    }

    @Test
    public void testInvalidXML() {
        try {
            new DefaultBeanFactory("not_exist.xml");
        } catch(BeanDefinitionStoreException e) {
            return;
        }
        Assert.fail("expect BeanDefinitionStoreException");
    }
}
