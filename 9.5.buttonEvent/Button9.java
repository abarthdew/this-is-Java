
// 익명 구현 객체를 이용해 UI 이벤트 처리 예제

public class Button9 {
    OnClickListener listner;

    void setOnClickListener(OnClickListener listener) {
        this.listner = listener;
    }

    void touch() {
        listner.onClick();
    }

    interface OnClickListener {
        void onClick();
    }
}
