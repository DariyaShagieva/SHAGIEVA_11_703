package ru.itis.long_polling.security.filters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import ru.itis.long_polling.security.authentication.JWTAuthentication;
import ru.itis.long_polling.security.provider.TokenAuthenticationProvider;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class TokenAuthenticationFilter implements Filter {
    private final static String AUTH_HEADER = "AUTH";


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // вытаскиваем запрос
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        SecurityContext context = SecurityContextHolder.getContext();
        // вытаскиваем заголовок с токеном
        String tokenValue = request.getHeader(AUTH_HEADER);
        // если заголовок содержит что-либо
        String token = "";
        if (tokenValue != null) {


            JWTAuthentication authentication = new JWTAuthentication();
            authentication.setToken(tokenValue);

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
