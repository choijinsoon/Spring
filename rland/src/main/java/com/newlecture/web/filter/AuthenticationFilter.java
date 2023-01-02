package com.newlecture.web.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


public class AuthenticationFilter implements Filter{

    private static final String[] authUrls = {
        "/admin/**",
        "/member/**"
    };

    public AuthenticationFilter() {
    }



    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();

        // 위치 확인
        String requestURI = req.getRequestURI();

        Boolean isAuthRequired = false;
        for (String url : authUrls) {
            if (url.endsWith("**")) {
                String path = url.substring(0, url.length() - 2);
                if(requestURI.startsWith(path)) 
                    isAuthRequired = true;
                    break;
            }
            else if (url.equals(requestURI)){
                isAuthRequired = true;
                break;
            }
        }

        // 인증 확인
        String username = (String) session.getAttribute("username");
		if (username == null) //인증 한 적 없다
			return ;

        chain.doFilter(request, response);

    }
}
