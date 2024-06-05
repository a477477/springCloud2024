package com.atguigu.cloud;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ServerWebExchange;

import java.util.List;
import java.util.function.Predicate;

/**
 * @Author: lxf
 * @Date: 2024-05-29 22:23
 *
 * 需求说明：自定义配置会员等级userType,按照钻/金/银和yml配置的会员等级
 * 以适配是否可以访问
 */
@Component
public class MyRoutePredicateFactory extends AbstractRoutePredicateFactory<MyRoutePredicateFactory.Config> {

    public MyRoutePredicateFactory(){
        super(MyRoutePredicateFactory.Config.class);
    }
    //这个config类就是我们的路由断言规则,重要
    @Validated
    public  static class Config{
        @Setter
        @Getter
        @NotEmpty
        private  String userType; //钻/金/银和yml配置的会员等级
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return super.shortcutFieldOrder();
    }

    @Override
    public Predicate<ServerWebExchange> apply(MyRoutePredicateFactory.Config config) {
        return new Predicate<ServerWebExchange>() {
            @Override
            public boolean test(ServerWebExchange serverWebExchange) {
                //检查request的参数里面，userType是否为指定的值，符合配置就通过
                String userType = serverWebExchange.getRequest().getQueryParams().getFirst("userType");
                if(userType==null){
                    return  false;
                }
                //检查request的参数里面，userType是否为指定的值，符合配置就通过
                if(userType.equalsIgnoreCase(config.getUserType())){
                    return true;
                }
                return false;
            }

        };
    }


}
