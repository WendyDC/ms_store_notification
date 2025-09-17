package co.com.wenstore.usecase.order;

import co.com.wenstore.model.customer.Customer;
import co.com.wenstore.model.customer.gateways.CustomerRepository;
import co.com.wenstore.model.messagenotification.MessageNotification;
import co.com.wenstore.model.messagenotification.gateways.MessageNotificationRepository;
import co.com.wenstore.model.order.Order;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class OrderUseCase {

    private final CustomerRepository customerRepository;
    private final MessageNotificationRepository messageNotificationRepository;

    public Mono<Void> registerOrder(Order order){
        return customerRepository.findById(order.getClientId())
                .flatMap(customer -> notifyBusy(order, customer))
                .then();
    }

    private Mono<Void> notifyBusy(Order order, Customer customer){
        MessageNotification messageNotification =
                MessageNotification.builder()
                        .type("email")
                        .destination(customer.getEmail())
                        .content("Orde generada por "+order.getPrice())
                        .userId(customer.getIdNumber())
                        .build();
        return messageNotificationRepository.sendNotification(messageNotification);
    }
}
