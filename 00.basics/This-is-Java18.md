## 목차

[18.1 IO 패키지 소개](#181-io-패키지-소개)   
[18.2 입력 스트림과 출력 스트림](#182-입력-스트림과-출력-스트림)   
[18.3 콘솔 입출력](#183-콘솔-입출력)   
[- 예제 18.3.1 - 명령 프롬프트에서 실행하기](#예제-1831---명령-프롬프트에서-실행하기)   
[18.4 파일 입출력](#184-파일-입출력)   
[]()   
[참고자료](#참고자료)

## ****18.1 IO 패키지 소개****

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/18.png)

- IO: input / ouput의 약자
- 자바에서는 데이터를 input/output하기 위해 java.io 패키지를 제공함
- 이 패키지에 있는 클래스를 이용해 데이터 입출력 가능
- File: 파일의 이름, 경로, 크기, 속성(읽기 전용/쓰기 전용)
- **InputStream/OutputStream**: 바이트를 읽고 쓰기 위해 사용하는 클래스

  ![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/18(1).png)

  ⇒ InputStream/OutputStream을 상속해서 만든 하위 스트림

    - `FileInputSTream/FileOutputStream`: 하위 스트림을 이용해 파일에 데이터를 저장하고 읽을 수 있음
    - `DataInputStream ~ BufferedOutputStream`: 좀 더 편하게 입출력을 하기 위해 사용하는 보조 스트림
- **Reader/Writer:** InputStream/OutputStream이 바이트 단위로 입출력을 한다면, Reader/Writer는 문자 단위로 입출력

  ![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/18(2).png)

  ⇒ Reader/Writer를 상속해서 만든 하위 스트림

    - `FileReader/FileWriter`: 파일에서 문자를 읽음/파일에서 문자를 저장
    - `InputStreamReader/OutputStreamReader`: 바이트 스트림을 문자 스트림으로 변경
    - `PrintwWriter`: 문자를 출력
    - `BufferedReader/BufferedWriter`: 성능 향상을 위해 사용하는 보조 스트림

## ****18.2 입력 스트림과 출력 스트림****

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/18(3).png)

- [프로그램]을 기준으로, 데이터가 들어오게 되면 입력 스트림을,
- 데이터가 나가고 있다면 출력 스트림을 이용해야 함
- 스트림: 흐름
- 입력 스트림: 데이터가 들어오는 흐름
    - 입력 스트림의 데이터 출발지: 키보드, 파일, 프로그램

      ⇒ 여기서부터 데이터가 흘러 들어오면, [프로그램]에서는 입력 스트림을 통해 데이터를 읽음

- 출력 스트림: 데이터가 나가는 흐름
    - [프로그램]에서 데이터가 나가게 되면 도착지는 모니터, 파일, 프로그램이 됨

1. 데이터가 [프로그램]으로 들어올 경우와,
2. 데이터가 [프로그램]에서 나가는 경우를 따로 생각해 보면 이런 식임

   ![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/18(4).png)

- 각 프로그램을 기준으로 데이터가 들어오면 입력 스트림,
- 데이터가 나가면 출력 스트림임
- 예) A가 출력 스트림을 통해 데이터를 보내면, B는 입력 스트림을 통해 데이터를 받음
- 예) A가 입력 스트림을 통해 데이터를 받고 싶다면, B가 먼저 출력 스트림을 통해 데이터를 보내 줘야 함
- 출발지: 데이터가 출발하는 곳(출력 스트림 이용)
- 도착지: 데이터가 도착하는 곳(입력 스트림 이용)

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/18(5).png)

- 스트림은 크게 바이트 기반 스트림과 문자 기반 스트림으로 나뉨
    - 바이트 기반 스트림: 스트림을 통해 주고받은 데이터가 바이트일 때

      ⇒ **그림, 멀티미디어, 문자 등 모든 종류 데이터** 받고 보내기 가능

      ⇒ 최상위 클래스: InputStream / OutputStream

    - 문자 기반 스트림: 스트림을 통해 주고받은 데이터가 문자일 때

      ⇒ **문자 데이터만** 받고 보내기 가능

      ⇒ 최상위 클래스: Reader / Writer

- 바이트 기반 스트림과 문자 기반 스트림
    - `FileInputStream`: 파일에서 바이트를 읽고 싶을 때 사용
    - `FileOutputStream`: 파일로 바이트 데이터를 저장하고 싶을 때 사용
    - `FileReader`: 문자 파일에서 문자 데이터를 읽고 싶을 때 사용
    - `FileWriter`: 문자 데이터를 파일에 저장하고 싶을 때 사용

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/18(6).png)

