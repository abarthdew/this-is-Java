public class DataBox {

    private String data;

    public synchronized void setData(String data) {
        if (this.data != null) { // 데이터가 null이 아닐 경우
            try {
                wait(); // 일시 정지
            } catch (InterruptedException e) {}
        }
        this.data = data; // data가 있을 경우 set 후 출력
        System.out.println("ProducerThread가 생성한 데이터: " + data);
        notify(); // 다른 스레드(ConsumerThread)를 실행 대기로 만듦
    }

    public synchronized String getData() {
        if (this.data == null) { // 읽을 데이터가 없는 경우
            try {
                wait(); // 일시 정지
            } catch (InterruptedException e) {}
        }
        String returnValue = data; // 데이터가 있으면 출력
        System.out.println("ConsumerThread가 읽은 데이터: " + returnValue);
        data = null; // 데이터 읽은 후 null 초기화
        notify(); // 다른 스레드(ProducerThread)를 실행 대기로 만듦, 다른 데이터가 set 되도록 함
        return returnValue; // 읽은 데이터 return
    }

}
