/**
 * 
 */
package cn.sinobest.zuul.api.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

/**
 * @author Administrator
 *
 */
@Component
@Primary
public class DocmentationConfig implements SwaggerResourcesProvider{

	@Override
	public List<SwaggerResource> get() {
		List<SwaggerResource> resource = new ArrayList<SwaggerResource>();
		resource.add(swaggerResource("api-member","/api-member/v2/api-docs","2.0"));
		resource.add(swaggerResource("api-order","/api-order/v2/api-docs","2.0"));
		return resource;
	}
	
	private SwaggerResource swaggerResource(String name, String location, String version) {
		SwaggerResource swaggerResource = new SwaggerResource();
		swaggerResource.setName(name);
		swaggerResource.setLocation(location);
		swaggerResource.setSwaggerVersion(version);
		return swaggerResource;
		
	}

}
