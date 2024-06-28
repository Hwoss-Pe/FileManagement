package com.hwoss.config;

import com.hwoss.EfoApplication;
import com.hwoss.EfoApplicationTest;
import com.hwoss.modules.constant.ConfigConsts;
import org.junit.Test;

import java.util.regex.Pattern;

/**
 * @author admin
 * @since  
 */
public class SettingConfigTest {

    @Test
    public void testFileSuffixPattern() {
        EfoApplicationTest.setSettings();
        assert Pattern.compile(EfoApplication.settings.getStringUseEval(ConfigConsts.FILE_SUFFIX_MATCH_OF_SETTING)).matcher("jpg").matches();
    }

    @Test
    public void testGetStoragePath() {
        EfoApplicationTest.setSettings();
        System.out.println(SettingConfig.getStoragePath(ConfigConsts.TOKEN_OF_SETTINGS));
    }
}
