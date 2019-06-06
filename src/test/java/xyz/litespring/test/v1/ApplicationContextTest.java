package xyz.litespring.test.v1;

import org.junit.Assert;
import org.junit.Test;
import xyz.litespring.context.ApplicationContext;
import xyz.litespring.context.support.FileSystemXMLApplicationContext;
import xyz.litespring.context.support.ClassPathXMLApplicationContext;
import xyz.litespring.service.v1.PetStoreService;

/**
 * Created by Jiaxin Li on 6/5/19.
 */
public class ApplicationContextTest {

    @Test
    public void testGetBean() {
        ApplicationContext ctx = new ClassPathXMLApplicationContext("petstore-ver1.xml");

        PetStoreService petStore = (PetStoreService) ctx.getBean("petStore");
        Assert.assertNotNull(petStore);
    }

    @Test
    public void testGetBeanFromFileSystemContext() {
        ApplicationContext ctx = new FileSystemXMLApplicationContext("/Users/apple/LiteSpring/src/test/resources/petstore-ver1.xml");
        PetStoreService petStore = (PetStoreService) ctx.getBean("petStore");
        Assert.assertNotNull(petStore);
    }
}
