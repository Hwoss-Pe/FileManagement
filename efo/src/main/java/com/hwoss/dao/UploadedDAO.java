package com.hwoss.dao;

import com.hwoss.dao.sqlprovider.UploadedSqlProvider;
import com.hwoss.model.UploadedRecord;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author admin
 * @since   
 */
@Repository
public interface UploadedDAO {

    /**
     * 查询上传记录
     *
     * @param userId 用户编号，不使用用户编号作为条件时设置值小于等于0即可
     * @param fileId 文档编号，不使用文档编号作为条件时设置值小于等于0即可
     * @param categoryId 分类编号，不用分类编号作为条件时设置值小于等于0即可
     * @param fileName 文档名，不使用文档名作为条件时设置值为空即可
     * @param offset 偏移
     *
     * @return 上传记录
     */
    @SelectProvider(type = UploadedSqlProvider.class, method = "getDownloadBy")
    List<UploadedRecord> listUploadedBy(@Param("userId") int userId, @Param("fileId") long fileId, @Param("fileName")
            String fileName, @Param("categoryId") int categoryId, @Param("offset") int offset);
}
