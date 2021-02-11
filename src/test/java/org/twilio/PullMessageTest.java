package org.twilio;

import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;
import org.junit.Test;

import java.time.*;

public class PullMessageTest {

    private final String ACCOUNT_SID = "AC84907b899792295c95d6e9716e7bafae";
    private final String AUTH_TOKEN = "31b52b3b006cbf8e853f442da23ee18a";
    private final ZonedDateTime DATETIME = ZonedDateTime.now();


    @Test
    public void pullMessage() {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        ResourceSet<Message> messages = Message.reader()
                                               .setDateSentBefore(
                                                       DATETIME)
                                               .limit(20)
                                               .read();

        System.out.println("FIRST MESSAGE?!?!?!: " + messages.iterator().next());

        for(Message record : messages) {
            System.out.println(record.toString());
            System.out.println(record.getBody());
        }
    }

}
