import club.fuwenhao.utils.DateUtil;
import club.fuwenhao.utils.Md5Util;
import org.junit.Test;

import java.util.Date;

/**
 * @author fwh
 * @email fuwenhao594@163.com
 * @date 2021/2/5 4:29 下午
 */
public class UtilsTest {
    @Test
    public void md5Test(){
        System.out.println(Md5Util.getMD5("test"));
    }

    @Test
    public void dateTest(){
        System.out.println(DateUtil.dateToISODate(new Date()));
    }
}
