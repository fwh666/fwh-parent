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
    public static void main(String[] args) {
        String url = "/visitant/toRegister/9CD9712EF6F04F08BF1769019790AD6F";
        final String substring = url.substring(url.lastIndexOf("/") + 1);
        final String replace = url.replace(substring, "*");
        System.out.println(substring);
        System.out.println(replace);
    }
}
