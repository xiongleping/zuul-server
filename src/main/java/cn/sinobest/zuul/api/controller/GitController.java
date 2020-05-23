/**
 * 
 */
package cn.sinobest.zuul.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.sinobest.zuul.api.modles.GitConfig;
/**
 * @author Administrator
 *
 */
@RestController
@RefreshScope //开启更新功能
@RequestMapping("/api/configClient")
public class GitController {
	
	@Autowired
    private GitConfig gitConfig;

    @GetMapping("/show")
    public Object show(){
        return gitConfig;
    }
}