public class ClientExam4 {

  Socket socket;

  void startClient() {
    // 연결 시작 코드
  }

  void stopClient() {
    // 연결 끊기 코드
  }

  void receive() {
    // 데이터 받기 코드
  }

  void send(String data) {
    // 데이터 전송 코드
  }

  // javaFX
  TextArea txtDisplay;
  TextField txtInput;
  Button btnConn, btnSend;

  @Override
  public void start(Stage primaryStage) throws Exception {
    BorderPane root = new BorderPane();
    root.setPrefSize(500, 300);

    txtDisplay = new TextArea();
    txtDisplay.setEditable(false);
    BorderPane.setMargin(txtDisplay, new Insets(0, 0, 2, 0));
    root.setCenter(txtDisplay);

    BorderPane bottom = new BorderPane();
    txtInput = new TextField();
    txtInput.setPrefSize(60, 30);
    BorderPane.setMargin(txtInput, new Insets(0, 1, 1, 1));

    btnCoon = new Button("start");
    btnConn.setPrefSize(60, 30);
    btnConn.setOnAction(e -> {
      if (btnConn.getText().equals("start")) {
        startClient();
      } else if (btnConn.getText().equals("stop")) {
        stopClient();
      }
    });

    btnSend = new Button("send");
    btnSend.setPrefSize(60, 30);
    btnSend.setDisable(true);
    btnSend.setOnAction(e -> send(txtInput.getText()));

    bottom.setCenter(txtInput);
    bottom.setLeft(btnConn);
    bottom.setRight(btnSend);

    root.setBottom(bottom);

    Scene scene = new Scene(root);
    scene.getStylesheets().add(getClass().getResource("app.css").toString());
    primaryStage.setScene(scene);
    primaryStage.setTitle("Client");
    primaryStage.setOnCloseRequest(event -> stopClient());
    primaryStage.show();
  }

  void displaText(String text) {
    txtDisplay.appendText(Text + "\n");
  }

  public static void main(String[] args) {
    launch(args);
  }

}
