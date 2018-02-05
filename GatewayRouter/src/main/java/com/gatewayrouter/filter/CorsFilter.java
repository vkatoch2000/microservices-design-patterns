package com.gatewayrouter.filter;


import java.io.IOException;
import java.util.logging.LogRecord;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


/**
 * CORS Filter is a generic solution for fitting Cross-Origin Resource Sharing (CORS) support to Java web applications.
 * CORS is a W3C standard for enabling cross-domain requests from web browsers to servers and web APIs that opt in to handle them.
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter implements Filter {

  private static Logger log = LoggerFactory.getLogger(CorsFilter.class);


  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  // enable Cross-Origin Resource Sharing from content delivery networks
  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {

    HttpServletResponse httpServletResponse = (HttpServletResponse) response;
    HttpServletRequest httpServletRequest = (HttpServletRequest) request;
    httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");   // requests without credentials, the server may specify "*"
    httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
    httpServletResponse.setHeader("Access-Control-Max-Age", "180");
    httpServletResponse.setHeader("Access-Control-Allow-Headers", "x-requested-with, Content-Type");

    //Preflighted requests
    //"preflighted" requests first send an HTTP request by the OPTIONS method to the
    // resource on the other domain, in order to determine whether the actual request is safe to send

    if ("OPTIONS".equalsIgnoreCase(httpServletRequest.getMethod())) {
       httpServletResponse.setStatus(HttpServletResponse.SC_OK);
    } else {
      chain.doFilter(httpServletRequest, httpServletResponse);
    }



  }

  @Override
  public void destroy() {

  }
}