- InputStream은 추상 클래스이므로 new 연산자를 이용해 생성할 일이 없음
- InputStream을 상속받은 하위 클래스, 즉 구현 클래스로 객체를 만들어 사용할 수 있음
- InputStream의 주요 메서드
    - `read()`: read()가 읽은 1바이트가 int 타입(4바이트) 가장 끝에 저장됨

      ⇒ 1바이트를 읽고 그 읽은 바이트를 int 타입으로 리턴

    ![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/18(7).png)
    
    - `read(byte[] b)`: 주어진 byte 배열의 길이만큼 데이터를 읽어 매개변수 byte[]에 저장하고, 실제 읽은 바이트 수를 int 로 리턴
        
        ⇒ 5byte를 읽었다면, 그 데이터는 (byte[] b)에 저장되고, 리턴값은 5가 나옴
        
    - `read(byte[] b, int off, int len)`:
        - 읽은 데이터를 매개변수 byte[] 배열에 저장
        - 어떤 위치에 저장할 건지 2, 3번째 매개변수로 지정
        
        ⇒ 길이가 5인 배열의 2번째 인덱스부터 2개를 읽고 저장
        
        ![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/18(8).png)
        
    - `close()`: InputStream 사용 후 닫을 때 사용

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/18(9).png)

- 1바이트를 읽고, 읽은 바이트를 리턴
- InputStream로부터 5개의 바이트가 들어온다면, read()는 5번 실행해서 읽음
- 읽힌 바이트는 int 타입의 끝에 저장되고 리턴됨
- (1) 바이트를 읽고, int 타입의 끝에 저장 / (2)를 읽고, int 타입의 끝에 저장 / (3), (4)도 동일

  ![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/18(10).png)

    - 즉, (1), (2), (3), (4), (5)인 5 개의 byte가 InputStream으로 들어 옴
    - new FileInputStream(”C:/test.jpg”); 객체 생성
    - (”C:/test.jpg”)에 5byte의 파일이 주어져 있기 때문에, FileInputStream으로 만들어 InputStream 타입으로 대입
    - int readByte 변수 선언
    - readByte에는 is.read()로 InputStream으로부터 읽은 데이터가 저장됨
    - 처음 is.read()가 실행되면, (1)을 읽고 저장

      → 읽은 데이터 readByte는 -1이 되지 않으므로 다시 반복

      → is.read() 다시 실행, (2)을 읽고 저장

      → 반복 → (3), (4), (5) 모두 읽음

      → 더 이상 읽을 데이터가 없으면 is.read()는 -1을 리턴 → 반복문 탈출

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/18(11).png)

- 매개값으로 byte 배열을 받는 read() 메서드
- InputStream에서 5개의 byte가 들어 올 경우, read() 메서드는 어떻게 데이터를 읽는가?
    - 매개값으로 들어오는 byte 배열이 길이가 3이라고 가정할 때,

  ![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/18(12).png)

    1. 첫번째 읽을 경우
        - read() 메서는 3byte를 읽고 (1), (2), (3)을 차례로 0, 1, 2 인덱스에 저장
        - 3byte를 읽었으므로, read(byte[] b)의 리턴값은 3

  ![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/18(13).png)

    1. 두번째 읽을 경우
        - 남은 2byte (4), (5)를 byte 배열의 0, 1 인덱스에 저장
        - 실제 읽은 데이터는 0, 1 인덱스에만 저장됨
        - 다음에 오는 byte가 없으므로 2인덱스에는 1.(첫번째) 에서 읽은 (3)이 남아 있음
        - read() 메서드는 2byte를 읽고 저장했으므로 2 리턴
- 코드 확인

    ```java
    InputStream is = new FileInputStream("c:/test.jpg"); // FileInputStream을 이용해 객체 생성, InputStream에 대입
    int readByteNo;
    byte[] readBytes = new byte[3]; // 길이 3짜리 byte 배열 생성
    while(
    	(readByteNo // is.read(ReadBytes)에서 읽은 바이트 수 리턴
    		= is.read(ReadBytes) // read() 메서드는 반복마다 3바이트씩 읽음(5byte를 읽는 경우, 첫번째 3byte, 두번째 2byte 읽음)
    ) != -1) {...}
    ```

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/18(14).png)

