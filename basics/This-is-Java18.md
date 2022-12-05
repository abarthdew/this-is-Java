## 목차
[18.1 IO 패키지 소개](#181-io-패키지-소개)   
[18.2 입력 스트림과 출력 스트림](#182-입력-스트림과-출력-스트림)   
[참고자료](#참고자료)   

## **18.1 IO 패키지 소개**

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/18.png)

- IO: input / ouput의 약자
- 자바에서는 데이터를 input/output하기 위해 java.io 패키지를 제공함
- 이 패키지에 있는 클래스를 이용해 데이터 입출력 가능
- File: 파일의 이름, 경로, 크기, 속성(읽기 전용/쓰기 전용)
- **InputStream/OutputStream**: 바이트를 읽고 쓰기 위해 사용하는 클래스
    
    ![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/18(1).png)
    
    ⇒ InputStream/OutputStream을 상속해서 만든 하위 스트림
    
    - `FileInputSTream/FileOutputStream`: 하위 스트림을 이용해 파일에 데이터를 저장하고 읽을 수 있음
    - `DataInputStream ~ BufferedOutputStream`: 좀 더 편하게 입출력을 하기 위해 사용하는 보조 스트림
- **Reader/Writer:** InputStream/OutputStream이 바이트 단위로 입출력을 한다면, Reader/Writer는 문자 단위로 입출력
    
    ![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/18(2).png)
    
    ⇒ Reader/Writer를 상속해서 만든 하위 스트림
    
    - `FileReader/FileWriter`: 파일에서 문자를 읽음/파일에서 문자를 저장
    - `InputStreamReader/OutputStreamReader`: 바이트 스트림을 문자 스트림으로 변경
    - `PrintwWriter`: 문자를 출력
    - `BufferedReader/BufferedWriter`: 성능 향상을 위해 사용하는 보조 스트림

## **18.2 입력 스트림과 출력 스트림**

## 참고자료

[강의교안_18장.ppt](https://github.com/abarthdew/this-is-Java/blob/main/basics/files/%EA%B0%95%EC%9D%98%EA%B5%90%EC%95%88_18%EC%9E%A5.ppt)