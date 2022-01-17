package com.yntx.server.service.impl;

import com.yntx.server.pojo.Admin;
import com.yntx.server.mapper.AdminMapper;
import com.yntx.server.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yntx
 * @since 2022-01-17
 */
@Service
public class IAdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

}
