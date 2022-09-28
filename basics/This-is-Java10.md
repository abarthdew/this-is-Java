## 목차
[10.1 예외와 예외 클래스](#101-예외와-예외-클래스)   
[10.2 실행 예외](#102-실행-예외)   
[10.3 예외 처리 코드](#103-예외-처리-코드)   
[10.4 예외 종류에 따른 처리 코드](#104-예외-종류에-따른-처리-코드)   
[10.5 자동 리소스 닫기](#105-자동-리소스-닫기)   
[10.6 예외 떠 넘기기](#106-예외-떠-넘기기)   
[참고자료](#참고자료)   

## **10.1 예외와 예외 클래스**

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/10.png)

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/10(1).png)

- 자바는 예외도 클래스화 시켜서 사용
- 예외 발생 시, 예외에 맞는 클래스를 찾아 객체로 만들고, 예외 발생 이유를 객체에 저장해 예외 처리 코드에 이용
- 모든 예외 클래스는 Exception 클래스를 상속받아 사용(최상위 부모 클래스)
- `ClassNotFoundException`: 클래스를 찾지 못했을 때 발생하는 예외
- `InterruptedException`: 스레드를 중지시킬 때 사용하는 예외
- `RuntimeException`: 일반 예외/실행 예외를 구분하는 기준이며, 실행 예외
    
    ⇒ 이 클래스를 상속받지 않는 예외 클래스는 일반 예외(`ClassNotFoundException`, `InterruptedException`)
    
    ⇒ 이 클래스를 상속 받는 예외 클래스는 실행 예외(`NullPointException`, `NumberFormatException`)
    

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/10(2).png)

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/10(3).png)

- 예외 클래스들은 자바 문서 java.lang → Exception 에서 찾을 수 있음

## **10.2 실행 예외**

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/10(4).png)

- `NullPointException`: String data = null, 즉 data 변수가 객체를 참조하지 않는 상태에서 toString() 메서드를 사용할 수 없음
- `ArrayIndexOutOfBoundsException`: args[0]만 값이 넘어오고, args[1]은 값이 넘어오지 않은 등 배열 인덱스가 오류난 경우

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/10(5).png)

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/10(6).png)

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/10(7).png)

- Animal 클래스를 상속해서 Dog, Cat 클래스를 만듬
- RemoteControl 인터페이스를 Television, Audio로 구현함
- 자식 객체 혹은 구현 객체를 참조하는 부모 변수를 전혀 다른 상속 객체에 대입하려고 할 때 예외 발생

## **10.3 예외 처리 코드**

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/10(8).png)

- 일반 예외: 예외를 처리하지 않으면 컴파일이 안 됨
- 실행 예외: 컴파일은 되지만 예외 처리해야 함
- finally {} 블록은 예외 발생 상관없이 항상 실행됨

## **10.4 예외 종류에 따른 처리 코드**

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/10(9).png)

- 각각의 예외를 다르게 처리하고 싶을 때, 다중 catch 사용

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/10(10).png)

- 첫번째 catch에서 Exception을 선언하면, 다음 catch인 ArrayIndexOutOfBoundException은 실행되지 않음 ⇒ Exception은 최상위 부모 클래스이기 때문
- 위 예제를 제대로 사용하려면 먼저 ArrayIndexOutOfBoundException가 와야 함

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/10(11).png)

- 다중 catch와 같지만 문법이 다름
- 특정 예외들을 모아 같은 예외 처리를 하고 싶을 때 사용
- 각각 예외들을 각각의 catch에 선언하는 게 아니라, 하나의 catch에 여러 가지 예외들을 공통적으로 처리하고 싶을 때 사용

## **10.5 자동 리소스 닫기**

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/10(12).png)

- 리소스: 각종 출력 스트림, 서버 소켓, 소켓, 각종 채널 등
- try-with-resource: 리소스를 다 사용 후 자동으로 close() 메서드를 호출 → 리소스 닫음
- fis.close(); 와 같이 수동으로 리소스를 닫을 필요 없이, 자바 7부터는 아래와 같이 자동으로 close() 가능
    
    ```java
    try(FileInputStream fis = new FileInputStream("file.txt")) {
    	// ...
    } catch(IOException e) {
    	// ...
    }
    ```
    
    ⇒ try 블록에서 예외 발생 시 그 즉시 close()가 호출, catch 블록으로 내려와 예외 처리
    
    - 조건: java.lang.AutoCloseable인터페이스를 구현하고 있어야 함
    
    ```java
    try(**FileInputStream** fis = new FileInputStream("file.txt")) {
    	// ...
    } catch(IOException e) {
    	// ...
    }
    
    try(
    	**FileInputStream** fis = new FileInputStream("file.txt")
    	**FileOutputStream** fos = new FileOutputStream("file.txt")
    ) {
    	// ...
    } catch(IOException e) {
    	// ...
    }
    ```
    
    - 즉, **`리소스(FileInputStream, FileOutputStream)`**들이 AutoCloseable인터페이스를 구현하고 있어야 함
        
        ⇒ try() 안에 AutoCloseable인터페이스를 구현하지 않은 리소스들이 포함되어 있으면, 자동으로 close() 메서드가 호출되지 않음
        

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/10(13).png)

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/10(14).png)

- 자바 문서에서 java.io - FileInputStream을 보면, AutoCloseable이 있음을 확인할 수 있음
- java.net - ServerSocker, Socker
- java.channel - FileChannel, SockerChannel 등도 동일

![Untitled](https://github.com/abarthdew/this-is-java/blob/main/basics/images/10(15).png)

## **10.6 예외 떠 넘기기**

## 참고자료

[강의교안_10장.ppt](https://github.com/abarthdew/this-is-Java/blob/main/basics/files/%EA%B0%95%EC%9D%98%EA%B5%90%EC%95%88_10%EC%9E%A5.ppt)