package me.afibarra.springsaml.saml.config;

import me.afibarra.springsaml.saml.interceptor.CookiesInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final CookiesInterceptor cookiesInterceptor;

    @Autowired
    public WebConfig(CookiesInterceptor cookiesInterceptor) {
        this.cookiesInterceptor = cookiesInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(cookiesInterceptor);
    }
}
