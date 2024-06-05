package idusw.springboot.mallckj.acp;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
class LogAspect { //@AspectJ 지원 AOP, 횡단 관심 - 공통 기능(로그, ...)
    // 1, module dependency 해결 - build.gradle(spring-aop...)
    // 2. Aspect -> Advice, PointCut (JoinPoint 정보와 Join 조건)정의
    // 3. 시점 결정
    private Logger logger = LoggerFactory.getLogger(getClass());

    //execution : ~클래스가 작동할때 실행
    @Pointcut("execution(* idusw.springboot.mallckj.service.*ServiceImpl.loginById*(..))")
    public void getLogging() {} //Advice

    @Before("getLogging()")
    public void loggerBefore(JoinPoint joinPoint) { //Advice
        for(int i = 1; i < 10; i++)
            System.out.println("횡단관심,공통코드 : 보안, 트랜잭션, 로깅 .. ");
        /*
        String message = "AOP - 로깅 시작";
        logger.info(message);
        */
    }
    @AfterReturning("execution(* idusw.springboot.mallckj.service.*ServiceImpl.*(..))")
    public void loggerAfterReturning(JoinPoint joinPoint) { //Advice
        String message = "트랜잭션 처리";
        logger.info(message);
    }
}
