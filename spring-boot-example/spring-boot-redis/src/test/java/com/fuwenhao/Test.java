package com.fuwenhao;

import org.springframework.util.Base64Utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * @ClassName Test
 * @Description TODO
 * @Author fwh
 * @Date 2020/1/15 10:22
 * @Version 1.0
 */
public class Test {
    //    public static void main(String[] args) {
//        Map<Integer,String> resultMap = new HashMap<>(1);
//        resultMap.put(2,"2");
//        resultMap.put(3,"3");
//        resultMap.put(1,"1");
//        System.out.println(resultMap);
//    }
//    public static void main(String[] args) {
//        //密文密码
//        try {
//            String miwen2 = "ZTEwYWRjMzk0OWJhNTlhYmJlNTZlMDU3ZjIwZjg4M2U=";
////            String password = "123456";
//            MessageDigest md5 = MessageDigest.getInstance("MD5");
//            byte[] digest = md5.digest(miwen2.getBytes());
//            String s = Base64Utils.encodeToString(digest);
//            System.out.println("密文:" + s);
//            String miwen = "4QrcOUm6Wau+VuBX8g+IPg==";
////            byte[] bytes = Base64Utils.decodeFromString(miwen);
////            if (Arrays.equals(digest, bytes)) {
////                System.out.println("ok");
////            }
////            String miwen2 = "WLxVE3rYVCJUa3ADPie40g==";
//            byte[] bytes2 = Base64Utils.decodeFromString(miwen2);
//            if (Arrays.equals(digest, bytes2)) {
//                System.out.println("ok");
//            }else{
//                System.out.println("erroe");
//            }
//
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
//
//    }

    /**
     * 索引排序
     * @param args
     */
    public static void main(String[] args) {
        String deptCode = "056-67";
        String substring = null;
        if (deptCode.contains("-")) {
            substring = deptCode.substring(deptCode.lastIndexOf("-")+1);
        } else {
            substring = deptCode.substring(deptCode.indexOf('0')+1);
        }
        System.out.println(substring);
    }

    /**
     * lambda表达式
     */
    @org.junit.Test
    public void test01(){
        List<Integer> lists1 = new ArrayList<>();
        List<Integer> lists2 = new ArrayList<>();
        lists1.add(1);
        lists1.add(2);
        lists1.add(3);
        lists1.forEach(lists2::add);
        System.out.println(lists2);
    }
}
