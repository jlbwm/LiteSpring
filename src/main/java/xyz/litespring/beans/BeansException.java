package xyz.litespring.beans;

/**
 * Created by Jiaxin Li on 5/27/19.
 */
public class BeansException extends RuntimeException{
    public BeansException(String msg) {
        super(msg);
    }
    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
