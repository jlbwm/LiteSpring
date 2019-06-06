package xyz.litespring.test.v1;

import org.junit.Assert;
import org.junit.Test;
import xyz.litespring.core.io.ClassPathResource;
import xyz.litespring.core.io.FileSystemResource;
import xyz.litespring.core.io.Resource;

import java.io.InputStream;

/**
 * Created by Jiaxin Li on 6/5/19.
 */
public class ResourceTest {

    @Test
    public void testClassPathResource() throws Exception {
        Resource r = new ClassPathResource("petstore-ver1.xml");
        InputStream is = null;

        try {
            is = r.getInputStream();
            Assert.assertNotNull(is);
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }

    @Test
    public void testFileSystemResource() throws Exception {
        Resource r = new FileSystemResource("/Users/apple/LiteSpring/src/test/resources/petstore-ver1.xml");
        InputStream is = null;

        try {
            is = r.getInputStream();
            Assert.assertNotNull(is);
        } finally {
            if (is != null) {
                is.close();
            }
        }

    }
}
