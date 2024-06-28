package com.hwoss.web.controller;

import com.hwoss.annotation.AuthInterceptor;
import com.hwoss.enums.InterceptorLevel;
import com.hwoss.service.IDownloadedService;
import com.zhazhapan.util.Formatter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author admin
 * @since       
 */
@RestController
@RequestMapping(value = "/downloaded")
@Api(value = "/downloaded", description = "下载记录相关操作")
public class DownloadedController {

    private final IDownloadedService downloadService;

    @Autowired
    public DownloadedController(IDownloadedService downloadService) {
        this.downloadService = downloadService;
    }

    @ApiOperation(value = "获取文档下载记录")
    @ApiImplicitParams({@ApiImplicitParam(name = "user", value = "指定用户（默认所有用户）"), @ApiImplicitParam(name =
            "指定文档（默认所有文档）"), @ApiImplicitParam(name = "category", value = "指定分类（默认所有分类）"), @ApiImplicitParam(name =
            "offset", value = "偏移量", required = true)})
    @AuthInterceptor(InterceptorLevel.ADMIN)
    @RequestMapping(value = "all", method = RequestMethod.GET)
    public String getAll(String user, String file, String category, int offset) {
        return Formatter.listToJson(downloadService.list(user, file, category, offset));
    }
}
