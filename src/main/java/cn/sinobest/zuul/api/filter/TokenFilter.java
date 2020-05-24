/**
 * 
 */
package cn.sinobest.zuul.api.filter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Administrator
 *
 */
//@Component
@Slf4j
public class TokenFilter extends ZuulFilter{
	
	@Value("${server.port}")
	private String serverPort;

	/**
	 * 判断过滤器是否生效
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}

	/**
	 * 编写过滤器具体业务代码
	 * ex:拦截所有的服务接口，判端接口请求是否传入userToken参数
	 */
	@Override
	public Object run() throws ZuulException {
		//1 获取当前上下文
		RequestContext requestContext = RequestContext.getCurrentContext();
		//2 获取当前请求
		HttpServletRequest req = requestContext.getRequest();
		//3 获取token一般从请求头中获取 此处以get请求参数为例
		String token = req.getParameter("userToken");
		if(StringUtils.isEmpty(token)) {
			//不会继续执行转发服务 而直接返回客户端
			requestContext.setSendZuulResponse(false);
			requestContext.setResponseBody("userToken is null");
			requestContext.setResponseStatusCode(401);
			return null;
		}
		log.info("hi,look,current server port is {} ",serverPort);
		return null;
	}

	/**
	 * 过滤器类型 pre-前置过滤器 在转发请求前处理
	 */
	@Override
	public String filterType() {
		return "pre";
	}

	/**
	 * 一个请求在同一阶段下 用到多个过滤器的情况下 定义过滤器执行顺序
	 */
	@Override
	public int filterOrder() {
		return 0;
	}

}
