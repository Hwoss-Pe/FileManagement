package com.hwoss.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.hwoss.EfoApplication;
import com.hwoss.service.IConfigService;
import com.hwoss.modules.constant.ConfigConsts;
import org.springframework.stereotype.Service;

/**
 * @author admin
 * @since     
 */
@Service
public class ConfigServiceImpl implements IConfigService {

    @Override
    public String getGlobalConfig() {
        JSONObject jsonObject = (JSONObject) EfoApplication.settings.getObjectUseEval(ConfigConsts
                .GLOBAL_OF_SETTINGS).clone();
        jsonObject.remove(ConfigConsts.UPLOAD_PATH_OF_GLOBAL);
        jsonObject.remove(ConfigConsts.TOKEN_PATH_OF_GLOBAL);
        jsonObject.remove(ConfigConsts.UPLOAD_FORM_OF_SETTING);
        return jsonObject.toString();
    }

    @Override
    public String getUserConfig() {
        JSONObject jsonObject = (JSONObject) EfoApplication.settings.getObjectUseEval(ConfigConsts.USER_OF_SETTINGS)
                .clone();
        jsonObject.remove(ConfigConsts.EMAIL_CONFIG_OF_USER);
        return jsonObject.toString();
    }
}