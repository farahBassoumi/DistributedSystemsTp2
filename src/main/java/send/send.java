package send;
import com. rabbitmq. client. ConnectionFactory;
import com. rabbitmq.client.Connection;
import com. rabbitmq. client.Channel;
import data.data;
import JdbcRetrieve.JdbcRetrieve;

import java.util.Vector;

public class send {
    public String QUEUE_NAME ;

    public  send(String BO) throws Exception {
        QUEUE_NAME = BO;
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            JdbcRetrieve R = new JdbcRetrieve();
            Vector<data> d = R.Retrieve(QUEUE_NAME);
            String msg ;
            for(data dt : d){
                msg = dt.toString();
                channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());
            }
        }
    }
}
