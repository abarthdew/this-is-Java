public class PhoneExam {
    public static void main(String[] args) {
        DmbCellPhone dmbCellPhone = new DmbCellPhone("자바폰", "검정", 10);
        System.out.println(dmbCellPhone.model); // 자바폰
        System.out.println(dmbCellPhone.channel); // 10
        dmbCellPhone.powerOn(); // 전원을 켭니다
        dmbCellPhone.bell(); // 벨이 울립니다
        dmbCellPhone.receiveVoice("ㅎㅎㅎ"); // ㅎㅎㅎ
        dmbCellPhone.sendVoice("안녕"); // 안녕
        dmbCellPhone.hangUp(); // 전화를 끊습니다
    }
}
