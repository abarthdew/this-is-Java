## 목차
[18.1 IO 패키지 소개](#181-io-패키지-소개)   
[18.2 입력 스트림과 출력 스트림](#182-입력-스트림과-출력-스트림)   
[]()
[참고자료](#참고자료)   

## **18.1 IO 패키지 소개**

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

## **18.2 입력 스트림과 출력 스트림**

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/18().png)

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
    
    ![Untitled](https://github.com/abarthdew/this-is-java/blob/main/00.basics/images/18().png)
    
- 각 프로그램을 기준으로 데이터가 들어오면 입력 스트림,
- 데이터가 나가면 출력 스트림임
- 예) A가 출력 스트림을 통해 데이터를 보내면, B는 입력 스트림을 통해 데이터를 받음
- 예) A가 입력 스트림을 통해 데이터를 받고 싶다면, B가 먼저 출력 스트림을 통해 데이터를 보내 줘야 함
- 출발지: 데이터가 출발하는 곳(출력 스트림 이용)
- 도착지: 데이터가 도착하는 곳(입력 스트림 이용)

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/1f246343-0023-41fe-b53b-3e24c77983d6/Untitled.png)

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

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/7dbbe877-c0ef-490c-941b-5aa049a9caf8/Untitled.png)

- InputStream은 추상 클래스이므로 new 연산자를 이용해 생성할 일이 없음
- InputStream을 상속받은 하위 클래스, 즉 구현 클래스로 객체를 만들어 사용할 수 있음
- InputStream의 주요 메서드
    - `read()`: read()가 읽은 1바이트가 int 타입(4바이트) 가장 끝에 저장됨
        
        ⇒ 1바이트를 읽고 그 읽은 바이트를 int 타입으로 리턴
        
    
    ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/45de101a-b6f8-4711-9d6d-60dfb4061b74/Untitled.png)
    
    - `read(byte[] b)`: 주어진 byte 배열의 길이만큼 데이터를 읽어 매개변수 byte[]에 저장하고, 실제 읽은 바이트 수를 int 로 리턴
        
        ⇒ 5byte를 읽었다면, 그 데이터는 (byte[] b)에 저장되고, 리턴값은 5가 나옴
        
    - `read(byte[] b, int off, int len)`:
        - 읽은 데이터를 매개변수 byte[] 배열에 저장
        - 어떤 위치에 저장할 건지 2, 3번째 매개변수로 지정
        
        ⇒ 길이가 5인 배열의 2번째 인덱스부터 2개를 읽고 저장
        
        ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/f7279672-44e6-4e43-8922-9b8ced696b2e/Untitled.png)
        
    - `close()`: InputStream 사용 후 닫을 때 사용

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/ccff8d57-ca0e-44cf-b02b-6b085323942e/Untitled.png)
- 1바이트를 읽고, 읽은 바이트를 리턴
- InputStream로부터 5개의 바이트가 들어온다면, read()는 5번 실행해서 읽음
- 읽힌 바이트는 int 타입의 끝에 저장되고 리턴됨
- (1) 바이트를 읽고, int 타입의 끝에 저장 / (2)를 읽고, int 타입의 끝에 저장 / (3), (4)도 동일
    
    ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/7467b3a1-af9a-427d-8a6f-d6c99b4ec662/Untitled.png)
    
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

## 참고자료

[강의교안_18장.ppt](https://github.com/abarthdew/this-is-Java/blob/main/00.basics/files/%EA%B0%95%EC%9D%98%EA%B5%90%EC%95%88_18%EC%9E%A5.ppt)