- InputStream으로 5개의 byte가 들어온다고 가정

  ⇒ 해당 read() 메서드는 5byte 중 3만큼 데이터를 읽은 뒤 2 인덱스 부터 (1), (2), (3) 3개를 저장하고, 3을 리턴

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/18(15).png)

- 추상 클래스이므로 new 연산자로 객체 생성 불가
- 대신, OutputStream을 상속한 하위 클래스로 객체를 생성해, OutputStream 내 메서드 사용 가능
- 주요 메서드
    - write(int b): 매개타입 int 타입의 4byte 크기 중, 끝 1byte만 출력
    - write(byte[] b): byte 배열 전체 출력
    - flush(): write를 하면 데이터가 바로 출력되는 게 아니라, 메모리 버퍼에 쌓였다가, 메모리 버퍼가 꽉 차면 비로소 데이터를 출력함.

      ⇒ 데이터가 메모리 버퍼에 꽉 차지 않을 경우, 강제적으로 데이터를 출력하도록 만들어 줌.

      ⇒ write() 메서드 호출 후 flush() 호출 해야 데이터가 완전하게 전송됨

    - close(): 더 이상 OutputStream을 쓰지 않을 때 사용

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/18(16).png)

- int가 4byte라고 해서 4byte를 출력하지 않음

  ⇒ int의 끝자리 1byte만 출력

- 코드: ABC라는 코드를 C:/test.txt에 1byte씩 저장하는 코드

    ```java
    OutputStream os = new FileOutputStream("C:/test.txt"); // C:/test.txt파일의 FileOutputStream 생성
    byte[] data = "ABC".getBytes(); // 바이트 배열 얻기
    for (int i=0; i<data.length; i++) {
    	os.wrrite(data[i]); // "A", "B", "C"를 하나씩 출력
    }
    ```

- 결과

  ![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/18(17).png)

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/18(18).png)

- write() 메서드의 인자인 byte[] b의 길이가 5일 때, write() 메서드는 byte[] 배열의 모든 데이터를 출력시킴
- 이전 예제와 다른 점

    ```java
    // write(int b)
    for (int i=0; i<data.length; i++) {
    	os.wrrite(data[i]); // for 문을 이용해 1byte씩 출력
    }
    
    // write(byte[] b)
    os.write(data); // 주어진 byte 배열을 전부 출력(for문 필요없음)
    ```

- 출력결과

  ![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/18(19).png)

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/18(20).png)

- byte[] 배열에서 1인덱스 부터 3개만 출력
- 예제: A, B, C 중 B, C만 출력
- 출력결과

  ![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/18(21).png)

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/18(22).png)

- 어떤 출력 스트림을 얻었다 할지라도, write() 후에는 반드시 flush()를 해야 함

  ⇒ 그러지 않으면 write() 한 데이터가 출력되지 않음

- 출력 스트림을 더 이상 사용하지 않을 땐 close()

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/18(23).png)

- 문자만 읽을 수 있음(byte는 읽을 수 없음)
- 주요 메서드
    - read(): 한 문자는 2byte로 되어 있으므로, 리턴 타입인 int의 4byte 중 끝 2byte에 하나의 문자가 저장
    - read(char[] cbuf): 읽은 문자를 char[] 배열에 저장, 읽은 문자 수만 int로 리턴
    - read(char[] cbuf, int off, int len): 읽은 문자를 char[] 배열에 저장하되, 시작 인덱스 ~ 개수만큼만 저장
    - close(): 더 이상 read()를 사용하지 않을 경우

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/18(24).png)

- 한 번에 한 문자를 읽어 int로 리턴
- read() 실행 과정:

  Reader로 2개의 문자가 들어 올 때, (각 문자는 각각 2byte 크기를 하고 있음)

  → read() 메서드를 실행하게 되면,

    - 한 개의 문자(1, 2)를 읽어 int 4byte의 끝 2byte에 각 문자를 저장 후 리턴

  → 다시 read() 실행

    - 한 개의 문자(3, 4)를 읽어 int 4byte의 끝 2byte에 각 문자를 저장 후 리턴
