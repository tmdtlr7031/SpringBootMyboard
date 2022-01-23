package nss.myboard.global.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.navercorp.lucy.security.xss.servletfilter.XssEscapeServletFilter;
import lombok.RequiredArgsConstructor;
import nss.myboard.global.interceptor.CheckLoginInterceptor;
import nss.myboard.global.interceptor.LogInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.WebContentInterceptor;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    private final ObjectMapper objectMapper;

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

    /**
     * 네이버 깃허브 제공 xss방지 필터 (https://github.com/naver/lucy-xss-servlet-filter)
     * - 의존성 추가, resources 하위에 xml 파일 위치
     * - 관련 옵션이나 설명은 추가 공부 필요..
     * - 적용 범위 : form submit, multipart/formData submit 시 적용
     */
    @Bean
    public FilterRegistrationBean<XssEscapeServletFilter> filterRegistrationBean() {
        FilterRegistrationBean<XssEscapeServletFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new XssEscapeServletFilter());
        registrationBean.setOrder(1);
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }

    /**
     * XSS 필터 적용된 JsonConverter
     */
    @Bean
    public MappingJackson2HttpMessageConverter jsonEscapeConverter() {
        ObjectMapper copy = objectMapper.copy();
        copy.getFactory().setCharacterEscapes(new JsonXssFilter());
        return new MappingJackson2HttpMessageConverter(copy);
    }
}
