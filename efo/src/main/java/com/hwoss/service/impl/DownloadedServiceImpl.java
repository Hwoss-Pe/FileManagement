package com.hwoss.service.impl;

import com.hwoss.dao.DownloadedDAO;
import com.hwoss.model.DownloadRecord;
import com.hwoss.service.IDownloadedService;
import com.hwoss.util.ServiceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author admin
 * @since       
 */
@Service
public class DownloadedServiceImpl implements IDownloadedService {

    private final DownloadedDAO downloadDAO;

    @Autowired
    public DownloadedServiceImpl(DownloadedDAO downloadDAO) {
        this.downloadDAO = downloadDAO;
    }

    @Override
    public void insertDownload(int userId, long fileId) {
        downloadDAO.insertDownload(userId, fileId);
    }

    @Override
    public void removeByFileId(long fileId) {
        downloadDAO.removeByFileId(fileId);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<DownloadRecord> list(String user, String file, String category, int offset) {
        return (List<DownloadRecord>) ServiceUtils.invokeFileFilter(downloadDAO, "listDownloadedBy", user, file,
                category, offset);
    }
}
