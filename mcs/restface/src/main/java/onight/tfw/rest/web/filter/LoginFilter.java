package onight.tfw.rest.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

public class LoginFilter implements Filter {
    // FilterConfig可用于访问Filter的配置信息
    private FilterConfig config;

    // 实现初始化方法
    @Override
    public void init(FilterConfig config) {
        this.config = config;
    }

    // 实现销毁方法
    @Override
    public void destroy() {
        this.config = null;
    }

    // 执行过滤的核心方法
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
    	HttpServletRequest hsr = (HttpServletRequest) request;
    	HttpServletResponse res = (HttpServletResponse)response;
    	String loginUrl = "/login";
    	String  getKeyUrl= "exmchinf/count";
    	String path = ((HttpServletRequest) request).getServletPath();
		boolean login = false;
		boolean getKey = false;
		if (StringUtils.contains(path, loginUrl)) {
			login = true;
		}
		if (StringUtils.contains(path, getKeyUrl)) {
			getKey = true;
		}
		HttpSession session = hsr.getSession();
		if(getKey||login||session.getAttribute("user")!=null){
			chain.doFilter(request, response);
		}else if(StringUtils.contains(path, "excomm")){
			chain.doFilter(request, response);
		}else{
			String url = ("loginRedirectUrl");
			res.sendRedirect(url);
		}
    }

}