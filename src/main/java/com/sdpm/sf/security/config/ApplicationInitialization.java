package com.sdpm.sf.security.config;

import com.sdpm.sf.security.dto.SfUserDTO;
import com.sdpm.sf.security.service.UserDetailsService;
import com.sdpm.sf.security.vo.SfUserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * 用户初始化
 *
 * @author rukey
 */
@Component
public class ApplicationInitialization implements ApplicationRunner {
    private static final Logger logger = LoggerFactory.getLogger(ApplicationInitialization.class);
    @Value("${token.id}")
    private long tokenId;
    @Value("${admin.desc}")
    private String adminDescription;
    @Value("${admin.username}")
    private String adminUsername;
    @Value("${admin.password}")
    private String adminPassword;
    @Value("${admin.url}")
    private String adminUrl;
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // 初始化用户
        SfUserDTO user = userDetailsService.loadUserByUsername(adminUsername);
        if (Objects.isNull(user)) {
            logger.info("Initialize the administrator account.");
            SfUserVO sfUserVO = new SfUserVO();
            sfUserVO.setUsername(adminUsername);
            sfUserVO.setPassword(adminPassword);
            sfUserVO.setUrl(adminUrl);
            sfUserVO.setDescription(adminDescription);
            sfUserVO.setId(tokenId);
            sfUserVO.setRole("admin");
            userDetailsService.registry(sfUserVO);
        }
    }
}
