package com.tianjunwei.limit.token;

/**
 * @Description TODO
 * @Author tianjunwei7
 * @Date 2020/1/21 4:58 下午
 * @ClassName com.tianjunwei.limit
 */
public class TokenLimitThread implements Runnable {

    private TokenCheck tokenCheck;

    private String name;

    public TokenLimitThread(String name) {
        this.name = name;
        tokenCheck = new TokenCheck();
    }

    @Override
    public void run() {

        for (; ; ) {
            if (tokenCheck.checkToken()) {
                System.out.println(name + "get token pass");
            } else {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {

                }
            }
        }

    }
}
