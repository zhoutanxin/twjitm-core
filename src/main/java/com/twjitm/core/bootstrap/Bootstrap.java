package com.twjitm.core.bootstrap;

import com.twjitm.core.common.config.global.GlobalConstants;
import com.twjitm.core.common.factory.thread.TwjThreadFactory;
import com.twjitm.core.common.system.SystemService;
import com.twjitm.core.initalizer.NettyHttpMessageServerInitializer;
import com.twjitm.core.initalizer.NettyTcpMessageServerInitializer;
import com.twjitm.core.initalizer.NettyUdpMessageServerInitializer;
import com.twjitm.core.spring.SpringServiceManager;
import com.twjitm.core.bootstrap.http.NettyGameBootstraptHttpService;
import com.twjitm.core.bootstrap.tcp.NettyGameBootstrapTcpService;
import com.twjitm.core.bootstrap.udp.NettyGameBootstrapUdpService;
import com.twjitm.core.utils.logs.LoggerUtils;
import org.apache.log4j.Logger;

/**
 * @author EGLS0807 - [Created on 2018-07-27 11:30]
 * @company http://www.g2us.com/
 * @jdk java version "1.8.0_77"
 *服务器启动入口
 */
public class Bootstrap {
    static Logger logger = LoggerUtils.getLogger(Bootstrap.class);

    public static void main(String[] args) {
        getBuddha();
        SystemService.getSystem();
        TwjThreadFactory factory = new TwjThreadFactory();
        SpringServiceManager.init();
        SpringServiceManager.start();

        NettyGameBootstrapTcpService tcpService = new NettyGameBootstrapTcpService(
                GlobalConstants.NettyNetServerConfig.TCP.SERVER_PORT,
                GlobalConstants.NettyNetServerConfig.TCP.SERVER_IP,
                GlobalConstants.NettyNetServerConfig.TCP.BOSS_THREAD_NAME,
                GlobalConstants.NettyNetServerConfig.TCP.WORKER_THREAD_NAME,
                new NettyTcpMessageServerInitializer());
        Thread tcpThread = factory.newThread(tcpService::startServer);
        tcpThread.start();

        NettyGameBootstrapUdpService udpService=new NettyGameBootstrapUdpService(
                GlobalConstants.NettyNetServerConfig.UDP.SERVER_PORT,
                GlobalConstants.NettyNetServerConfig.UDP.SERVER_IP,
                GlobalConstants.NettyNetServerConfig.UDP.EVENT_THREAD_NAME,
                new NettyUdpMessageServerInitializer());
        Thread udp = factory.newThread(udpService::startServer);
        udp.start();

        NettyGameBootstraptHttpService httpService=new NettyGameBootstraptHttpService(
                GlobalConstants.NettyNetServerConfig.HTTP.SERVER_PORT,
                GlobalConstants.NettyNetServerConfig.HTTP.SERVER_IP,
                GlobalConstants.NettyNetServerConfig.HTTP.BOSS_THREAD_NAME,
                GlobalConstants.NettyNetServerConfig.HTTP.WORKER_THREAD_NAME,
                new NettyHttpMessageServerInitializer()
        );
        Thread http= factory.newThread(httpService::startServer);
        http.start();
        //successful();
    }

