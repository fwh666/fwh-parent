import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 * @program: fwh-parent
 * @description: JSON对象转换
 * @author: fwh
 * @date: 2021-07-26 10:19
 **/
public class JSONTest {
    /**
     * "templateVariable": "[{\"name\":\"name\",\"value\":\"啊哈力\"},{\"name\":\"time\",\"value\":\"2020-10-20 20:22:22\"},{\"name\":\"Membership grade\",\"value\":\"铂金\"}]",
     *
     * @param
     * @return void
     * @author fuwenhao
     * @date 2021/7/26 10:20 上午
     */
    @Test
    public void arrayTest() {
        String title = "【企业每日更新】;【酒店每日更新】;【酒店每周更新】;";
        JSONObject values = new JSONObject();
        values.put("value",title);
        String[] templateVariable = new String[]{JSONObject.toJSONString(values)};
        String s = JSONObject.toJSONString(templateVariable);
        System.out.println(s);
        System.out.println(JSONObject.toJSONString(templateVariable.toString()));
    }
}
