import java.util.LinkedList;
import java.util.Queue;

public class QueueExam {
    public static void main(String[] args) {
        
        Queue<MessageQ> msg = new LinkedList<>();
        msg.offer(new MessageQ("sendMail", "홍길동"));
        msg.offer(new MessageQ("sendSMS", "홍길동2"));
        msg.offer(new MessageQ("sendTalk", "홍길동3"));

        while(!msg.isEmpty()) {
            MessageQ m = msg.poll();
            switch(m.command) {
                case "sendMail":
                    System.out.println(m.to + " 에게 보냄");
                    break;
                case "sendSMS":
                    System.out.println(m.to + " 에게 보냄");
                    break;
                case "sendTalk":
                    System.out.println(m.to + " 에게 보냄");
                    break;
            }
        }
        /* (순서대로 출력됨)
        홍길동 에게 보냄
        홍길동2 에게 보냄
        홍길동3 에게 보냄
         */
    }
}
