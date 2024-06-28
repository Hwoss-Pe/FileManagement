package com.hwoss.common;

import com.hwoss.EfoApplication;
import com.hwoss.EfoApplicationTest;
import com.hwoss.modules.constant.ConfigConsts;
import com.zhazhapan.util.FileExecutor;
import com.zhazhapan.util.Formatter;
import com.zhazhapan.util.MailSender;
import org.junit.Test;

import javax.swing.filechooser.FileSystemView;
import java.io.File;

/**
 * @author admin
 * @since      
 */
public class CommonTest {

    @Test
    public void testSendEmail() throws Exception {
        EfoApplicationTest.setSettings();
        MailSender.config(EfoApplication.settings.getObjectUseEval(ConfigConsts.EMAIL_CONFIG_OF_SETTINGS));
        MailSender.sendMail("tao@zhazhapan.com", "test", "test");
    }

    @Test
    public void testGetDriver() {
        FileSystemView fsv = FileSystemView.getFileSystemView();
        File[] fs = File.listRoots();
        for (File f : fs) {
            System.out.println(fsv.getSystemDisplayName(f));
            System.out.print("总大小" + Formatter.formatSize(f.getTotalSpace()));
            System.out.println("剩余" + Formatter.formatSize(f.getFreeSpace()));
            System.out.println(f.isDirectory());
        }
    }

    @Test
    public void testListRoot() {
        File[] files = FileExecutor.listFile("/c:/");
        for (File file : files) {
            System.out.println(file.getName());
        }
    }
}
