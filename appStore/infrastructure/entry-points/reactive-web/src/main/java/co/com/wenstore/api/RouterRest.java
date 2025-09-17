package co.com.wenstore.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterRest {

    @Bean
    public RouterFunction<ServerResponse> productsByOffer(HandlerProduct handlerProduct) {
        return route(POST("/api/product/productsByOffer"),
                    handlerProduct::getProductsByOffer);
    }

    @Bean
    public RouterFunction<ServerResponse> registerOrder(HandlerOrder handlerOrder) {
        return route(POST("/api/product/registerOrder"),
                    handlerOrder::registerOrder);
    }
}
