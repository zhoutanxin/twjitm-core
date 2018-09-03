package com.twjitm.core.common.zookeeper;import com.alibaba.fastjson.JSON;import com.twjitm.core.common.service.rpc.serialize.INettyJsonSerializer;import com.twjitm.core.common.service.rpc.server.NettyRpcNodeInfo;import com.twjitm.core.spring.SpringServiceManager;import java.io.IOException;/** * @author EGLS0807 - [Created on 2018-08-22 10:44] * @company http://www.g2us.com/ * @jdk java version "1.8.0_77" * zookeeper node information */public class NettyZookeeperNodeInfo extends NettyRpcNodeInfo implements INettyJsonSerializer {   private NettyZookeeperNodeNettyGameTypeEnum nettyZookeeperNodeNettyGameTypeEnum;    NettyZookeeperNodeInfo() {        super();    }    public NettyZookeeperNodeInfo(NettyZookeeperNodeNettyGameTypeEnum nettyZookeeperNodeNettyGameTypeEnum, String serverId, String serverHost, String serverPort) {        this.nettyZookeeperNodeNettyGameTypeEnum = nettyZookeeperNodeNettyGameTypeEnum;        this.setHost(serverHost);        this.setServerId(serverId);        this.setPort(serverPort);    }    /**     * 获取全部路径。例如：/registry_world_address/rpc_registry8001     * @return     */    public String getZookeeperNodePath() {        String registryAddress = SpringServiceManager.getSpringLoadService().getNettyGameServiceConfigService().getZookeeperConfig().getRegistryPath();        return nettyZookeeperNodeNettyGameTypeEnum.getRootPath() +registryAddress + getServerId();    }    @Override    public String serialize() throws IOException {        return JSON.toJSONString(this);    }    @Override    public void deserialize(String pack) {        NettyZookeeperNodeInfo info = JSON.parseObject(pack, NettyZookeeperNodeInfo.class);        this.nettyZookeeperNodeNettyGameTypeEnum = info.getNettyZookeeperNodeNettyGameTypeEnum();        this.setHost(info.getHost());        this.setServerId(info.getServerId());        this.setPort(info.getPort());    }    public NettyZookeeperNodeNettyGameTypeEnum getNettyZookeeperNodeNettyGameTypeEnum() {        return nettyZookeeperNodeNettyGameTypeEnum;    }    public void setNettyZookeeperNodeNettyGameTypeEnum(NettyZookeeperNodeNettyGameTypeEnum nettyZookeeperNodeNettyGameTypeEnum) {        this.nettyZookeeperNodeNettyGameTypeEnum = nettyZookeeperNodeNettyGameTypeEnum;    }}