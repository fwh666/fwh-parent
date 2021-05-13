import org.junit.Test;

import java.util.Arrays;

/**
 * @program: fwh-parent
 * @description: 排序demos
 * @author: fwh
 * @date: 2021-05-13 15:08
 **/
public class SortTest {
    /**
     * 冒泡排序
     * 掌握算法-需要明白其原理。转换成图形理解算法步骤。图解网址：http://tools.jb51.net/aideddesign/paixu_ys
     * <p>
     * 概述：第一个数和第二个进行对比。大的数放在后面。 最后两个数不用遍历，直接对比。
     * 实现: 第一层循环n-1个，第二层循环n-i-1个。比较第一个和第二个值，进行交换。 最后输出数组下标值
     * <p>
     * 参考网址：https://www.cnblogs.com/xiaoming0601/p/5866048.html
     * https://blog.csdn.net/FRMNZR/article/details/90544380
     * https://blog.csdn.net/qq_40709468/article/details/103962404
     * https://www.cnblogs.com/shen-hua/p/5422676.html
     *
     * @return void
     * @author fuwenhao
     * @date 2021/5/13 3:34 下午
     */
    @Test
    public void bubblingSortTest() {
        int[] demos = {1, 5, 3, 4, 2};
        int temp;
        for (int i = 0; i < demos.length - 1; i++) {
            for (int j = 1; j < demos.length - i - 1; j++) {
                if (demos[j] > demos[j + 1]) {
                    temp = demos[j];
                    demos[j] = demos[j + 1];
                    demos[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(demos));
    }

    /**
     * 冒泡优化算
     * <p>
     * 1.整个数列分成两部分：前面是无序数列，后面是有序数列。
     * 2.初始状态下，整个数列都是无序的，有序数列是空。
     * 3.每一趟循环可以让无序数列中最大数排到最后，(也就是说有序数列的元素个数增加1)，也就是不用再去顾及有序序列。
     * 4.每一趟循环都从数列的第一个元素开始进行比较，依次比较相邻的两个元素，比较到无序数列的末尾即可(而不是数列的末尾);如果前一个大于后一个，交换。
     * 5.判断每一趟是否发生了数组元素的交换，如果没有发生，则说明此时数组已经有序，无需再进行后续趟数的比较了。此时可以中止比较。
     *
     * @return
     * @author fuwenhao
     * @date 2021/5/13 3:48 下午
     */
    @Test
    public void bubbleSort() {
        int values[] = new int[]{1, 6, 2, 2, 5};
        int temp;
        int i;
        // 外层循环：n个元素排序，则至多需要n-1趟循环
        for (i = 0; i < values.length - 1; i++) {
            // 定义一个布尔类型的变量，标记数组是否已达到有序状态
            boolean flag = true;
            /*内层循环：每一趟循环都从数列的前两个元素开始进行比较，比较到无序数组的最后*/
            for (int j = 0; j < values.length - 1 - i; j++) {
                // 如果前一个元素大于后一个元素，则交换两元素的值；
                if (values[j] > values[j + 1]) {
                    temp = values[j];
                    values[j] = values[j + 1];
                    values[j + 1] = temp;
                    //本趟发生了交换，表明该数组在本趟处于无序状态，需要继续比较；
//                    即本躺只要发生了一次交换，就false
                    flag = false;
                }
            }
            //根据标记量的值判断数组是否有序，如果有序，则退出；无序，则继续循环。
            if (flag) {
                break;
            }
        }
        System.out.println(Arrays.toString(values));
    }
}
