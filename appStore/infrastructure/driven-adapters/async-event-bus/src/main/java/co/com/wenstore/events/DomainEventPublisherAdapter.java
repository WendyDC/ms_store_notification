package co.com.wenstore.events;

import co.com.wenstore.model.messagenotification.MessageNotification;
import co.com.wenstore.model.messagenotification.gateways.MessageNotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class DomainEventPublisherAdapter implements MessageNotificationRepository {

    private final ReactiveEventsGateway reactiveEventsGateway;

    @Override
    public Mono<Void> sendNotification(MessageNotification messageNotification) {
        return reactiveEventsGateway.emit(messageNotification);
    }
}
