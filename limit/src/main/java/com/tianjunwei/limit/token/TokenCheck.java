package com.tianjunwei.limit.token;

import com.tianjunwei.limit.config.JedisConfig;

/**
 * @Description TODO
 * @Author tianjunwei7
 * @Date 2020/1/21 5:10 下午
 * @ClassName com.tianjunwei.limit.token
 */
public class TokenCheck {

    private static final String tokenLimit = "TokenLimit";

    public boolean checkToken(){
        Long tokenNum = 0L;
        if (JedisConfig.get(tokenLimit) != null) {
            tokenNum = Long.parseLong(JedisConfig.get(tokenLimit));
            if (tokenNum > 0) {
                tokenNum = JedisConfig.decr(tokenLimit);
                if (tokenNum < 0) {
                    JedisConfig.incr(tokenLimit);
                    return false;
                }else {
                    return true;
                }
            }
        }
        return false;
    }

}
