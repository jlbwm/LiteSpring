package xyz.litespring.test.v1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import xyz.litespring.beans.BeanDefinition;
import xyz.litespring.beans.factory.BeanCreationException;
import xyz.litespring.beans.factory.BeanDefinitionStoreException;
import xyz.litespring.beans.factory.xml.XMLBeanDefinitionReader;
import xyz.litespring.beans.support.DefaultBeanFactory;
import xyz.litespring.core.io.ClassPathResource;
import xyz.litespring.service.v1.PetClinicService;
import xyz.litespring.service.v1.PetStoreService;

/**
 * Created by Jiaxin Li on 5/27/19.
 */
public class BeanFactoryTest {

    DefaultBeanFactory factory = null;
    XMLBeanDefinitionReader reader = null;

    @Before
    public void setup(){
        factory = new DefaultBeanFactory();
        reader = new XMLBeanDefinitionReader(factory);
    }

    @Test
    public void testGetBean(){

        reader.loadBeanDefinitions(new ClassPathResource("petstore-ver1.xml"));

        BeanDefinition bd = factory.getBeanDefinition("petStore");

        Assert.assertTrue(bd.isSingleton());
        Assert.assertFalse(bd.isPrototype());
        Assert.assertEquals(BeanDefinition.SCOPE_DEFAULT, bd.getScope());

        Assert.assertEquals("xyz.litespring.service.v1.PetStoreService", bd.getBeanClassName());

        PetStoreService petStore = (PetStoreService) factory.getBean("petStore");

        Assert.assertNotNull(petStore);

        PetStoreService petStore1 = (PetStoreService) factory.getBean("petStore");
        Assert.assertTrue(petStore.equals(petStore1));

    }

    @Test
    public void testPrototypeBean() {
        reader.loadBeanDefinitions(new ClassPathResource("petstore-ver1.xml"));
        BeanDefinition bd = factory.getBeanDefinition("petClinic");

        Assert.assertFalse(bd.isSingleton());
        Assert.assertTrue(bd.isPrototype());
        Assert.assertEquals("xyz.litespring.service.v1.PetClinicService", bd.getBeanClassName());

        PetClinicService petClinic = (PetClinicService) factory.getBean("petClinic");
        Assert.assertNotNull(petClinic);

        PetClinicService petClinic1 = (PetClinicService) factory.getBean("petClinic");
        Assert.assertFalse(petClinic.equals(petClinic1));

    }

    @Test
    public void testInvalidBean() {

        reader.loadBeanDefinitions(new ClassPathResource("petstore-ver1.xml"));

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

            reader.loadBeanDefinitions(new ClassPathResource("xxx.xml"));
        } catch(BeanDefinitionStoreException e) {
            return;
        }
        Assert.fail("expect BeanDefinitionStoreException");
    }
}
