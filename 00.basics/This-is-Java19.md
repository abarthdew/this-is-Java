## 목차

[19.1 NIO 소개](#191-nio-소개)   
[19.2 파일과 디렉토리](#192-파일과-디렉토리)   
[19.3 버퍼](#193-버퍼)   
[- 예제 - 18.3.buffer](#예제---183buffer)   
[19.4 파일 채널](#194-파일-채널)   
[](#)   
[](#)   
[참고자료](#참고자료)

## ****19.1 NIO 소개****

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/19.png)

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

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/19(1).png)

- 스트림/채널
    - IO: 데이터 흐름이 단방향이므로, 입력 스트림과 출력 스트림을 각각 생성해야 함
    - NIO: 양방향 채널로부터 데이터를 입력 또는 출력함
- 버퍼/넌버퍼
    - IO: 입력 데이터의 위치를 이동해가면서 자유롭게 이용할 수 없음

      → EX) 어떤 소스(파일/네트워크)에서 입력 스트림으로 데이터를 받은 후, 데이터를 소비했다고 가정

      ![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/19(2).png)

      → 이 때, 처음으로 돌아가서, 입력받은 데이터를 재사용할 수 없음

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

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/19(3).png)

- 블로킹/넌블로킹
    - IO:
        - read() 메서드 실행 시, 상대방이 데이터를 보내기 전까지는 스레드가 대기상태가 됨
        - write() 도 동일
        - 스레드를 종료시키는 방법인 interrupt를 해서 블로킹(대기 상태)을 빠져나올 수 없음
        - 블로킹을 빠져 나오려면 InputStream 또는 OutputStream을 닫아야 함
    - NIO: 그림 참조

## ****19.2 파일과 디렉토리****

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/19(4).png)

- Path 객체를 얻는 여러 가지 코드

  → 절대 경로, 상대 경로 전부 매개 값으로 올 수 있음

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/19(5).png)

- compareTo(): 다른 Path와 현재 Path를 비교
- toFile(): 현재 Path 객체를 File 객체로 리턴

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/19(6).png)

- 드라이버 정보: :C, :D 등
- Iterable<FileStore> : FileStore를 반복할 수 있는 Iterable 반복자를 리턴 한다는 뜻

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/19(7).png)

- 속성: 숨김인지, 디렉토리 여부, 크기나 소유자는 어떻게 되는지 등

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/19(8).png)

- newBufferedReader(): BufferedReader를 만들 때, FileReader를 만들고 보조 스트림으로 BufferedReader를 연결하는데, newBufferedReader() 메서드를
  이용하면 바로 BufferedReader를 얻을 수 있음
- newBufferedWriter(): 마찬가지로, BufferedWriter 를 바로 리턴 가능

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/19(9).png)

```java
path.register( // 해당 디렉토리의 path 객체를 얻은 후, register() 메서드 호출
	watchService,
	StandardWtchEventKinds.ENTRY_CREATE, // 생성을 감시할 때
	StandardWtchEventKinds.ENTRY_MODIFY, // 수정 
	StandardWtchEventKinds.ENTRY_DELETE, // 삭제
	// 다 쓰면 모두 다 감시
);
```

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/19(10).png)

- WatchService를 등록한 디렉토리 내부에서 변경이 발생할 경우
    - WatchEvent 발생

      → WatchService는 해당 이벤트 정보를 가진 WatchKey를 생성

      → 이 WatchKey를 큐에 저장

    - 저장된 WatchKey는 프로그램에서 take() 메서드를 이용하면 얻을 수 있음
