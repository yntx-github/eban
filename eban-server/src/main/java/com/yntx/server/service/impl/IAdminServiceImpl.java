package com.yntx.server.service.impl;

import com.yntx.server.config.security.JwtTokenUtil;
import com.yntx.server.pojo.Admin;
import com.yntx.server.mapper.AdminMapper;
import com.yntx.server.pojo.AdminLogin;
import com.yntx.server.pojo.ResultMessage;
import com.yntx.server.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

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
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Override
    public ResultMessage login(AdminLogin adminLogin, HttpRequest request) {
        //登录
        UserDetails userDetails = userDetailsService.loadUserByUsername(adminLogin.getUserName());
        if (null == userDetails || !passwordEncoder.matches(adminLogin.getPassword(),userDetails.getPassword())){
            return ResultMessage.error("用户名或密码不正确");
        }
        if (!userDetails.isEnabled()){
            return ResultMessage.error("账号已被禁用，请联系管理员");
        }

        //更新security登录用户对象
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                userDetails,null,userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        //生成token
        String token = jwtTokenUtil.generateToken(userDetails);
        Map<String,String> tokenMap = new HashMap<>();
        tokenMap.put("token",token);
        tokenMap.put("tokenHead",tokenHead);
        return ResultMessage.success("登录成功",tokenMap);
    }
}
