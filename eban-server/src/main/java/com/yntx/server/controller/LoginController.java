package com.yntx.server.controller;

import com.yntx.server.pojo.AdminLogin;
import com.yntx.server.pojo.ResultMessage;
import com.yntx.server.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yntx
 * @version 1.0
 * @CreateDate 2022/1/19 20:22
 * @describe TODO
 */
@RestController
public class LoginController {
    @Autowired
    private IAdminService adminService;

    public ResultMessage login(AdminLogin adminLogin, HttpRequest request){
        return adminService.login(adminLogin,request);
    }

}
