package com.hxx.service;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/**
 * <ul>
 * <li>功能说明：</li>
 * <li>作者：tal on 2019/1/15 0015 11:00 </li>
 * <li>邮箱：hou_xiangxiang@126.com</li>
 * </ul>
 */

public class DiscardServerHandler extends ChannelInboundHandlerAdapter {
    /**
     * 异常发生时回调
     *
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    /**
     * 读取信息(直接丢弃)
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try {
            //控制台原样输出收到的字符
            //注释即为抛弃
            System.out.println(((ByteBuf) msg).toString(io.netty.util.CharsetUtil.US_ASCII));
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }
}
