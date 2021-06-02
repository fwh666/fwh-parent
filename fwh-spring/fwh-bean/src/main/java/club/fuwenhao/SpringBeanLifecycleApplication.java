package club.fuwenhao;

import club.fuwenhao.bean.Book;
import club.fuwenhao.bean.SubBookClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: spring-demo
 * @description: test
 * @author: fwh
 * @date: 2021-06-02 16:46
 **/
public class SpringBeanLifecycleApplication {
    //    public static void main(String[] args) throws InterruptedException {
//        // 为面试而准备的Bean生命周期加载过程
//        ApplicationContext context = new ClassPathXmlApplicationContext("Bean-Lifecycle.xml");
//        Book book = (Book)context.getBean("book");
//        System.out.println("Book name = " + book.getBookName());
//        ((ClassPathXmlApplicationContext) context).destroy();
//    }
    public static void main(String[] args) throws InterruptedException {
        // 为面试而准备的Bean生命周期加载过程
        ApplicationContext context = new ClassPathXmlApplicationContext("Bean-Lifecycle.xml");
        Book book = (Book) context.getBean("book");
        System.out.println("Book name = " + book.getBookName());
        ((ClassPathXmlApplicationContext) context).destroy();

        // 完整的加载过程，当然了解的越多越好
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("SubBean-Lifecycle.xml");
        SubBookClass subBookClass = (SubBookClass) applicationContext.getBean("bookClass");
        System.out.println("BookSystemName = " + subBookClass.getBookSystem());
        ((ClassPathXmlApplicationContext) applicationContext).registerShutdownHook();
    }
}
