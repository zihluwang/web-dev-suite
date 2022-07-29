package cn.vorbote.web.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Optional;

/**
 * CharacterEncodingFilter can set character encoding to request and response.<br>
 * Created at 2022/3/28 15:24
 *
 * @author vorbote
 */
@Slf4j
public class CharacterEncodingFilter implements Filter {

    /**
     * Encoding method for request.
     */
    private final String requestEncoding;

    /**
     * Encoding method for response.
     */
    private final String responseEncoding;

    public CharacterEncodingFilter(String requestEncoding, String responseEncoding) {
        // Make sure the two variables are not null.
        requestEncoding = Optional.ofNullable(requestEncoding).orElse("UTF-8");
        responseEncoding = Optional.ofNullable(responseEncoding).orElse("UTF-8");

        // Set encoding.
        this.requestEncoding = requestEncoding;
        this.responseEncoding = responseEncoding;
    }

    /**
     * Convert encoding for request and response.
     *
     * @param servletRequest  The request.
     * @param servletResponse The response.
     * @param filterChain     The filter chain.
     * @throws IOException      This exception might not be thrown.
     * @throws ServletException This exception might not be thrown.
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        request.setCharacterEncoding(requestEncoding);
        response.setCharacterEncoding(responseEncoding);

        filterChain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("Character Encoding Filter created...");
    }

    @Override
    public void destroy() {
        log.info("Character Encoding Filter destroyed...");
    }
}