- 이벤트 처리 코드 작성 방법
    - WatchKey가 큐에 들어오지 않았다면, 디렉토리 내부에서 변경이 발생하지 않은 것
    - take() 메서드는 WatchKey가 큐에 들어올 때까지 대기함

    1. 디렉토리 내부 변경 발생 → WatchKey가 큐에 저장 → take()가 WatchKey를 얻어 리턴

    - WatchKey 안에는 디렉토리 안에서 변경된 내용이 있음

      → 파일 생성, 수정, 삭제 등 해당 이벤트 정보

    1. WatchKey로 부터 WatchEvent 리스트 획득

       → 여러 개의 WatchEvent가 발생할 수 있으므로 리스트로 리턴됨

       → 파일을 동시에 여러 개 선택해서 삭제할 경우 등

    ![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/19(11).png)
    
    1. WatchKey로부터 WatchEvent 컬렉션을 얻었다면, WatchEvent를 하나씩 처리해야 함
        
        ```java
        List<WatchEvent<?>> list = watchKey.pollEvents(); // watchKey로부터 WatchEvent 리스트 얻기
        for (WatchEvent watchEvent : list) {
        	// watchEvent를 하나씩 얻어 작업
        
        	// 이벤터 종류 얻기: watchEvent가 왜 발생했는가?
        	Kind kind = watchEvent.kind();
        	
        	if (kind == standardWatchEventKinds.ENTRY_CREATE) {
        		// 디렉토리나 파일이 생성되었을 경우, 실행할 코드
        	} else if (kind == standardWatchEventKinds.ENTRY_DELETE) {
        		// 삭제되었을 경우, 실행할 코드
        	} else if (kind == standardWatchEventKinds.ENTRY_MODIFY) {
        		// 변경되었을 경우, 실행할 코드
        	} else if (kind == standardWatchEventKinds.OVERFLOW) {
        		// 운영체제에서 이벤트가 소실됐거나 버려진 경우: 잘 처리하지 않음
        	}
        
        	// 감지된 Path 얻기: 어떤 파일에서 변화가 감지됐는가?
        	Path path = (Path) watchEvent.context();
        }
        ```
        
    2. WatchKey를 reset() 하는 작업
        - 새로운 WatchEvent가 발생하면, 큐에 다시 들어가기 때문
            - true 리턴: 초기화에 성공
                
                → 다시 while 문 실행
                
                → 다시 take() 가 큐에서 watchKey를 기다림
                
                → watchKey 들어옴 → 반복
                
            - false 리턴: 감시하는 디렉토리가 삭제되었거나 키가 더 이상 유효하지 않을 경우(더 이상 감시할 필요가 없음)
    3. WatchService 종료(close)

[https://www.youtube.com/watch?v=i0h8VvJHA6I&list=PLVsNizTWUw7FPokuK8Cmlt72DQEt7hKZu&index=216&ab_channel=한빛미디어](https://www.youtube.com/watch?v=i0h8VvJHA6I&list=PLVsNizTWUw7FPokuK8Cmlt72DQEt7hKZu&index=216&ab_channel=%ED%95%9C%EB%B9%9B%EB%AF%B8%EB%94%94%EC%96%B4)

47:00 javaFX 다시 참조

## ****19.3 버퍼****

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/19.png)

- 프로그램이 입력 소스로부터 데이터를 입력 받을 때

  → 버퍼에 먼저 저장

  → 프로그램은 버퍼에서 데이터를 얻음

- 프로그램이 어떤 데이터를 목적지로 보낼 때

  → 데이터를 일단 버퍼에 저장

  → 버퍼에 있는 데이터를 목적지로 보냄

- 버퍼는 NIO에서 필수적으로 사용되는 객체
- Buffer 분류 기준: 어떤 메모리를 사용하느냐에 따른 분류
    - 다이렉트: 운영체제가 관리하는 메모리를 이용
    - 넌다이렉트: JVM이 관리하는 메모리를 이용

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/19.png)

- ByteBuffer: byte 데이터를 저장하는 버퍼
- Char, Short, Int, LongBuffer: 정수를 저장하는 버퍼
- Float, DoubleBuffer: 실수를 저장하는 버퍼
- 주로 ByteBuffer를 많이 씀

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/19.png)

- 넌 다이렉트 버퍼
    - 버퍼 크기를 크게 잡을 수 없음

      → 운영체제가 JVM에 할당한 메모리 범위 내에서 사용해야 하기 때문

    - 넌 다이렉트 버퍼가 입출력을 하게 되면

      → 내부적으로 다이렉트 버퍼를 이용

      → 다이렉트 버퍼를 생성해서, 데이터(넌 다이렉트 버퍼)를 복사하고 난 후, 입출력을 함

    - 상대적으로 다이렉트 직접 버퍼를 이용하는 것보다, 넌 다이렉트 버퍼의 입출력 속도는 늦음
- 다이렉트 버퍼
    - native C 함수를 호출해서 다이렉트 버퍼를 생성해야 하기 때문에, 넌 다이렉트 버퍼보다 생성 시간이 다소 걸림

### 예제 - 18.3.buffer

- 다이렉트 버퍼는 생성되지만, 넌 다이렉트 버퍼는 생성되지 않음(OutOfMemoryError)

  ![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/19.png)

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/19.png)

- 버퍼를 생성하기 위해선 각 버퍼 클래스의 allocate() 메서드 호출
- wrap() 메서드

    ```java
    byte[] byteArr = new byte[100]; // 이미 byte 배열이 생성되어 있고,
    ByteBuffer byteBuffer = ByteBuffer.wrap(byteArr); // byteArr 바이트 배열을 wrapping 해서 byteBuffer를 만듦
    ```

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/19.png)

