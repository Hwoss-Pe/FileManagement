package com.hwoss.service;

import com.hwoss.model.UploadedRecord;

import java.util.List;

/**
 * @author admin
 * @since   
 */
public interface IUploadedService {

    /**
     * 获取所有上传记录
     *
     * @param user 用户名或邮箱
     * @param category 分类名称
     * @param file 文档名
     * @param offset 偏移
     *
     * @return {@link List}
     */
    List<UploadedRecord> list(String user, String file, String category, int offset);
}
