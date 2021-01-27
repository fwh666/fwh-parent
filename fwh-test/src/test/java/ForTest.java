import org.junit.Test;

/**
 * @author fwh
 * @email fuwenhao594@163.com
 * @date 2021/1/27 2:14 下午
 */
public class ForTest {
    @Test
    public void switchTest() {
        final String s = switchBean(1);
        System.out.println("结果：" + s);
    }

    /**
     * switch要么用return或者break，不能同时使用
     *
     * @param type
     * @return java.lang.String
     * @author fwh [2021/1/27 && 2:19 下午]
     */
    public String switchBean(int type) {
        switch (type) {
            case 1:
                System.out.println(1);
//                break;
                return "1";
            case 2:
                System.out.println(2);
//                break;
                return "2";
            default:
//                break;
                return "0";
        }
//        return "0";
    }
}