- Char, IntBuffer 등에서는 없고, ByteBuffer에서만 allocateDirect() 메서드가 제공됨
- 예시

    ```java
    ByteBuffer byteBuffer = ByteBuffer.allocateDirect(저장할 수 있는 바이트 수);
    ```

    - 운영체제가 관리하는 메모리에 버퍼를 만들어 리턴
- asXXXBuffer(): Char, IntBuffer 등을 사용하는 방법

    ```java
    ByteBuffer byteBuffer = ByteBuffer.allocateDirect(100); // 100개의 바이트 값 저장
    CharBuffer charBuffer = ByteBuffer.allocateDirect(100).asCharBuffer(); // 50개 char 값 저장(char 한 문자당 2바이트 차지)
    IntBuffer intBuffer = ByteBuffer.allocateDirect(100).asIntBuffer(); // 25개 int 값 저장 (int 한 문자당 4바이트 차지)
    ```

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/19.png)

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/19.png)

- JVM은 무조건 big endian이지만, JVM을 사용하지 않을 경우, ByteOder 클래스로 데이터 순서를 맞춰야 함
- order(): JVM이 운영체제의 바이트 해석 순서와 JVM의 해석 순서를 맞춤

    ```java
    ByteBuffer byteBuffer = ByteBuffer.allocateDirect(100).order(ByteOrder.nativOrder());
    // 이렇게 얻어진 byteBuffer를 입출력에 사용하게 되면, 성능에 도움이 됨
    ```

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/19.png)

- 버퍼를 사용하려면, 위치 속성을 잘 알고 있어야 함

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/19.png)

1. **쓰기 모드**
2. 7 바이트 크기의 바이트 배열을 생성했다고 가정

   ![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/19.png)

    - position(읽고 쓰기 위한 위치): 제일 처음 버퍼를 생성했기 때문에 0 (제일 처음에는 읽은 값도, 쓴 값도 없으므로 0)
    - capacity: 실제 버퍼에 저장될 수 있는 최대 데이터 개수 7
    - limit(읽거나 쓰기 위한 한계 값): 처음 버퍼가 생성되면, limit은 capacity와 같음
3. 2 바이트를 버퍼에 저장

   ![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/19.png)

    - position: 2, 이 자리에 다음 데이터, 즉 다음 바이트를 저장할 수 있다는 위치 정보를 알려 줌
    - capacity, limit: 변함 없음
4. 추가로 3 바이트를 버퍼에 저장

   ![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/19.png)

    - position: 2 + 3 = 5
5. 쓰기 모드 → **읽기 모드로 변경**

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/19.png)

1. 읽기 모드로 변경하기 위해 flip() 메서드 호출

   ![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/19.png)

    - position
        - 직전 position: 5
        - flip() 호출 → position: 0 (맨 앞으로 이동)
        - (맨 앞부터 읽겠다는 의미)
    - limit
        - 직전 limit: 7
        - flip() 호출 → limit: 5 (데이터가 저장된 그 다음 인덱스)
        - 원래 position이 있던 자리
        - position ~ limit 까지의 범위를 읽을 수 있다는 의미를 가짐
        - 실제 데이터는 limit - 1 까지고, limit 자리에는 데이터가 없음
2. 버퍼에서 3 바이트를 읽음

   ![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/19.png)

    - position: 3 (0부터 2까지 3 바이트 읽음)

      → limit 앞까지 2바이트 더 읽을 수 있음

    - limit: 5
    - capacity: 7
3. 현재 position의 위치를 기억시키기 위해 mark() 호출

   ![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/19.png)

    - 현재 position: 3 → mark() 호출
    - 3 인덱스에 mark 위치 속성이 생김(mark에 3 저장됨)
4. 2 바이트를 추가로 읽음

   ![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/19.png)

    - position: 5 (mark 부터 2 바이트 읽음)
    - position과 limit의 값이 같아짐

      → 이 상태가 되면 더 이상 데이터를 읽을 수 없어짐

      → position = limit 이므로, 이후부터는 데이터가 없음

5. reset()

   ![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/19.png)

    - reset()을 호출하게 되면 position이 mark 위치로 가게 됨
6. rewind()

   ![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/19.png)

    - position = limit일 경우, 즉, position ~ limit 사이 데이터를 모두 읽었을 경우

      → rewind() 호출

      → position이 제일 처음으로 돌아감

    - 그러므로, position: 0부터 다시 데이터를 읽을 수 있음
    - position 또는 limit이 mark보다 더 앞쪽 인덱스로 가면, mark는 자동적으로 없어짐
7. clear()

   ![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/19.png)

    - 만약, position = 5, limit = 5로, 0~4 인덱스까지 버퍼를 다 읽었을 때를 가정

      → clear()

      → position은 제일 앞으로, limit은 제일 뒤로 감(limit = capacity)

