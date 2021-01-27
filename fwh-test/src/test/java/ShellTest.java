import lombok.extern.slf4j.Slf4j;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author fwh
 * @email fuwenhao594@163.com
 * @date 2021/1/5 4:08 下午
 */
@Slf4j
public class ShellTest {
    /**
     * 获取根目录路径和pom文件版本
     *
     * @param
     * @return void
     * @author fwh [2021/1/12 && 12:08 下午]
     */
    @org.junit.Test
    public void resourceTest() throws IOException, XmlPullParserException {
        //项目根路径
        URL url1 = ShellTest.class.getClassLoader().getResource("");
        System.out.println(url1.getPath());
        File curAllInOneProjectFile = new File(url1.getPath());
        File rootProjectFileDir = curAllInOneProjectFile.getParentFile().getParentFile();//获取上一级目录
        System.out.println(rootProjectFileDir);
        MavenXpp3Reader reader = new MavenXpp3Reader();
        String myPom = rootProjectFileDir + "/pom.xml";
        Model model = reader.read(new FileReader(myPom));
        System.out.println(model.getVersion());
    }


    /**
     * shell调用命令并获取执行结果
     *
     * @param
     * @return void
     * @author fwh [2021/1/6 && 1:56 下午]
     */
    @org.junit.Test
    public void shellTest() {
        Process process = null;
        List<String> processList = new ArrayList<String>();
        try {
            String newVersion = "2.0.0";
            String oldVersion = "1.0.0";
            String absolutePath = "/Users/fwh/Desktop/autoUpgrade.sh";
            String execCommand = "sh  " + absolutePath + " " + newVersion + " " + oldVersion;
            System.out.println(execCommand);
            process = Runtime.getRuntime().exec(execCommand);
            BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = "";
            while ((line = input.readLine()) != null) {
                processList.add(line);
            }
            input.close();
        } catch (IOException e) {
        }
        final String finalResult = processList.get(processList.size() - 1);
        if ("OK".equals(finalResult)) {
            log.info("执行成功");
        } else {
            log.error(finalResult);
        }
    }

//    public static void main(String[] args) {
//        Process process = null;
//        List<String> processList = new ArrayList<String>();
//        try {
////            process = Runtime.getRuntime().exec("ps -ef");
//            process = Runtime.getRuntime().exec("sh /Users/fwh/Desktop/test.sh 2.0.0 1.0.0");
//            BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
//            String line = "";
//            while ((line = input.readLine()) != null) {
//                processList.add(line);
//            }
//            input.close();
//        } catch (IOException e) {
//        }
//        final String finalResult = processList.get(processList.size() - 1);
//        System.out.println(finalResult);
////        for (String line : processList) {
////            System.out.println(line);
////        }
////        callShell("sh /Users/fwh/Desktop/test.sh 2.0.0 1.0.0");
//    }

    /**
     * 单条命令
     *
     * @param shellString
     * @return void
     * @author fwh [2021/1/6 && 2:26 下午]
     */
    public static void callShell(String shellString) {
        try {
            Process process = Runtime.getRuntime().exec(shellString);
            int exitValue = process.waitFor();
            if (0 != exitValue) {
                log.error("call shell failed. error code is :" + exitValue);
            } else {
                log.info("成功");
            }
        } catch (Throwable e) {
            log.error("call shell failed. " + e);
        }
    }
}
