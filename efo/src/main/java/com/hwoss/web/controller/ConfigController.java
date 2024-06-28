package com.hwoss.web.controller;

import com.hwoss.EfoApplication;
import com.hwoss.annotation.AuthInterceptor;
import com.hwoss.entity.User;
import com.hwoss.enums.InterceptorLevel;
import com.hwoss.modules.constant.DefaultValues;
import com.hwoss.service.IConfigService;
import com.zhazhapan.modules.constant.ValueConsts;
import com.zhazhapan.util.FileExecutor;
import com.zhazhapan.util.NetUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author admin
 * @since     
 */
@RestController
@RequestMapping("/config")
@Api(value = "/config", description = "配置文档的相关操作")
public class ConfigController {

    private static Logger logger = Logger.getLogger(ConfigController.class);

    private final IConfigService configService;

    private final HttpServletRequest request;

    @Autowired
    public ConfigController(IConfigService configService, HttpServletRequest request) {
        this.configService = configService;
        this.request = request;
    }

    @ApiOperation(value = "更新配置文档")
    @ApiImplicitParam(name = "config", value = "配置文档内容", required = true)
    @AuthInterceptor(InterceptorLevel.ADMIN)
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public String updateConfig(String config) {
        User user = (User) request.getSession().getAttribute(ValueConsts.USER_STRING);
        if (user.getPermission() > ValueConsts.TWO_INT) {
            EfoApplication.settings.setJsonObject(config);
            //打包成jar之后无法修改config.json文档
            try {
                FileExecutor.saveFile(NetUtils.urlToString(EfoApplication.class.getResource(DefaultValues
                        .SETTING_PATH)), EfoApplication.settings.toString());
            } catch (IOException e) {
                logger.error(e.getMessage());
                return "{\"message\":\"internal error, cannot save\"}";
            }
            return "{\"message\":\"saved successfully\"}";
        } else {
            return "{\"message\":\"permission denied\"}";
        }
    }

    @ApiOperation(value = "获取配置文档内容")
    @AuthInterceptor(InterceptorLevel.ADMIN)
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getAll() {
        User user = (User) request.getSession().getAttribute(ValueConsts.USER_STRING);
        if (user.getPermission() > ValueConsts.TWO_INT) {
            return EfoApplication.settings.toString();
        } else {
            return "{\"message\":\"permission denied\"}";
        }
    }

    @ApiOperation(value = "获取配置文档中的全局相关配置内容")
    @AuthInterceptor(InterceptorLevel.NONE)
    @RequestMapping(value = "/global", method = RequestMethod.GET)
    public String getGlobalConfig() {
        return configService.getGlobalConfig();
    }

    @ApiOperation(value = "获取配置文档中的用户相关配置内容")
    @AuthInterceptor(InterceptorLevel.NONE)
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getUserConfig() {
        return configService.getUserConfig();
    }
}
