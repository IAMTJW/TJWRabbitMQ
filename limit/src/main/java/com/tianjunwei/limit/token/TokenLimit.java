package com.tianjunwei.limit.token;

import com.tianjunwei.limit.config.JedisConfig;

/**
 * token 限流
 *
 * @Description TODO
 * @Author tianjunwei7
 * @Date 2020/1/21 4:32 下午
 * @ClassName com.tianjunwei.limit
 */
public class TokenLimit {

    private static final String tokenLimit = "TokenLimit";

    public static void main(String[] args) throws Exception {


        Thread thread = new Thread(new TokenLimitThread("thread1"));
        thread.start();

        Thread thread2 = new Thread(new TokenLimitThread("thread2"));
        thread2.start();

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (; ; ) {
                    JedisConfig.set(TokenLimit.tokenLimit,"10");
                    try {
                        Thread.sleep(20000);
                    }catch (Exception e) {

                    }
                }
            }
        });

        thread3.start();

        System.in.read();

    }

}
