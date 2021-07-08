import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author fwh
 * @email fuwenhao594@163.com
 * @date 2021/1/27 2:14 下午
 */
public class StringTest {
    /**
     * 输出：20210223133434000
     *
     * @param
     * @return void
     * @author fwh [2021/2/23 && 5:21 下午]
     */
    @Test
    public void dateTest() throws ParseException {
        String date01 = "2021-02-23 13:34:34.000.000";
        final String s = date01.replaceAll("-", "").replaceAll(":", "").replaceAll(" ", "");
        final String substring = s.substring(0, 14);
        System.out.println(substring + "000");
    }
    @Test
    public void splitTest(){
        String param="yz_bj_retai:test";
        String[] str = param.split(":");
        System.out.println(str[0]);
        System.out.println(str[1]);
    }
}
