public class ServerExam4 extends Application {
        
    ExecutorService executorService;
    ServerSocket serverSocket;
    List<Client> connections = new Vector<Client>();

    void startServer() {
        // 서버 시작 코드
    }

    void stopServer() {
        // 서버 종료 코드
    }

    class Client {
        // 데이터 통신 코드
    }

    // javaFX
    TextArea txtDisplay;
    Button btnStartStop;

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
        root.setprefSize(500, 300);

        txtDisplay = new TextArea();
        txtDisplay.setEditable(false);
        BorderPane.setMargin(TxtDisplay, new Insets(0,0,2,0));
        root.setCenter(TxtDisplay);

        btnStartStop = new Button("Start");
        btnStartStop.setPreHeight(30);
        btnStartStop.setMaxWidth(Double.MAX_VALUE);
        btnStartStop.setOnAction(e->{
            if (btnStartStop.getText().equals("start")) {
                startServer();
            } else if(btnStartStop.getText().equals("stop")) {
                stopServer();
            }
        });
        root.setBottom(btnStartStop);

        Scene scene = new Scene(root);
        scene.getStrylesheets().add(getClass().getResource("app.css").toString());
        primaryStage.setScene(Scene);
        primaryStage.setTitle("Server");
        primaryStage.setOnCloseRequest(event->stopServer());
        primaryStage.show();
    }

    void displayText(String text) {
        txtDisplay.appendText(text + "\n");
    }

    public static void main(String[] ar) {
        launch(args);
    }

}
