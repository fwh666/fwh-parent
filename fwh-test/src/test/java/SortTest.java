import club.fuwenhao.utils.DistanceAlgorithmUtils;
import lombok.Data;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @program: fwh-parent
 * @description: 排序测试
 * @author: fwh
 * @date: 2021-09-22 12:01
 **/
public class SortTest {
    @Test
    public void listSort() {
        ArrayList<String> list = new ArrayList<>();
        list.add("10分钟前");
        list.add("15分钟前");
        list.add("1分钟前");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void personSort() {
        ArrayList<Person> list = new ArrayList<Person>();
        Person person = new Person();
        person.setTime("10分钟前");
        person.setAge(10);
        list.add(person);

        Person person1 = new Person();
        person1.setTime("15分钟前");
        person1.setAge(15);
        list.add(person1);

        Person person2 = new Person();
        person2.setTime("1分钟前");
        person2.setAge(1);
        list.add(person2);
        //java8-排序
        List<Person> collect = list.stream().sorted(Comparator.comparing(Person::getAge)).collect(Collectors.toList());
        //输出
        collect.forEach(per -> {
            System.out.println(per.getTime());
        });

        //年龄排序
        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
//                int i = o1.getTime().compareTo(o2.getTime());
                int i = o1.getAge().compareTo(o2.getAge());
                return i;
            }
        });


        //输出
        Iterator<Person> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
//        //输出
//        list.forEach(per->{
//            System.out.println(per.getTime());
//        });
    }

    /**
     * 时间处理-几分钟前
     */
    @Test
    public void timeTest() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        Date date = new Date("2021-10-11 11:11:11");
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        String distanceAlgorithm = DistanceAlgorithmUtils.getDistanceAlgorithm(instant.atZone(zoneId).toLocalDateTime());
        System.out.println(distanceAlgorithm);
    }

    @Data
    class Person {
        private String time;
        private Integer age;
    }
}
