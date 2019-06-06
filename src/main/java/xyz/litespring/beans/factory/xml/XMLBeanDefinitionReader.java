package xyz.litespring.beans.factory.xml;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import xyz.litespring.beans.BeanDefinition;
import xyz.litespring.beans.factory.BeanDefinitionStoreException;
import xyz.litespring.beans.support.BeanDefinitionRegistry;
import xyz.litespring.beans.support.GenericBeanDefinition;
import xyz.litespring.core.io.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

/**
 * Created by Jiaxin Li on 6/5/19.
 * 负责解析XML并将所有的Bean存储到register中
 */
public class XMLBeanDefinitionReader {
    public static final String ID_ATTRIBUTE = "id";
    public static final String CLASS_ATTRIBUTE = "class";
    public static final String SCOPE_ATTRIBUTE = "scope";

    BeanDefinitionRegistry registry;

    public XMLBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }


    public void loadBeanDefinitions(Resource resource) {
        InputStream is = null;

        try {
            is = resource.getInputStream();

            SAXReader reader = new SAXReader();
            Document doc = reader.read(is);

            Element root = doc.getRootElement(); // <beans>
            Iterator<Element> iter = root.elementIterator();

            while(iter.hasNext()) {
                Element ele = (Element) iter.next();

                String id = ele.attributeValue(ID_ATTRIBUTE);
                String beanClassName = ele.attributeValue(CLASS_ATTRIBUTE);

                BeanDefinition bd = new GenericBeanDefinition(id, beanClassName);

                if (ele.attribute(SCOPE_ATTRIBUTE) != null) {
                    bd.setScope(ele.attributeValue(SCOPE_ATTRIBUTE));
                }
                this.registry.registerBeanDefinition(id, bd);
            }

        } catch (Exception e) {
            throw new BeanDefinitionStoreException("IOException parsing XML document from " + resource.getDescription(), e);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
