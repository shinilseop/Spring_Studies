package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class TimeTraceAop {

  @Around("execution(* hello.hellospring..*(..))")
  public Object execut(ProceedingJoinPoint joinPoint) throws Throwable {
    StopWatch stopWatch = new StopWatch();
    stopWatch.start();

    try {
      return joinPoint.proceed();
    } finally {
      stopWatch.stop();
      System.out.println(joinPoint.toString() + "\n" + stopWatch.prettyPrint());
    }
  }
}
