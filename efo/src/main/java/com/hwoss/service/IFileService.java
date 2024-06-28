package com.hwoss.service;

import com.hwoss.entity.User;
import com.hwoss.model.BaseAuthRecord;
import com.hwoss.model.FileBasicRecord;
import com.hwoss.model.FileRecord;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

/**
 * @author admin
 * @since       
 */
public interface IFileService {

    /**
     * 更新文档权限
     *
     * @param id 文档编号
     * @param auth 权限集
     *
     * @return 是否更新成功
     */
    boolean updateAuth(long id, String auth);

    /**
     * 获取文档权限
     *
     * @param id 文档编号
     *
     * @return {@link BaseAuthRecord}
     */
    BaseAuthRecord getAuth(long id);

    /**
     * 批量删除文档
     *
     * @param ids 所有文档编号
     *
     * @return 是否删除成功
     */
    boolean deleteFiles(String ids);

    /**
     * 更新文档路径
     *
     * @param id 文档编号
     * @param oldLocalUrl 原本地路径
     * @param localUrl 本地路径
     * @param visitUrl 访问路径
     *
     * @return 是否更新成功
     */
    boolean[] updateUrl(int id, String oldLocalUrl, String localUrl, String visitUrl);

    /**
     * 更新文档信息
     *
     * @param id 文档编号
     * @param user 用户对象
     * @param name 文档名
     * @param category 文档分类
     * @param tag 标签
     * @param description 文档描述
     *
     * @return 是否更新成功
     */
    boolean updateFileInfo(long id, User user, String name, String category, String tag, String description);

    /**
     * 删除文档，验证权限
     *
     * @param user 用户对象
     * @param fileId 文档编号
     *
     * @return {@link Boolean}
     */
    boolean removeFile(User user, long fileId);

    /**
     * 获取用户的下载资源
     *
     * @param userId 用户编号
     * @param offset 偏移
     * @param search 搜索
     *
     * @return {@link List}
     */
    List<FileRecord> listUserDownloaded(int userId, int offset, String search);

    /**
     * 获取用户的上传资源
     *
     * @param userId 用户编号
     * @param offset 偏移
     * @param search 搜索
     *
     * @return {@link List}
     */
    List<FileRecord> listUserUploaded(int userId, int offset, String search);

    /**
     * 通过编号删除，不验证权限
     *
     * @param id 编号
     *
     * @return 是否删除成功
     */
    boolean removeById(long id);

    /**
     * 通过访问路径删除
     *
     * @param visitUrl 访问路径
     *
     * @return 是否删除成功
     */
    boolean removeByVisitUrl(String visitUrl);

    /**
     * 通过本地路径删除
     *
     * @param localUrl 访问路径
     *
     * @return 是否删除成功
     */
    boolean removeByLocalUrl(String localUrl);

    /**
     * 获取资源
     *
     * @param visitUrl 访问路径
     * @param request {@link HttpServletRequest}
     *
     * @return {@link File}
     */
    String getResource(String visitUrl, HttpServletRequest request);

    /**
     * 通过访问路径获取本地文档路径
     *
     * @param visitUrl 访问路径
     *
     * @return {@link String}
     */
    String getLocalUrlByVisitUrl(String visitUrl);

    /**
     * 获取所有文档
     *
     * @param userId 用户编号
     * @param offset 偏移
     * @param categoryId 分类编号
     * @param orderBy 排序方式
     * @param search 搜索
     *
     * @return {@link List}
     */
    List<FileRecord> listAll(int userId, int offset, int categoryId, String orderBy, String search);

    /**
     * 上传文档
     *
     * @param categoryId 分类ID
     * @param tag 标签
     * @param description 描述
     * @param prefix 自定义前缀
     * @param multipartFile 文档
     * @param user {@link User}
     *
     * @return 是否上传成功
     */
    boolean upload(int categoryId, String tag, String description, String prefix, MultipartFile multipartFile, User
            user);

    /**
     * 分享服务器本地文档
     *
     * @param prefix 链接前缀
     * @param files 文档
     * @param user 用户对象
     *
     * @return 是否添加成功
     */
    boolean shareFiles(String prefix, String files, User user);

    /**
     * 本地路径是否存在
     *
     * @param localUrl 本地路径
     *
     * @return {@link Boolean}
     */
    boolean localUrlExists(String localUrl);

    /**
     * 访问路径是否存在
     *
     * @param visitUrl 访问路径
     *
     * @return {@link Boolean}
     */
    boolean visitUrlExists(String visitUrl);

    /**
     * 通过本地路径获取文档编号
     *
     * @param localUrl 本地路径
     *
     * @return 文档编号
     */
    long getFileId(String localUrl);

    /**
     * 获取所有文档基本信息
     *
     * @param user 用户名或邮箱
     * @param category 分类名称
     * @param file 文档名
     * @param offset 偏移
     *
     * @return {@link List}
     */
    List<FileBasicRecord> listBasicAll(String user, String file, String category, int offset);
}
