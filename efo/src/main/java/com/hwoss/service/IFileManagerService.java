package com.hwoss.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author admin
 * @since       
 */
public interface IFileManagerService {


    /**
     * 下载多个文档
     *
     * @param response {@link HttpServletResponse}
     * @param items 文档集
     * @param destFile 目标文档名
     *
     * @throws IOException 异常
     */
    void multiDownload(HttpServletResponse response, String[] items, String destFile) throws IOException;

    /**
     * 上传文档（暂时还没有实现）
     *
     * @param destination 目标文档
     * @param files {@link MultipartFile}
     *
     * @return {@link JSONObject}
     */
    JSONObject upload(String destination, MultipartFile... files);

    /**
     * 解压文档
     *
     * @param object {@link JSONObject}
     *
     * @return {@link JSONObject}
     */
    JSONObject extract(JSONObject object);

    /**
     * 压缩文档
     *
     * @param object {@link JSONObject}
     *
     * @return {@link JSONObject}
     */
    JSONObject compress(JSONObject object);

    /**
     * 设置文档权限
     *
     * @param object {@link JSONObject}
     *
     * @return {@link JSONObject}
     */
    JSONObject setPermission(JSONObject object);

    /**
     * 创建文档夹
     *
     * @param object {@link JSONObject}
     *
     * @return {@link JSONObject}
     */
    JSONObject createFolder(JSONObject object);

    /**
     * 获取文档内容
     *
     * @param object {@link JSONObject}
     *
     * @return 文档内容
     */
    String getContent(JSONObject object);

    /**
     * 编辑文档
     *
     * @param object {@link JSONObject}
     *
     * @return {@link JSONObject}
     */
    JSONObject edit(JSONObject object);

    /**
     * 移除文档
     *
     * @param object {@link JSONObject}
     *
     * @return {@link JSONObject}
     */
    JSONObject remove(JSONObject object);

    /**
     * 复制文档
     *
     * @param object {@link JSONObject}
     *
     * @return {@link JSONObject}
     */
    JSONObject copy(JSONObject object);

    /**
     * 移动文档
     *
     * @param object {@link JSONObject}
     *
     * @return {@link JSONObject}
     */
    JSONObject move(JSONObject object);

    /**
     * 重命名
     *
     * @param object {@link JSONObject}
     *
     * @return {@link JSONObject}
     */
    JSONObject rename(JSONObject object);

    /**
     * 列出文档
     *
     * @param object {@link JSONObject}
     *
     * @return {@link JSONObject}
     */
    JSONArray list(JSONObject object);
}
