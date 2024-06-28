package com.hwoss.service.impl;

import com.hwoss.dao.UploadedDAO;
import com.hwoss.model.UploadedRecord;
import com.hwoss.service.IUploadedService;
import com.hwoss.util.ServiceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author admin
 * @since   
 */
@Service
public class UploadedServiceImpl implements IUploadedService {

    private final UploadedDAO uploadedDAO;

    @Autowired
    public UploadedServiceImpl(UploadedDAO uploadedDAO) {this.uploadedDAO = uploadedDAO;}

    @SuppressWarnings("unchecked")
    @Override
    public List<UploadedRecord> list(String user, String file, String category, int offset) {
        return (List<UploadedRecord>) ServiceUtils.invokeFileFilter(uploadedDAO, "listUploadedBy", user, file,
                category, offset);
    }
}
