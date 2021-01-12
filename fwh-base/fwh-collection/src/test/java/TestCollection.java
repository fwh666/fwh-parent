import org.junit.Test;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.*;

/**
 * @author fwh
 * @email fuwenhao594@163.com
 * @date 2021/1/11 5:29 下午
 */
public class TestCollection {
    /**
     * linkedHashMap
     *
     * @param
     * @return void
     * @author fwh [2021/1/11 && 5:42 下午]
     */
    @Test
    public void linkedHashMapTest() {
        System.out.println("*************************LinkedHashMap*************");
        Map<Integer, String> map = new LinkedHashMap<Integer, String>();
        map.put(1, "apple");
        map.put(2, "banana");
        map.put(3, "pear");
        final Iterator<Integer> iterator = map.keySet().iterator();
        for (Iterator it = iterator; it.hasNext(); ) {
            Object key = it.next();
            System.out.println(key + "=" + map.get(key));
        }
        map.forEach((key, value) -> {
            System.out.println(key + "=" + value);
        });

        //LinkedHashMap
        System.out.println("--LinkedHashMap根据输入的顺序输出--");
        LinkedHashMap lhsMap = new LinkedHashMap();
        lhsMap.put("3", "Value3");
        lhsMap.put("1", "Value1");
        lhsMap.put("2", "Value2");
        lhsMap.put("b", "ValueB");
        lhsMap.put("a", "ValueA");
        Iterator lit = lhsMap.entrySet().iterator();
        while (lit.hasNext()) {
            Map.Entry e = (Map.Entry) lit.next();
            System.out.println("Key: " + e.getKey() + "--Value: " + e.getValue());
        }

    }

    /**
     * HashMap
     *
     * @param
     * @return void
     * @author fwh [2021/1/11 && 5:44 下午]
     */
    @Test
    public void hashMap() {
        System.out.println("*************************HashMap*************");
        Map<Integer, String> map1 = new HashMap<Integer, String>();
        map1.put(1, "apple");
        map1.put(2, "banana");
        map1.put(3, "pear");
        for (Iterator it = map1.keySet().iterator(); it.hasNext(); ) {
            Object key = it.next();
            System.out.println(key + "=" + map1.get(key));
        }
        //HashMap
        System.out.println("------HashMap无序输出------");
        HashMap hsMap = new HashMap();
        hsMap.put("3", "Value3");
        hsMap.put("1", "Value1");
        hsMap.put("2", "Value2");
        hsMap.put("b", "ValueB");
        hsMap.put("a", "ValueA");
        Iterator it = hsMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry) it.next();
            System.out.println("Key: " + e.getKey() + "--Value: " + e.getValue());
        }
    }

    /**
     * treeMap
     *
     * @param
     * @return void
     * @author fwh [2021/1/11 && 5:50 下午]
     */
    @Test
    public void treeMap() {
        System.out.println("------TreeMap按Key排序输出------");
        TreeMap teMap = new TreeMap();
        teMap.put("3", "Value3");
        teMap.put("1", "Value1");
        teMap.put("2", "Value2");
        teMap.put("b", "ValueB");
        teMap.put("a", "ValueA");
        Iterator tit = teMap.entrySet().iterator();
        while (tit.hasNext()) {
            Map.Entry e = (Map.Entry) tit.next();
            System.out.println("Key: " + e.getKey() + "--Value: " + e.getValue());
        }
    }

    /**
     * list
     *
     * @param
     * @return void
     * @author fwh [2021/1/11 && 5:59 下午]
     */
    @Test
    public void list() {
        List<String> listWithDup = new ArrayList<String>();
        listWithDup.add("1");
        listWithDup.add("2");
        listWithDup.add("3");
        listWithDup.add("1");
        List<String> listWithoutDup = new ArrayList<String>(new HashSet<String>(listWithDup));
        List<String> lists = new ArrayList<String>(new HashSet<String>(listWithDup));
        System.out.println("list with dup:" + listWithDup);
        System.out.println("list without dup:" + listWithoutDup);
        List list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("a");
        list.add("b");
        list.add("2");
        list.add("b");
        List list1 = removeDuplicate(list);
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i));
        }
    }

    //去重
    private static List removeDuplicate(List list) {
        Set set = new HashSet();
        List newList = new ArrayList();
        for (Iterator iter = list.iterator(); iter.hasNext(); ) {
            Object element = iter.next();
            if (set.add(element)) {
                newList.add(element);
            }
        }
        return newList;
    }

    /**
     * 弱引用
     *
     * @param
     * @return void
     * @author fwh [2021/1/11 && 5:59 下午]
     */
    @Test
    public void softReference() {
        //弱引用.
        SoftReference<String> sr = new SoftReference<String>(new String("hello"));
        System.out.println("sr:" + sr.get());
        System.gc();
        System.out.println("sr2:" + sr.get());
    }

    /**
     * 软引用
     *
     * @param
     * @return void
     * @author fwh [2021/1/11 && 6:01 下午]
     */
    @Test
    public void weakReference() {
        //软引用
        WeakReference<String> wr = new WeakReference<String>(new String("hello"));
        System.out.println("wr:" + wr.get());
        System.gc();
        System.out.println("wr2:" + wr.get());
    }
}
