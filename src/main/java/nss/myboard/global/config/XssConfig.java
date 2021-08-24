package nss.myboard.global.config;

import com.navercorp.lucy.security.xss.servletfilter.XssEscapeServletFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class XssConfig implements WebMvcConfigurer {

    /**
     * 네이버 깃허브 제공 xss방지 필터 (https://github.com/naver/lucy-xss-servlet-filter)
     * - 의존성 추가, resources 하위에 xml 파일 위치
     * - 관련 옵션이나 설명은 추가 공부 필요..
     */
    @Bean
    public FilterRegistrationBean<XssEscapeServletFilter> filterRegistrationBean() {
        FilterRegistrationBean<XssEscapeServletFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new XssEscapeServletFilter());
        registrationBean.setOrder(1);
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }
}
