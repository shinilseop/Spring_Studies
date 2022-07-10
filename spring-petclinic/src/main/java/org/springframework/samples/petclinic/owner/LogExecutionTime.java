package org.springframework.samples.petclinic.owner;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // 이 애노테이션을 어디에 적용할건지
@Retention(RetentionPolicy.RUNTIME) // 애노테이션 유지를 언제까지 ?
public @interface LogExecutionTime {

}
