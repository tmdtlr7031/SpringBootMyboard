package nss.myboard.global.config;

import nss.myboard.global.interceptor.CheckLoginInterceptor;
import nss.myboard.global.interceptor.LogInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.WebContentInterceptor;

//@Configuration
public class WebConfig implements WebMvcConfigurer {
    /**
     * Cache-Control 설정 방법들 (https://www.baeldung.com/spring-mvc-cache-headers)
     * 참고
     *  : WebContentInterceptor를 이용한 방법도 HTTP 1.0 헤더 미지원 추세인듯 하다..(https://prettymucho.tistory.com/4 옵션 설명 참고)
     *  : 캐시 무효화 : https://www.lesstif.com/software-architect/http-https-browser-caching-http-header-20775788.html
     */

    // 해당 방법은 Cache-Control: no-Store, no-Cache, must-Revalidate 이렇게 다 적용이 안된다. --> 각 요청마다는 response를 쓰면 되지만 전역으로 설정하는 건 모르겠다..
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("resources/**")
                .addResourceLocations("classpath:/static/")
                .setCacheControl(CacheControl.noStore()) // 캐시 저장 X
        ;

    }

    /**
     *
     * 인터셉터 설정
     *
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor())
                .addPathPatterns("/**")
                .order(1)
                .excludePathPatterns("/boardresources/**","/error");

        registry.addInterceptor(new CheckLoginInterceptor())
                .addPathPatterns("/**")
                .order(2)
                .excludePathPatterns("/boardresources/**","/error", "/loginForm", "/actionLogin");
    }
}
