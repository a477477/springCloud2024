//package com.atguigu.cloud;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.core.Ordered;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
///**
// * @Author: lxf
// * @Date: 2024-05-30 21:16
// */
//@Component
//@Slf4j
//public class MyGlobalFilter  implements GlobalFilter, Ordered {
//    public  static final String BEGIN_VISIT_TIME ="begin_visit_time" ;//开始调用方法的时间
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        //1先记录下访问接口的时间
//        exchange.getAttributes().put(BEGIN_VISIT_TIME,System.currentTimeMillis());
//
//        return chain.filter(exchange).then(Mono.fromRunnable(()->{
//        Long beginVisitTime=   exchange.getAttribute(BEGIN_VISIT_TIME);
//                    if (null != beginVisitTime) {
//                        log.info("访问接口主机: " + exchange.getRequest().getURI().getHost());
//                        log.info("访问接口端口: " + exchange.getRequest().getURI().getPort());
//                        log.info("访问接口URL: " + exchange.getRequest().getURI().getPath());
//                        log.info("访问接口URL参数: " + exchange.getRequest().getURI().getRawQuery());
//                        log.info("访问接口时长: " + (System.currentTimeMillis() - beginVisitTime) + "ms");
//                        log.info("我是美丽分割线: ###################################################");
//                        System.out.println();
//                    }
//        }));
//
//    }
//
//    /**
//     * 数字越小 优先级越高
//     * @return
//     */
//    @Override
//    public int getOrder() {
//        return 0;
//    }
//}
