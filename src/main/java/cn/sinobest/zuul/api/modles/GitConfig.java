/**
 * 
 */
package cn.sinobest.zuul.api.modles;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * @author Administrator
 *
 */
@Data
@Component
@ConfigurationProperties(prefix = "zuul")
public class GitConfig {
	
	@Value("${zuul.host.connect-timeout-millis}")
	private int connectTimeoutMillis;

    @Value("${zuul.host.socket-timeout-millis}")
    private int socketTimeoutMillis;

}
