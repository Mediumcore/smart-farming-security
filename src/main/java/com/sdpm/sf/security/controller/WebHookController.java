package com.sdpm.sf.security.controller;

import com.alibaba.fastjson.JSON;
import com.sdpm.sf.security.common.rest.RestMessage;
import com.sdpm.sf.security.entity.SfUser;
import com.sdpm.sf.security.service.UserDetailsService;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.entity.ContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author shirukai
 */
@RestController
@RequestMapping("/api/v1/webhook")
public class WebHookController {
    private static final Logger LOG = LoggerFactory.getLogger(WebHookController.class);
    @Autowired
    private UserDetailsService userDetailsService;
    private static final Pattern CLIENT_ID_PATTERN = Pattern.compile("sfs-device-(.*)-.*");

    @PostMapping
    public RestMessage webhook(@RequestBody Map<String, String> param) throws IOException {
        LOG.info("Client info:{}", param);
        String clientId = param.get("clientid");
        Matcher matcher = CLIENT_ID_PATTERN.matcher(clientId);
        // 符合租户规则
        if (matcher.find()) {
            // 获取租户id
            Long uid = Long.parseLong(matcher.group(1));
            Optional<SfUser> sfUserOptional = userDetailsService.findById(uid);
            if (sfUserOptional.isPresent()) {
                SfUser sfUser = sfUserOptional.get();
                if ("tenant".equals(sfUser.getRole())) {
                    // 向租户发送webhook
                    String webhookUrl = sfUser.getUrl() + "/api/v1/webhook";
                    LOG.info("Send to tenant:{}", webhookUrl);
                    Response response = Request.Post(webhookUrl).bodyString(JSON.toJSONString(param), ContentType.APPLICATION_JSON).execute();
                    LOG.info(response.returnContent().asString());
                }
            }
        }
        return null;
    }

}
