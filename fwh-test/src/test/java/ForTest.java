import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * 空集合取值正常
     *
     * @param
     * @return void
     * @author fwh [2021/1/28 && 5:36 下午]
     */
    @Test
    public void forTest() {
        List<String> stringList = new ArrayList<>();
//        stringList.add("zhangsan");
        for (String s : stringList) {
            System.out.println(s);
        }
        for (int i = 0; i < stringList.size(); i++) {
            System.out.println(stringList.get(i));
        }
    }
}
