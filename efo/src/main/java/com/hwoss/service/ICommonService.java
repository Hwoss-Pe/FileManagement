package com.hwoss.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author admin
 * @since      
 */
public interface ICommonService {

    /**
     * 发送验证码
     *
     * @param email 邮箱
     *
     * @return 验证码
     */
    int sendVerifyCode(String email);

    /**
     * 上传头像
     *
     * @param multipartFile 头像文档
     *
     * @return 头像文档名
     */
    String uploadAvatar(MultipartFile multipartFile);
}