8. compact()

   ![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/19.png)

    - a, b, c, d, e가 저장된 버퍼에서 a, b, c를 읽었을 때 (아직 d를 읽지 않은 경우)

      → compact()

      → d, e가 제일 앞으로 저장됨

      → position이 e 다음에 위치함

    - compact()를 사용하는 이유:
        - 처음에 5개의 바이트를 저장했다가, 3개를 읽고 나서 2개는 놔둔 상태

          → 새로운 데이터를 버퍼에 저장해야 할 필요성이 생겼을 때

        ![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/19.png)
        
        - 이 경우는 저장을 할 수 없는 상태임
            
            → limit이 5 위치기 때문에 이후로 데이터를 저장할 수 없음
            
            → position이 d 위치고, d, e를 아직 읽지 않은 상태라, d가 위치한 인덱스 3을 관리해야 함
            
            → 복잡해짐
            
        - 때문에, 새로운 데이터를 저장하려면, compact() 호출
            
            ![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/19.png)
            
            → 읽지 않은 데이터를 버퍼 제일 앞으로 보냄
            
            → position을 읽지 않은 데이터 다음에 위치시킴
            
            → 2 인덱스부터 새로운 데이터 저장 가능하도록 함
            
            → limit은 제일 뒤로 뺌(=capacity)
            
        - 만약 4 인덱스 까지 데이터가 저장된 상태에서, flip() 을 호출하면?
            
            ![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/19.png)
            
            → position: 5 ⇒ 0
            
            → limit: capacity ⇒ 5
            
            ⇒ 0 부터 5 까지 데이터 읽기 가능

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/19.png)

- 공통 메서드: 모든 종류의 버퍼가 가지고 있는 메서드
- array(): 버퍼를 생성할 때 제공한 배열을 리턴
- arrayOffset(): wrap으로 만든 내부 배열의 인덱스를 리턴
    - 항상 버퍼가 0 인덱스 부터 사용하는 건 아님
    - 배열의 몇 번째 부터, 버퍼의 첫번째 요소가 될 것이냐, 그 요소의 순번을 리턴
- isDirect(): 다이렉트 버퍼인지 검증

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/19.png)

- ↓상대적 get과 절대적 get 예시

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/19.png)

- (매개값이 없는)상대적 get 메서드를 호출하게 되면, 해당 버퍼의 position이 1씩(또는 저장한 갯수 만큼) 증가함

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/19.png)

- 상대적 put 메서드를 호출하게 되면, position이 1씩(또는 저장한 갯수 만큼) 증가함

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/19.png)

- BufferOverflowException: 버퍼 초과
- ReadOnlyBufferException: put()은 저장하는 것이고, compact()는 아직 읽지 않은 데이터를 맨 앞으로 저장하는 것이기 때문에, 읽기 전용에서 호출 시 예외 발생

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/19.png)

- 데이터를 입력/출력 하기 위해서는 반드시 채널을 사용해야 함
- 채널이 데이터를 저장하는 곳, 채널이 출력할 데이터가 있는 곳 모두 ByteBuffer
- 데이터 입출력 전에 반드시 ByteBuffer를 생성해야 함
- ByteBuffer ↔ String
    1. 지정한 문자셋을 얻음
    2. String → ByteBuffer: 인코딩
    3. ByteBuffer → String: 디코딩

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/19.png)

- IntBuffer → ByteBuffer

    ```java
    ByteBuffer byteBuffer 
    	= ByteBuffer.allocate(
    		intBuffer.capacity() // capacity: new int[] {10, 20} => 2
    		* 4 // int = byte * 4 므로, ByteBuffer에 int를 담으로면 4배 필요
    	);
    
    for (int i=0; i<intBuffer.capacity(); i++) { // 2번 돔
    	byteBuffer.putInt(intBuffer.get(i)); // byteBuffer에 intBuffer의 정수값을 하나씩 저장
    }
    byteBuffer.flip(); // 읽기 모드로 바꿈
    ```

- ByteBuffer → IntBuffer

    ```java
    ByteBuffer byteBuffer = ...;
    IntBuffer intBuffer = byteBuffer.asIntBuffer(); // 바로 IntBuffer 얻을 수 있음
    
    // IntBuffer로 다시 int 배열 만들기
    int[] data = new int[intBuffer.capacity()]; // int 배열 길이
    intBuffer.get(data); // intBuffer 값을 data 배열에 저장
    System.out.println("읽은 배열: " + Arrays.toString(data));
    ```

## ****19.4 파일 채널****

## 참고자료

[강의교안_19장.ppt](https://github.com/abarthdew/this-is-Java/blob/main/00.basics/files/%EA%B0%95%EC%9D%98%EA%B5%90%EC%95%88_19%EC%9E%A5.ppt)