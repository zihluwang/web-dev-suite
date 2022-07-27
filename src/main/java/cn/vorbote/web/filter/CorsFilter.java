package cn.vorbote.web.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * CORS Filter. You can easily handle CORS issues in your web application development by setting this CorsFilter to an
 * appropriate status.
 *
 * @author vorbote
 */
@Slf4j
public class CorsFilter implements Filter {

    /**
     * According to <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Access-Control-Allow-Credentials"
     * >MDN Docs</a>, this tells browsers whether to expose the response to the frontend JavaScript code when
     * the request's credentials mode ({@code Request.credentials}) is included.
     */
    private final boolean allowCredentials;

    /**
     * According to <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Access-Control-Allow-Origin"
     * >MDN Docs</a>, this response header indicates whether the response can be shared with requesting code from the
     * given origin.
     */
    private final String[] allowOrigin;

    /**
     * According to <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Access-Control-Allow-Headers"
     * >MDN Docs</a>, this response header is used in response to a preflight request which includes the
     * {@code Access-Control-Request-Headers} to indicate which HTTP headers can be used during the actual request.
     */
    private final String[] allowHeaders;

    /**
     * According to <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Access-Control-Allow-Methods"
     * >MDN Docs</a>, this response header specifies one or more methods allowed when accessing a resource in response
     * to a preflight request.
     */
    private final String[] allowMethods;

    /**
     * According to <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Access-Control-Expose-Headers"
     * >MDN Docs</a>, this response header allows a server to indicate which response headers should be made available
     * to scripts running in the browser, in response to a cross-origin request.<br>
     * Only the <a href="https://developer.mozilla.org/en-US/docs/Glossary/CORS-safelisted_response_header"
     * >CORS-safelisted</a> response headers are exposed by default. For clients to be able to access other headers,
     * the server must list them using the Access-Control-Expose-Headers header.
     */
    private final String[] exposeHeaders;

    /**
     * Generate a DIY cors filter.
     *
     * @param allowCredentials According to <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Access-Control-Allow-Credentials"
     *                         >MDN Docs</a>, this tells browsers whether to expose the response to the frontend
     *                         JavaScript code when the request's credentials mode ({@code Request.credentials}) is
     *                         included.
     * @param allowOrigin      According to <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Access-Control-Allow-Origin"
     *                         >MDN Docs</a>, this response header indicates whether the response can be shared with
     *                         requesting code from the given origin.
     * @param allowMethods     According to <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Access-Control-Allow-Headers"
     *                         >MDN Docs</a>, this response header is used in response to a preflight request which
     *                         includes the {@code Access-Control-Request-Headers} to indicate which HTTP headers can be
     *                         used during the actual request.
     * @param allowHeaders     According to <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Access-Control-Allow-Headers"
     *                         >MDN Docs</a>, this response header is used in response to a preflight request which
     *                         includes the {@code Access-Control-Request-Headers} to indicate which HTTP headers can be
     *                         used during the actual request.
     * @param exposeHeaders    According to <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Access-Control-Expose-Headers"
     *                         >MDN Docs</a>, this response header allows a server to indicate which response headers
     *                         should be made available to scripts running in the browser, in response to a cross-origin
     *                         request.<br> Only the <a href="https://developer.mozilla.org/en-US/docs/Glossary/CORS-safelisted_response_header"
     *                         >CORS-safelisted</a> response headers are exposed by default. For clients to be able to
     *                         access other headers, the server must list them using the {@code Access-Control-Expose-Headers}
     *                         header.
     */
    public CorsFilter(boolean allowCredentials,
                      String[] allowOrigin,
                      String[] allowMethods,
                      String[] allowHeaders,
                      String[] exposeHeaders) {
        this.allowCredentials = allowCredentials;
        this.allowOrigin = allowOrigin;
        this.allowMethods = allowMethods;
        this.allowHeaders = allowHeaders;
        this.exposeHeaders = exposeHeaders;
    }

    /**
     * Get allow credentials data.
     *
     * @return Value {@code true} if allow credentials, or {@code false}.
     */
    protected boolean isAllowCredentials() {
        return allowCredentials;
    }

    protected String[] getAllowOrigin() {
        return allowOrigin;
    }

    protected String[] getAllowHeaders() {
        return allowHeaders;
    }

    protected String[] getAllowMethods() {
        return allowMethods;
    }

    protected String[] getExposeHeaders() {
        return exposeHeaders;
    }

    /**
     * Transfer {@code String} array to MDN specified format of header value.
     *
     * @param array The {@code String} array.
     * @return A {@code String} with the format of MDN specified header value.
     */
    protected static String fromArray(String[] array) {
        StringBuilder builder = new StringBuilder();
        if (array != null && array.length > 0) {
            for (String item : array) {
                builder.append(item).append(",");
            }
        }
        return builder.length() != 0 ? builder.substring(0, builder.length() - 1) : "";
    }

    /**
     * Generate a default cors filter (cannot solve the {@code cors} problem).
     */
    public CorsFilter() {
        this(false, new String[]{""}, new String[]{""}, new String[]{""}, new String[]{""});
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        // Transform original ServletXxx instances to HttpServletXxx instances.
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // Handle CORS problem.
        response.addHeader("Access-Control-Allow-Credentials", String.valueOf(isAllowCredentials()));
        response.addHeader("Access-Control-Allow-Origin", fromArray(getAllowOrigin()));
        response.addHeader("Access-Control-Allow-Methods", fromArray(getAllowMethods()));
        response.addHeader("Access-Control-Allow-Headers", fromArray(getAllowHeaders()));

        // Set exposed response headers
        response.addHeader("Access-Control-Expose-Headers", fromArray(getExposeHeaders()));

        // 所有xhr发送的请求会同时发送OPTIONS请求，因此拦截所有OPTIONS请求
        if (request.getMethod().equalsIgnoreCase("OPTIONS")) {
            // log.info("User-Agent: {}", req.getHeader("User-Agent"));
            return;
        }

        // 已经更改完成，请求被放行
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("CorsFilter initialized...");
    }

    @Override
    public void destroy() {
        log.info("CorsFilter destroyed...");
    }
}
