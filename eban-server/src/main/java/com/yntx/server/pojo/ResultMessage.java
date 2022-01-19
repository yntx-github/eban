package com.yntx.server.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yntx
 * @version 1.0
 * @CreateDate 2022/1/18 21:25
 * @describe 统一结果返回对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultMessage {
    private long code;
    private String message;
    private Object obj;

    /**
     * 成功返回
     * @param message
     * @return
     */
    public static ResultMessage success(String message){
        return new ResultMessage(200,message,null);
    }

    /**
     * 成功返回
     * @param message
     * @param obj
     * @return
     */
    public static ResultMessage success(String message,Object obj){
        return new ResultMessage(200,message,obj);
    }

    /**
     * 失败返回
     * @param message
     * @return
     */
    public static ResultMessage error(String message){
        return new ResultMessage(500,message,null);
    }

    /**
     * 失败返回
     * @param message
     * @param obj
     * @return
     */
    public static ResultMessage error(String message,Object obj){
        return new ResultMessage(500,message,obj);
    }
}
