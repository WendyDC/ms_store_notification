package co.com.wenstore.model.messagenotification;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class MessageNotification {
    String content;
    String type;
    String destination;
    String userId;
}
