package com.xph.demo.BCrypt;

import org.mindrot.jbcrypt.BCrypt;

public class BCryptDemo {

    /**
     * BCrypt加密
     * BCrypt加密比md5加密更安全
     * 不过BCrypt加密速度慢于md5加密
     */
    public static void main(String[] args) {
        String pwd = "123";
        // 加密，核心代码，通过调用BCrypt类的静态方法hashpw对password进行加密。第二个参数就是我们平时所说的加盐。
        String encodePwd = BCrypt.hashpw(pwd, BCrypt.gensalt());
        System.out.println(encodePwd);
        // 该方法就是对用户后来输入的密码进行比较。如果能够匹配，返回true。
        boolean flag = BCrypt.checkpw(pwd, encodePwd);
        System.out.println(flag);
    }
}
