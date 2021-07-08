import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * @program: fwh-parent
 * @description:
 * @author: fwh
 * @date: 2021-07-02 17:28
 **/
public class DateTest {
    @Test
    public void getTime(){
        //获取时间戳- 1625217955
                    //1625218951
        long l = System.currentTimeMillis()/1000;
        System.out.println(l);
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        System.out.println(timeInMillis);
        System.out.println(new Date().getTime());

    }
}
