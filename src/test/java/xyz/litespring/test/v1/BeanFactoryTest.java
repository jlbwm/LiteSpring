package xyz.litespring.test.v1;

import org.junit.Assert;
import org.junit.Test;
import xyz.litespring.beans.BeanDefinition;
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
}
