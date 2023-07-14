public class Wait2Exam {
  public static void main(String[] args) {

    DataBox dataBox = new DataBox(); // 공유객체 생성
    ProducerThread p = new ProducerThread(dataBox);
    ConsumerThread c = new ConsumerThread(dataBox);
    p.start();
    // 3번 반복 실행, 공유 객체에 데이터 set
    c.start();
    // 3번 반복 실행, 공유 객체에서 데이터 get, 읽어 옴

        /*
        (실행결과): producer 스레드가 공유 객체에 데이터를 set하면, consumer 스레드가 데이터를 get 해서 읽는다(이 과정을 3번 번갈아서 함)
        ProducerThread가 생성한 데이터: Data: 0
        ConsumerThread가 읽은 데이터: Data: 0  
        ProducerThread가 생성한 데이터: Data: 1
        ConsumerThread가 읽은 데이터: Data: 1  
        ProducerThread가 생성한 데이터: Data: 2
        ConsumerThread가 읽은 데이터: Data: 2
        ProducerThread가 생성한 데이터: Data: 3
        ConsumerThread가 읽은 데이터: Data: 3
         */
  }
}
