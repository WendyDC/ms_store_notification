package co.com.wenstore.events;
import co.com.wenstore.events.handlers.EventsHandler;
import co.com.wenstore.model.messagenotification.MessageNotification;
import org.reactivecommons.async.api.HandlerRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HandlerRegistryConfiguration {

    @Bean
    public HandlerRegistry handlerRegistry(EventsHandler events) {
        return HandlerRegistry.register()
                .listenEvent("notifyOrder",
                        events::handleEventA,
                        MessageNotification.class);
    }
}