- 예제

    ```java
    Reader reader = new FileReader("C:/test.txt"); // C:/test.txt에서 FileReader를 만든 다음, Reader에 대입
    int readData;
    while(
    	(readData = reader.read()) // 한 문자씩 읽어 readData에 대입
    	 != -1) { // 더 이상 읽을 문자가 없을 때 -1 리턴
    	char charData = (char) readData; // 문자 저장
    }
    ```

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/18(25).png)

- Reader로부터 3개의 문자가 들어올 때, read() 메서드를 실행했다면,
    1. 첫번째 읽은 경우

       → read(char[] cbuf)의 매개 값 char[] 배열이 길이 2짜리 배열이라면,

       → Reader에서 `1, 2`와 `3, 4` 두 개의 문자를 읽어 각각 0, 1 인덱스에 저장

       → read(char[] cbuf)는 2개의 문자를 읽었으므로 2 리턴

    2. 두 번째 읽은 경우

       → Reader에는 나머지 하나의 문자(`5, 6`)가 남아있기 때문에,

       → read(char[] cbuf) 메서드는 문자(`5, 6`)을 0 인덱스에 저장 후, (1 인덱스에는 저장이 일어나지 않으므로, 이전 데이터 `3, 4`가 남아있음)

       → 읽은 문자 수인 1을 리턴

- 예제

    ```java
    Reader reader = new FileReader("C:/test.txt");
    int readCharNo;
    char[] cbuf = new char[2];
    while (
    	(readCharNo = reader.read(cbuf))
    	// read()는 reader에서 읽은 문자를 cbuf 변수의 배열에 저장됨
    	// 실제 읽은 문자 수가 리턴되어 readCharNo에 저장됨
    	!= -1
    ) {
    	// ...
    }
    ```

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/18(26).png)

- Reader 라는 입력 스트림에서 3개의 문자(1/2, 3/4, 5/6)가 들어올 때

  ⇒ read(char[] cbuf, 1, 2)를 실행한다면,

  ⇒ 길이가 4인 char 배열에서 인덱스 1부터 2개의 문자를 저장하게 됨

  ⇒ 리턴값은 2

- 예제

    ```java
    Reader reader = ...;
    char[] cbuf = new char[100]; // 길이 100인 char 배열 선언
    
    int readCharNo = is.read(cbuf, 0, 100); // char 배열의 0~100 인덱스 만큼 문자를 읽음
    
    // 위 코드와 동일한 코드
    int readChar = is.read(cbuf);
    ```

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/18(27).png)

- `write(int c)`: 매개 값 int의 끝 2byte 문자를 출력
- `write(char[] cbuf)`: char 배열의 모든 문자를 출력
- `flush()`: 버퍼에 쌓여있는 데이터를 강제로 목적지로 보내는 역할

  ⇒ `write()` 메서드 호출 후 필수로 `flush()` 호출 필요

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/18(28).png)

- write() 메서드 값 실행 → int 값 제공

  → int의 끝 2byte에 있는 문자 정보가 Writer를 통해 출력됨

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/18(29).png)

- write() 메서드 실행 → 길이 2짜리 char 배열이 주어지게 됨

  → write() 메서드는 char 배열 안에 있는 모든 문자를 출력

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/18(30).png)

- write() 메서드 실행 → 길이 4인 char 배열이 주어지고,

  → 1~2 인덱스에 위치한 2개의 문자를 Writer를 통해 출력

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/18(31).png)

- write() 메서드로 String 문자열 제공 → Writer를 통해 데이터 출력

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/18(32).png)

- `flush()`: 버퍼를 비우는 기능

  ⇒ write() 메서드로 출력된 데이터는 버퍼에 쌓였다가 전송됨

  ⇒ 버퍼에 잔류한 데이터가 있을 수 있기 때문에, flush()를 호출해 강제적으로 버퍼를 비우고 출력

- `close()`: write() 를 다 사용했을 경우, 닫는 역할

  ⇒ 어떠한 write()든 작업이 끝난 후엔 flush()와 close() 호출 필수

## ****18.3 콘솔 입출력****

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/18(33).png)

- `System.in`: 콘솔에 키보드로 입력한 내용을 입력 스트림으로 얻기 위해 자바에서 제공하는 필드
- `System.out`: 반대로, 프로그램에서 콘솔로 데이터를 출력하기 위해 제공하는 출력 스트림
- `System.err`: 에러 메세지 출력에 사용

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/18(34).png)

