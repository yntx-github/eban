package com.yntx.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yntx.server.pojo.Admin;
import com.yntx.server.pojo.AdminLogin;
import com.yntx.server.pojo.ResultMessage;
import org.springframework.http.HttpRequest;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yntx
 * @since 2022-01-17
 */
public interface IAdminService extends IService<Admin> {

    ResultMessage login(AdminLogin adminLogin, HttpRequest request);
}
