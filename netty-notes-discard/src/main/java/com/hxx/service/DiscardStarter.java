package com.hxx.service;

/**
 * <ul>
 * <li>功能说明：</li>
 * <li>作者：tal on 2019/1/15 0015 11:25 </li>
 * <li>邮箱：hou_xiangxiang@126.com</li>
 * </ul>
 */

public class DiscardStarter {
    public static void main(String[] args) throws Exception {
        int port;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        } else {
            port = 8080;
        }
        new DiscardServer(port).run();
    }
}
