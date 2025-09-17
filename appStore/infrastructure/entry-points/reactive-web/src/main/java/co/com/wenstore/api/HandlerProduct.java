package co.com.wenstore.api;

import co.com.wenstore.api.model.RQProductsByOffer;
import co.com.wenstore.api.model.ResponseEntity;
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
public class HandlerProduct {

    private final ProductUseCase productUseCase;

    public Mono<ServerResponse> getProductsByOffer(ServerRequest serverRequest) {
        log.info("serverRequest "+serverRequest);
        return serverRequest.bodyToMono(RQProductsByOffer.class)
                .flatMap(getAllProduct ->
                        productUseCase.getProductsByOffer(getAllProduct.getTypeOffer())
                        .collectList())
                .doOnSuccess(products ->
                        log.info("products "+products))
                .flatMap(products -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(ResponseEntity.builder()
                                .data(products)
                                .status(HttpStatus.OK.value())
                                .message("Products found successfully")
                                .build()))
                .switchIfEmpty(ServerResponse.status(HttpStatus.NOT_FOUND)
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(ResponseEntity.builder()
                                .status(HttpStatus.NOT_FOUND.value())
                                .message("No products found")
                                .build()));
    }
}
