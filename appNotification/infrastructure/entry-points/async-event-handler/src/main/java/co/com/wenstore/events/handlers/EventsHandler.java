package co.com.wenstore.events.handlers;

import co.com.wenstore.model.messagenotification.MessageNotification;
import co.com.wenstore.usecase.notification.NotificationUseCase;
import lombok.AllArgsConstructor;
import org.reactivecommons.api.domain.DomainEvent;
import org.reactivecommons.async.impl.config.annotations.EnableEventListeners;
import reactor.core.publisher.Mono;
import lombok.extern.java.Log;
import java.util.logging.Level;

@Log
@AllArgsConstructor
@EnableEventListeners
public class EventsHandler {

    private final NotificationUseCase notificationUseCase;

    public Mono<Void> handleEventA(DomainEvent<MessageNotification> event) {
        log.log(Level.INFO, "Event received: {0} -> {1}", new Object[]{event.getName(), event.getData()});
        return notificationUseCase.notify(event.getData());
    }
}
