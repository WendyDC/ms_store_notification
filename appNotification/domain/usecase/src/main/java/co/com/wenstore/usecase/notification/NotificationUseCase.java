package co.com.wenstore.usecase.notification;

import co.com.wenstore.model.messagenotification.MessageNotification;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class NotificationUseCase {
    public Mono<Void> notify(MessageNotification message){
        System.out.println("Star message..");
        System.out.println(message.getContent());
        System.out.println(message.getType());
        System.out.println(message.getDestination());
        System.out.println(message.getUserId());
        System.out.println("End message..");
        return Mono.empty();
    }
}
