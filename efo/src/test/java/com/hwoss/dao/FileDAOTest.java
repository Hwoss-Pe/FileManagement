package com.hwoss.dao;

import com.hwoss.EfoApplicationTest;
import com.zhazhapan.util.Formatter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author admin
 * @since      
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FileDAOTest {

    @Autowired
    FileDAO fileDAO;

    @Test
    public void testRemoveFile() {
        assert fileDAO.removeById(3);
    }

    @Test
    public void testGetUserDownloaded() {
        EfoApplicationTest.setSettings();
        System.out.println(Formatter.listToJson(fileDAO.listUserDownloaded(2, 0, "")));
    }
}