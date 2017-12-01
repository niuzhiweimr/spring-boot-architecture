package com.syhd.user.constant;

import java.util.Locale;
import java.util.ResourceBundle;

public class Constant {

    public static final String FLAG = "Y";
    //无用值 针对具有 0 1 状态时 调试mybatis动态语句检查值
    public static final Integer N0_VALUE=-1;
    //token是否有效 0无效/1有效
    public static final Integer TOKEN_NO = 0;
    public static final Integer TOKEN_YES = 1;
    //token过期时间  值(分钟) 可在配置文件 token.properties中配置
    public static final Integer TOKEN_EXPIRATION_TIME = Integer.valueOf(ResourceBundle.getBundle("token", Locale.CHINA).getString("token_expiration_time")) * 1000 * 60;

}
