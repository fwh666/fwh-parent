package club.fuwenhao.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @program: spring-demo
 * @description: test
 * Book Initializing
 * setBookName: Book name has set.
 * Book.setBeanName invoke
 * Book.setBeanFactory invoke
 * Book.setApplicationContext invoke
 * MyBeanPostProcessor.postProcessBeforeInitialization
 * @PostConstruct Book.afterPropertiesSet invoke
 * Book.myPostConstruct invoke
 * MyBeanPostProcessor.postProcessAfterInitialization
 * Book name = thingking in java
 * 16:53:23.234 [main] DEBUG org.springframework.context.support.ClassPathXmlApplicationContext - Closing org.springframework.context.support.ClassPathXmlApplicationContext@710726a3, started on Wed Jun 02 16:53:22 CST 2021
 * @PreDestory Book.destory invoke
 * Book.myPreDestory invoke
 * @author: fwh
 * @date: 2021-06-02 16:43
 **/
public class Book implements BeanNameAware,
        BeanFactoryAware,
        ApplicationContextAware,
        InitializingBean,
        DisposableBean {

    private String bookName;

    public Book() {
        System.out.println("Book Initializing ");
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
        System.out.println("setBookName: Book name has set.");
    }

    public void setBeanName(String name) {
        System.out.println("Book.setBeanName invoke");
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("Book.setBeanFactory invoke");
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Book.setApplicationContext invoke");
    }
    //调用postProcessBeforeInitialization

    // 自定义初始化方法
    @PostConstruct
    public void springPostConstruct() {
        System.out.println("@PostConstruct");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("Book.afterPropertiesSet invoke");
    }

    public void myPostConstruct() {
        System.out.println("Book.myPostConstruct invoke");
    }

    // 自定义销毁方法
    @PreDestroy
    public void springPreDestory() {
        System.out.println("@PreDestory");
    }


    public void destroy() throws Exception {
        System.out.println("Book.destory invoke");
    }
    public void myPreDestory() {
        System.out.println("Book.myPreDestory invoke");
        System.out.println("---------------destroy-----------------");
    }






    public String getBookName() {
        return bookName;
    }



    @Override
    protected void finalize() throws Throwable {
        System.out.println("------inside finalize-----");
    }
}