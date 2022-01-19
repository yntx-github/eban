package com.yntx.server.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author yntx
 * @version 1.0
 * @CreateDate 2022/1/19 20:20
 * @describe TODO
 */
@Data
@Accessors(chain = true)
public class AdminLogin {
    private String userName;
    private String password;
}