### 예제 18.3.1 - 명령 프롬프트에서 실행하기

- .class 파일 있는 경로 가서 `java [실행 클래스 이름(.java 제외)]` 입력

  (참고: .class 파일을 만드는 명령어는 `javac [클래스 이름]`)

    ```bash
    C:\Users\auswo\AppData\Roaming\Code\User\workspaceStorage\e3967762ac58d8f8ebdf24073678a24f\redhat.java\jdt_ws\this-is-Java_9a089889\bin>java SystemInExam1
    ==메뉴==
    1. 예금 조회
    2. 예금 출금
    3. 예금 입금
    4. 종료하기
    메뉴를 선택하세요: 3
    예금 입금 선택
    ```

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/18(35).png)

- 키보드로 한글을 입력 받으려면 다른 read() 메서드를 사용해야 함

    ```java
    byte[] byteData = new byte[15]; // byte 배열 선언
    int readByteNo = System.in.read(byteData);
    ```

- 한글을 읽을 때 byte 배열을 선언하는 이유:

  한글은 한 글자당 2byte로 구성되어 있기 때문 → 키보드로 최소 2번을 입력해야 한글 1글자를 입력할 수 있음

  ⇒ 2byte 이상을 읽기 위해 byte 배열에 저장

- enter 키는 13, 10으로 각 배열 인덱스에 저장됨
- 디폴트 값은 0
- byte 배열에 아스키코드로 입력된 값을 문자열로 만들기(enter키 값 제외)

    ```java
    String strData = new String(byteData, 0, readByteNo-2);
    // readByteNo-2: enter 키 값 제외
    ```

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/18(36).png)

- PrintStream은 OutputStream의 하위 타입
- 사실 `System.out.println`은 PrintStream의 변수 `ps.println()`이었고, 보통 이를 줄여서 사용함

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/18(37).png)

- 콘솔로부터 InputStream을 이용해 데이터를 읽으려면, byte 배열로 읽어 복원해야 하는 불편함이 있음

  ⇒ 편리하게 콘솔에서 문자열을 읽을 수 있도록 Console 클래스 제공(자바 6부터)

  ⇒ Console이외 Scanner 클래스도 제공: Scanner 클래스는 문자열 이외 기본형 타입의 값도 읽을 수 있음

- 예제 명령 프롬프트에서 실행하기

    ```bash
    C:\Users\auswo>cd C:\Users\auswo\AppData\Roaming\Code\User\workspaceStorage\e3967762ac58d8f8ebdf24073678a24f\redhat.java\jdt_ws\this-is-Java_9a089889\bin
    
    C:\Users\auswo\AppData\Roaming\Code\User\workspaceStorage\e3967762ac58d8f8ebdf24073678a24f\redhat.java\jdt_ws\this-is-Java_9a089889\bin>java ConsoleExam
    아이디:
    id2
    패스워드:
    
    id2
    pass2
    ```

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/18(38).png)

- Scanner를 생성하는 법: new Scanner 생성자의 매개값에 System.in 이라는 InputStream을 넣어 줌

## ****18.4 파일 입출력****

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/18(39).png)

- isExist(): new File(”디렉토리 경로”)로 파일 객체를 생성할 때, 디렉토리 경로가 존재하지 않는 것이라도 파일 객체는 생성됨. isExist()로 파일이 존재하는지 검증할 수 있음.
- mkdirs():
    - C:/Temp/dir/dir2 에서 dir, dir2 디렉토리가 없을 때, 둘 다 생성 가능

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/18(40).png)

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/18(41).png)

- 객체 생성 방법

    ```java
    // FileInputStream 생성자 호출
    FileInputStream fis = new FileInputStream("파일 경로");
    
    // 파일 객체가 생성되어 있을 때
    File file = new File("경로");
    FileInputStream fis = new FileInputStream(file); // 생성자 매개값에 파일 객체 대입
    ```

- FileNoutFoundException: new FileInputStream()의 매개값의 경로가 올바르지 않거나, 매개값으로 대입된 파일 객체가 존재하지 않을 경우 예외 발생

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/18(42).png)

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/18(43).png)

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/18(44).png)

## 참고자료

[강의교안_18장.ppt](https://github.com/abarthdew/this-is-Java/blob/main/00.basics/files/%EA%B0%95%EC%9D%98%EA%B5%90%EC%95%88_18%EC%9E%A5.ppt)
