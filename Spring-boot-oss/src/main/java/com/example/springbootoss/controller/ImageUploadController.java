package com.example.springbootoss.controller;

import com.chige.exception.FileUploadException;
import com.chige.response.CommonResult;
import com.chige.response.ResponseCode;
import com.chige.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/** 图片上传功能
 * @author wangyc
 * @date 2022/8/15
 */
@Slf4j
@RestController("/image")
public class ImageUploadController {

    /**
     * 限制图片大小上限为1MB
     */
    private static final int IMAGE_MAX = 3 * 1024 * 1024;


    @PostMapping("/upload")
    public CommonResult uploadImage(MultipartFile multipartFile) {
        log.info("接口入参对象：" + JsonUtils.toJSONString(multipartFile));
        //1、上传文件判空处理
        if (multipartFile.isEmpty()) {
            throw new FileUploadException(ResponseCode.FILE_IMAGE_NOT_EMPTY);
        }
        //2、上传文件大小上限判断处理
        if (multipartFile.getSize() > IMAGE_MAX) { //getSize()返回文件的字节大小
            throw new FileUploadException(ResponseCode.FILE_IMAGE_SIZE_OVER_LIMIT.getCode(), "不允许上传超过" + (multipartFile.getSize() / 1024) + "KB大小的文件");
        }

        //3、判断上传文件类型
        if (!ImageTypeEnum.isSupport(multipartFile.getContentType())) {
            throw new FileUploadException(ResponseCode.FILE_IMAGE_NOT_SUPPORT);
        }

        //4、todo 获取上传的文件名
        String originalFilename = multipartFile.getOriginalFilename();
        int lastIndexOf = originalFilename.lastIndexOf(".");
        originalFilename.substring(0, lastIndexOf);
        String imageUrl = "http://xxx.jpg";
        return CommonResult.success("上传成功,可访问地址:" + imageUrl);
    }

    static enum ImageTypeEnum {
        JPG(".jpg"),
        PNG(".png"),
        JPEG(".jpeg"),

        ;

        private final String type;

        ImageTypeEnum(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }

        /**
         * 判断是否支持的类型
         */
        public static boolean isSupport(String type) {
            for (ImageTypeEnum value : values()) {
                if (value.type.contains(type)) {
                    return true;
                }
            }
            return false;
        }
    }
}
