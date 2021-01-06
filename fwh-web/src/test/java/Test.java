import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author fwh
 * @email fuwenhao594@163.com
 * @date 2020/6/5 4:06 下午
 */
public class Test {
    /**
     * 替换最后一个字符串
     *
     * @param args
     */
//    public static void main(String[] args) {
//        String url = "/visitant/toRegister/9CD9712EF6F04F08BF1769019790AD6F";
//        final String substring = url.substring(url.lastIndexOf("/") + 1);
//        final String replace = url.replace(substring, "*");
//        System.out.println(substring);
//        System.out.println(replace);
//    }

    /**
     * 循环遍历得到数值
     * @param args  
     * @return void  
     * @author fwh [2020/8/5 && 4:38 下午]
     */
    public static void main(String[] args) {
        //注意格式必须为1-5，不能为1-5-6
//        String test ="1-5,2-7";
//        String test ="1-2,6-7";
//        String test ="1-2,5-2";
//        String test ="5-7,8-4,3,9";
//        String test ="4-9,10-7";
        String test ="4-9,19-15";
        final String[] splitComma = test.split(",");
        Map<Integer,Boolean> resultMap = new HashMap<>();
        for (int i = 0; i < splitComma.length; i++) {
            final String[] splitBar = splitComma[i].split("-");
            if (splitBar.length==1) {
                if (!resultMap.containsKey(Integer.valueOf(splitBar[0]))) {
                    resultMap.put(Integer.valueOf(splitBar[0]),false);
                }
            }else{
                for (int j = 0; j < 1; j++) {
                    final int firstValue = Integer.valueOf(splitBar[0]);
                    final int secondValue = Integer.valueOf(splitBar[1]);
                    if (firstValue<secondValue){
                        //存值
                        for (int k = firstValue; k <= secondValue; k++) {
                            if (!resultMap.containsKey(k)) {
                                resultMap.put(k,false);
                            }
                        }
                    }else{
                        for (int k = firstValue; k >=secondValue ; k--) {
                            if (!resultMap.containsKey(k)) {
                                resultMap.put(k,false);
                            }
                        }
                    }
                }
            }
        }
        System.out.println(resultMap.toString());
        Map<Integer,Boolean> sortMap = Maps.newLinkedHashMap();
        resultMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEachOrdered(x->sortMap.put(x.getKey(),x.getValue()));
        System.out.println(sortMap.toString());
    }
}
