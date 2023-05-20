## 목차
[](#)   
[](#)   
[](#)   
[](#)   
[참고자료](#참고자료)   

## ****19.1 NIO 소개****

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/a5e183cf-5be3-4f7c-81ac-4d791474622d/Untitled.png)

- NIO: java.io 뿐만 아니라 java.net API와 다른 새로운 입출력 API를 말함
- IO와 NIO의 차이점
    - 입출력 방식
        - 스트림 방식: 데이터가 단방향으로 전송되는 방식
        - 채널 방식: 양방향
    - 버퍼 방식
        - IO:
            - 기본적으로 버퍼를 사용하지 않음
            - 버퍼 기능을 제공하기 위해서 bufferedOutputStream과 같은 보조 스트림을 제공
        - NIO: 버퍼가 기본이며, 무조건 버퍼에서 읽고 씀
    - 동기/비동기
        - IO: IO에 있는 API를 호출하게 되면, 그 API가 작업을 다 마쳐야 다음 작업 가능
        - NIO: 비동기도 지원하기 때문에, NIO에 있는 API를 호출하고 나서 그 즉시 다른 작업 가능
    - 블로킹/넌블로킹
        - IO: 어떤 작업이 완료될 때까지 대기
        - NIO: 대기 상태 없이도 API 사용 가능

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/e6615f4d-ff72-4ea6-a453-eb5054c13d01/Untitled.png)

- 스트림/채널
    - IO: 데이터 흐름이 단방향이므로, 입력 스트림과 출력 스트림을 각각 생성해야 함
    - NIO: 양방향 채널로부터 데이터를 입력 또는 출력함
- 버퍼/넌버퍼
    - IO: 입력 데이터의 위치를 이동해가면서 자유롭게 이용할 수 없음
        
        → EX) 어떤 소스(파일/네트워크)에서 입력 스트림으로 데이터를 받은 후, 데이터를 소비했다고 가정
        
        ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/c7459f0d-5da3-4830-ac4a-b92485dd0be2/Untitled.png)
        
        → 이 때, 처음으로 돌아가서, 입력받은 데이터를 재사용할  수 없음
        
        → 입력 스트림을 통해 얻은 데이터는 재사용을 못 하기 때문에
        
        (버퍼를 사용하지 않기 때문에, 데이터를 받는 즉시, 이용하고 끝남)
        
        → 입력 스트림으로 받은 데이터를 어딘가에 저장해 놓아야 재사용 가능
        
    - NIO
        - 입력 데이터:
            
            → 채널로부터 데이터를 읽고,
            
            → 프로그램에서 바로 데이터를 받는 게 아니라, 그 전에 버퍼에 데이터를 받음
            
            → 버퍼에 저장된 데이터를 프로그램에서 가져와서 씀
            
        - 출력 데이터:
            
            → 프로그램에서 바로 데이터를 출력하는 게 아니라, 버퍼에 일단 출력
            
            → 버퍼가 목적지로 데이터를 출력
            

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/e651451e-97d7-4baa-8317-12012c2984d8/Untitled.png)

- 블로킹/넌블로킹
    - IO:
        - read() 메서드 실행 시, 상대방이 데이터를 보내기 전까지는 스레드가 대기상태가 됨
        - write() 도 동일
        - 스레드를 종료시키는 방법인 interrupt를 해서 블로킹(대기 상태)을 빠져나올 수 없음
        - 블로킹을 빠져 나오려면 InputStream 또는 OutputStream을 닫아야 함
    - NIO: 그림 참조






## 참고자료

[강의교안_19장.ppt](https://github.com/abarthdew/this-is-Java/blob/main/00.basics/files/%EA%B0%95%EC%9D%98%EA%B5%90%EC%95%88_19%EC%9E%A5.ppt)