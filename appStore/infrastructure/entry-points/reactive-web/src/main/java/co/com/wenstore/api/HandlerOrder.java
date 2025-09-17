package co.com.wenstore.api;

import co.com.wenstore.api.model.RQProductsByOffer;
import co.com.wenstore.api.model.RQRegisterOrder;
import co.com.wenstore.api.model.ResponseEntity;
import co.com.wenstore.model.order.Order;
import co.com.wenstore.usecase.order.OrderUseCase;
import co.com.wenstore.usecase.product.ProductUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Log
@Component
@RequiredArgsConstructor
public class HandlerOrder {

    private final OrderUseCase orderUseCase;

    public Mono<ServerResponse> registerOrder(ServerRequest serverRequest) {
        log.info("serverRequest "+serverRequest);
        return serverRequest.bodyToMono(RQRegisterOrder.class)
                .map(orderRQ -> {
                    return Order.builder()
                            .clientId(orderRQ.getClientId())
                            .productId(orderRQ.getProductId())
                            .price(orderRQ.getPrice())
                            .amount(orderRQ.getAmount())
                            .build();
                })
                .flatMap(orderUseCase::registerOrder)
                .doOnSuccess(order ->
                        log.info("order "+order))
                .flatMap(order -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(ResponseEntity.builder()
                                .data(null)
                                .status(HttpStatus.OK.value())
                                .message("Register order successfully")
                                .build()))
                .switchIfEmpty(ServerResponse.status(HttpStatus.NOT_FOUND)
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(ResponseEntity.builder()
                                .status(HttpStatus.NOT_FOUND.value())
                                .message("Error register order")
                                .build()));
    }
}