    public static void getBuddha() {
        logger.info("\n" +
                "////////////////////////////////////////////////////////////////////\n" +
                "//                          _ooOoo_                               //\n" +
                "//                         o8888888o                              //\n" +
                "//                         88\" . \"88                              //\n" +
                "//                         (| ^_^ |)                              //\n" +
                "//                         O\\  =  /O                              //\n" +
                "//                      ____/`---'\\____                           //\n" +
                "//                    .'  \\\\|     |//  `.                         //\n" +
                "//                   /  \\\\|||  :  |||//  \\                        //\n" +
                "//                  /  _||||| -:- |||||-  \\                       //\n" +
                "//                  |   | \\\\\\  -  /// |   |                       //\n" +
                "//                  | \\_|  ''\\---/''  |   |                       //\n" +
                "//                  \\  .-\\__  `-`  ___/-. /                       //\n" +
                "//                ___`. .'  /--.--\\  `. . ___                     //\n" +
                "//              .\"\" '<  `.___\\_<|>_/___.'  >'\"\".                  //\n" +
                "//            | | :  `- \\`.;`\\ _ /`;.`/ - ` : | |                 //\n" +
                "//            \\  \\ `-.   \\_ __\\ /__ _/   .-` /  /                 //\n" +
                "//      ========`-.____`-.___\\_____/___.-`____.-'========         //\n" +
                "//                           `=---='                              //\n" +
                "//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^        //\n" +
                "//           Buddha bless the never down never BUG               //\n");
    }
    public static void successful(){
        //http://patorjk.com/software/taag
        logger.info("\n" +
                "                                                                                                                                                                              \n" +
                "                                                                                                                                                                              \n" +
                "                                                                                                                                  ffffffffffffffff                    lllllll \n" +
                "                                                                                                                                 f::::::::::::::::f                   l:::::l \n" +
                "                                                                                                                                f::::::::::::::::::f                  l:::::l \n" +
                "                                                                                                                                f::::::fffffff:::::f                  l:::::l \n" +
                "    ssssssssss   uuuuuu    uuuuuu      cccccccccccccccc   cccccccccccccccc    eeeeeeeeeeee        ssssssssss      ssssssssss    f:::::f       ffffffuuuuuu    uuuuuu   l::::l \n" +
                "  ss::::::::::s  u::::u    u::::u    cc:::::::::::::::c cc:::::::::::::::c  ee::::::::::::ee    ss::::::::::s   ss::::::::::s   f:::::f             u::::u    u::::u   l::::l \n" +
                "ss:::::::::::::s u::::u    u::::u   c:::::::::::::::::cc:::::::::::::::::c e::::::eeeee:::::eess:::::::::::::sss:::::::::::::s f:::::::ffffff       u::::u    u::::u   l::::l \n" +
                "s::::::ssss:::::su::::u    u::::u  c:::::::cccccc:::::c:::::::cccccc:::::ce::::::e     e:::::es::::::ssss:::::s::::::ssss:::::sf::::::::::::f       u::::u    u::::u   l::::l \n" +
                " s:::::s  ssssss u::::u    u::::u  c::::::c     ccccccc::::::c     ccccccce:::::::eeeee::::::e s:::::s  ssssss s:::::s  ssssss f::::::::::::f       u::::u    u::::u   l::::l \n" +
                "   s::::::s      u::::u    u::::u  c:::::c            c:::::c             e:::::::::::::::::e    s::::::s        s::::::s      f:::::::ffffff       u::::u    u::::u   l::::l \n" +
                "      s::::::s   u::::u    u::::u  c:::::c            c:::::c             e::::::eeeeeeeeeee        s::::::s        s::::::s    f:::::f             u::::u    u::::u   l::::l \n" +
                "ssssss   s:::::s u:::::uuuu:::::u  c::::::c     ccccccc::::::c     ccccccce:::::::e           ssssss   s:::::sssssss   s:::::s  f:::::f             u:::::uuuu:::::u   l::::l \n" +
                "s:::::ssss::::::su:::::::::::::::uuc:::::::cccccc:::::c:::::::cccccc:::::ce::::::::e          s:::::ssss::::::s:::::ssss::::::sf:::::::f            u:::::::::::::::uul::::::l\n" +
                "s::::::::::::::s  u:::::::::::::::u c:::::::::::::::::cc:::::::::::::::::c e::::::::eeeeeeee  s::::::::::::::ss::::::::::::::s f:::::::f             u:::::::::::::::ul::::::l\n" +
                " s:::::::::::ss    uu::::::::uu:::u  cc:::::::::::::::c cc:::::::::::::::c  ee:::::::::::::e   s:::::::::::ss  s:::::::::::ss  f:::::::f              uu::::::::uu:::ul::::::l\n" +
                "  sssssssssss        uuuuuuuu  uuuu    cccccccccccccccc   cccccccccccccccc    eeeeeeeeeeeeee    sssssssssss     sssssssssss    fffffffff                uuuuuuuu  uuuullllllll\n" +
                "                                                                                                                                                                              \n" +
                "                                                                                                                                                                              \n" +
                "                                                                                                                                                                              \n" +
                "                                                                                                                                                                              \n" +
                "                                                                                                                                                                              \n" +
                "                                                                                                                                                                              \n" +
                "                                                                                                                                                                              \n");
    }
}