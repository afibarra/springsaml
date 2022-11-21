package me.afibarra.springsaml.saml.interceptor;

import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class CookiesInterceptor extends HandlerInterceptorAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(CookiesInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
        Object handler) throws Exception {

        String requestURI = request.getRequestURI();
        LOGGER.info("Request URL: {}", requestURI);

        if (request != null) {
            Arrays.stream(request.getCookies()).forEach(cookie -> {
                LOGGER.info("Cookie Name: {}, Cookie Value: {}", cookie.getName(),
                    cookie.getValue());
            });
        }

        if (requestURI.equals("/home")) {
            request.getRequestDispatcher("/v1/home").forward(request, response);
            return false;
        } else {
            return true;
        }
    }
}
