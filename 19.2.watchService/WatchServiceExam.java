// javaFX로 만듬

import java.lang.constant.DirectMethodHandleDesc.Kind;
import java.nio.file.*;
import java.util.List;

public class WatchServiceExam extends Application {
  // javaFX의 경우, FX Application Thread가 UI를 담당하기 때문에,
  // WatchService를 실행할 수 없음
  // 때문에, 별도의 스레드로 WatchService를 구동해야 함
  class WatchServiceThread extends Thread {
    @Override
    public void run() {
      try {
        WatchService watchService = FileSystems.getDefault().newWatchService(); // WatchService 생성
        Path directory = Paths.get("C:/Users/auswo/Downloads/PortableGit/this-is-Java/19.2.watchService"); // 감시할 디렉토리
        directory.register(watchService, StandardWtchEventKinds.ENTRY_CREATE
          , StandardWtchEventKinds.ENTRY_DELETE
          , StandardWtchEventKinds.ENTRY_MODIFY); // directory 디렉토리에 WatchService 등록: 생성, 수정, 삭제를 감시
        while (true) {
          WatchKey watchKey // watchKey가 큐에 들어오면 리턴
            = watchService.take(); // 큐에 watchKey가 들어오는 것을 감시(watchKey가 들어올 때까지 기다림)
          List<WatchEvent<?>> list = watchKey.pollEvents(); // watchKey안에 있는 watchEvent를 컬렉션으로 얻음
          for (WatchEvent<T> watchEvent : list) {
            // 이벤트 종류 얻기
            Kind kind = watchEvent.kind();
            // 감지된 Path 얻기
            Path path = (Path) watchEvent.context();
            if (kind == StandardWatchEventKinds.ENTRY_CREATE) {
              // 생성되었을 경우, 실행할 코드
              Platform.runLater // javaFX application thread가 UI를 변경할 수 있도록 요청
                (() -> textArea.appendText("파일 생성됨 -> " + path.getFileName() + "\n"));
            } else if (kind == StandardWatchEventKinds.ENTRY_DELETE) {
              // 삭제되었을 경우
              Platform.runLater(() -> textArea.appendText("파일 생성됨 -> " + path.getFileName() + "\n"));
            } else if (kind == StandardWatchEventKinds.ENTRY_MODIFY) {
              // 변경되었을 경우
              Platform.runLater(() -> textArea.appendText("파일 생성됨 -> " + path.getFileName() + "\n"));
            } else if (kind == StandardWatchEventKinds.OVERFLOW) {
            }
          }
          boolean valid = watchKey.reset(); // watchKey 초기화
          // 초기화 성공 후, 계속 반복
          if (!valid) { // 초기화 false 시, 반복문 이탈
            break;
          }
        }
      } catch (Exception e) {
      }
    }
  }

  TextArea textArea;

  @Override
  public void start(Stage primaryStage) throws Exception {
    BorderPane root = new BorderPane();
    root.setPrefSize(500, 300);

    textArea = new TextArea();
    textArea.setEditable(false);
    root.setCenter(textArea);

    Scene scene = new Scene(root);
    primaryStage.setScene(scene);
    primaryStage.setTitle("WatchServiceExam");
    primaryStage.show();

    WatchServiceThread wst = new WatchServiceThread();
    wst.start();
  }

  public static void main(String[] args) {
    launch(args);
  }
}