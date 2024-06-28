package com.hwoss.service;

import com.hwoss.model.DownloadRecord;

import java.util.List;

/**
 * @author admin
 * @since       
 */
public interface IDownloadedService {

    /**
     * 添加下载记录
     *
     * @param userId 用户编号
     * @param fileId 文档编号
     */
    void insertDownload(int userId, long fileId);

    /**
     * 通过文档编号删除下载记录
     *
     * @param fileId 文档编号
     */
    void removeByFileId(long fileId);

    /**
     * 获取所有下载记录
     *
     * @param user 用户名或邮箱
     * @param category 分类名称
     * @param file 文档名
     * @param offset 偏移
     *
     * @return {@link DownloadRecord}
     */
    List<DownloadRecord> list(String user, String file, String category, int offset);
}
