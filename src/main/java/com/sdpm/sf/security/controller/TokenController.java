package com.sdpm.sf.security.controller;

import com.sdpm.sf.security.common.rest.RestMessage;
import com.sdpm.sf.security.common.util.JwtTokenUtils;
import com.sdpm.sf.security.common.util.RestMessageUtil;
import com.sdpm.sf.security.service.UserDetailsService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author shirukai
 */
@RestController
@RequestMapping("/api/v1/token")
public class TokenController {
    @Autowired
    private UserDetailsService userDetailsService;

    @GetMapping("/user")
    public RestMessage getUserByToken(
            @RequestParam String token
    ) {
        Object result = null;
        Claims claims = JwtTokenUtils.validateToken(token);
        if (claims != null) {
            result = userDetailsService.loadUserByUsername((String) claims.get("username"));
        }
        return RestMessageUtil.objectToRestMessage(result);
    }
}
