package club.fuwenhao.equals;

/**
 * @program: fwh-parent
 * @description: test
 * @author: fwh
 * @create: 2021-04-26 15:20
 **/
public class EqualsTest {
    public static void main(String[] args) {
        String test01 = "hello";
        String test02 = new String("hello");
        String test03 = test02;
        System.out.println(test01==test03);
        System.out.println(test01==test02);
        System.out.println(test02==test03);
        System.out.println(test01.equals(test02));
        System.out.println(test01.equals(test03));
        System.out.println(test02.equals(test03));
    }
}
