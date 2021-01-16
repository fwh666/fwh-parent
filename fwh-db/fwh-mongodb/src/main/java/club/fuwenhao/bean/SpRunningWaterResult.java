package club.fuwenhao.bean;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;


/**
 * Title:  Test
 * Description:
 *
 * @author zhuochen7
 * @data 2020-05-06 10:17
 **/
@Data
@Document(collection = "running_water_result")//此注解对应mongodb集合
public class SpRunningWaterResult {

    /**
     * mongo主键
     */
    @Id
    private String id;

    /**
     * 任务id
     */
    @Indexed
    private Long taskId;

    /**
     * 摄像头业务方ID
     */
    private String brandID;

    /**
     * 摄像头分区ID
     */
    private String siteID;


    /**
     * 摄像头分组ID
     */
    private String groupID;

    /**
     * 设备id
     */
    private String cameraID;

    /**
     * 设备名称
     */
    private String cameraName;

    /**
     * 跟踪轨迹的ID
     */
    private String traceID;

    /**
     * 跟踪节点的ID
     */
    private String nodeID;

    /**
     * 注册人ID
     */
    private String registerID;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 注册人信息
     */
    private String registerInfo;

    /**
     * 姓名
     */
    private String name;

    /**
     * 注册人类型
     */
    private String registerType;

    /**
     * 注册人底库ID
     */
    private String registerDBID;

    /**
     * 注册照的URL
     */
    private String registerImgURL;

    /**
     * 底库照片地址
     */
    // private String targetURL;

    /**
     * 年龄
     */
    private Float age;

    /**
     * 性别，1为男，0为女
     */
    private Integer gender;

    /**
     * 是否戴眼镜，1戴，0不戴
     */
    private Integer eyeglasses;

    /**
     * 是否戴太阳镜，1戴，0不戴
     */
    private Integer sunglasses;

    /**
     * 是否戴口罩，1戴，0不戴
     */
    private Integer mask;

    /**
     * 流水时间  毫秒级别时间戳
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss:SSS")
    private Date timestamp;

    /**
     * frame的URL
     */
    private String frameURL;

    /**
     * 是否有人脸  example: true
     */
    private Boolean hasFace;

    /**
     * example: List [ 9, 8, 24, 67 ]
     * 人脸框，左上(x，y)，右下（x，y）
     */
    private List<Integer> faceBoundingBox;

    /**
     * 人脸比对分数
     */
    private Float faceScore;

    /**
     * 检测出的人脸图片URL
     */
    private String faceImgURL;

    /**
     * 是否有人脸属性  example: true
     */
    private Boolean hasFaceProp;

    /**
     * example: true
     * 是否有人体
     */
    private Boolean hasPerson;

    /**
     * example: List [ 9, 8, 24, 67 ]
     * 人体框，左上(x，y)，右下（x，y）
     */
    private List<Integer> personBoundingBox;

    /**
     * 人体比对分数
     */
    private Float personScore;

    /**
     * 检测得到的人体图片的URL
     */
    private String personImgURL;

    /**
     * 相似度
     */
    // private Double similarity;

    /**
     * 流水类型；1：追踪；2：回溯；3：监控
     */
    private Integer taskType;

    /**
     * 园区id
     */
    private Long campusId;

    /**
     * 结果标记 0 未确认；1：正确；2：错误；3：不确定
     */
    private int resultFlag = 0;

    /**
     * 0 未归档；1：归档
     */
    private int placeOnfile = 0;

}
