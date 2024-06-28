package com.hwoss.service;

import com.hwoss.entity.Auth;
import com.hwoss.model.AuthRecord;

import java.util.List;

/**
 * @author admin
 * @since       
 */
public interface IAuthService {

    /**
     * 添加权限集
     *
     * @param files 文档
     * @param users 用户
     * @param auths 权限集
     *
     * @return 是否添加成功
     */
    boolean addAuth(String files, String users, String auths);

    /**
     * 批量删除权限记录
     *
     * @param ids 权限编号集
     *
     * @return 是否删除成功
     */
    boolean batchDelete(String ids);

    /**
     * 更新权限
     *
     * @param id 权限编号
     * @param auths 权限
     *
     * @return 是否更新成功
     */
    boolean updateAuth(long id, String auths);

    /**
     * 获取权限表数据
     *
     * @param usernameOrEmail 用户名或邮箱
     * @param fileName 文档名
     * @param offset 偏移
     *
     * @return {@link List}
     */
    List<AuthRecord> listAuth(String usernameOrEmail, String fileName, int offset);

    /**
     * 获取一个权限
     *
     * @param fileId 文档编号
     * @param userId 用户编号
     *
     * @return {@link AuthRecord}
     */
    AuthRecord getByFileIdAndUserId(long fileId, int userId);

    /**
     * 添加一个默认权限
     *
     * @param userId 用户编号
     * @param fileId 文档编号
     *
     * @return 是否添加成功
     */
    boolean insertDefaultAuth(int userId, long fileId);

    /**
     * 添加一个权限
     *
     * @param auth {@link Auth}
     *
     * @return 是否添加成功
     */
    boolean insertAuth(Auth auth);

    /**
     * 通过文档编号删除权限
     *
     * @param fileId 文档编号
     *
     * @return 是否删除成功
     */
    boolean removeByFileId(long fileId);
}
