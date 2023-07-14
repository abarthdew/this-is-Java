import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD}) // 적용 형태 - 메서드에만 적용 가능
@Retention(RetentionPolicy.RUNTIME) // 유지 정책
public @interface PrintAnnotation {
  // 엘리먼트 선언(1. 문자 2. 문자 출력 수)
  String value() default "-"; // 기본 엘리먼트 // 어노테이션 선언 안에 있으므로 () 붙임 // default 값은 "-"

  int number() default 15;
}
