package com.twjitm.core.common.handler.rpc;import com.twjitm.core.common.netstack.entity.rpc.NettyRpcResponseMessage;import com.twjitm.core.common.service.rpc.network.NettyRpcClient;import com.twjitm.core.utils.logs.LoggerUtils;import io.netty.channel.ChannelHandlerContext;import io.netty.channel.SimpleChannelInboundHandler;import org.apache.log4j.Logger;/** * @author EGLS0807 - [Created on 2018-08-20 11:30] * @company http://www.g2us.com/ * @jdk java version "1.8.0_77" */public class NettyRpcClientServerHandler extends SimpleChannelInboundHandler<NettyRpcResponseMessage> {   private NettyRpcClient nettyRpcClient;   private Logger logger=LoggerUtils.getLogger(NettyRpcClientServerHandler.class);    @Override    public void channelActive(ChannelHandlerContext ctx) throws Exception {        super.channelActive(ctx);    }    @Override    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {        super.channelRegistered(ctx);    }    @Override    public void channelRead0(ChannelHandlerContext ctx, NettyRpcResponseMessage response) throws Exception {        nettyRpcClient.handleRpcResponse(response);    }    @Override    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {        logger.error("RPC CLIENT CAUGHT EXCEPTION", cause);        nettyRpcClient.close();    }    public NettyRpcClient getNettyRpcClient() {        return nettyRpcClient;    }    public void setNettyRpcClient(NettyRpcClient nettyRpcClient) {        this.nettyRpcClient = nettyRpcClient;    }}