package club.fuwenhao.object;

/**
 * 多态测试
 * 多态存在的三个必要条件：
 * 继承
 * 重写
 * 父类引用指向子类对象：Parent p = new Child();
 * @Link <a href="https://www.runoob.com/java/java-polymorphism.html"/>
 *
 * @author fuwenhao
 * @return
 * @date 2021/4/26 2:51 下午
 */
public class ShapeTest {
    public static void main(String[] args) {
        Shape circle = new Circle();
        circle.draw();
        Shape square = new Square();
        square.draw();
    }
}
