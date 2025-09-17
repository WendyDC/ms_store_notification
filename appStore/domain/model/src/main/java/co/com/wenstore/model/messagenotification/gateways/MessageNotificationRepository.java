package co.com.wenstore.model.messagenotification.gateways;

import co.com.wenstore.model.messagenotification.MessageNotification;
import reactor.core.publisher.Mono;

public interface MessageNotificationRepository {
    public Mono<Void> sendNotification(MessageNotification messageNotification);
}
