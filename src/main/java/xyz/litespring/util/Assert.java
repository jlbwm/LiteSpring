package xyz.litespring.util;

/**
 * Created by Jiaxin Li on 6/5/19.
 */
public class Assert {

    public static void notNull(Object object, String msg) {
        if (object == null) {
            throw new IllegalArgumentException(msg);
        }
    }
}
