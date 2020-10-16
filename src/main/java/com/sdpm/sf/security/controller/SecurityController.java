package com.sdpm.sf.security.controller;

import com.sdpm.sf.security.common.rest.RestMessage;
import com.sdpm.sf.security.common.util.RestMessageUtil;
import com.sdpm.sf.security.service.UserDetailsService;
import com.sdpm.sf.security.vo.SfUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

/**
 * @author shirukai
 */
@RestController
@RequestMapping("/api/v1/security")
public class SecurityController {
    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/registry")
    public RestMessage registry(@RequestBody SfUserVO sfUserVO) {
        return RestMessageUtil.objectToRestMessage(userDetailsService.registry(sfUserVO));
    }

    @PostMapping("/login")
    public RestMessage login(
            @RequestParam(value = "username") String username,
            @RequestParam(value = "password") String password
    ) {
        return RestMessageUtil.objectToRestMessage(userDetailsService.login(username, password));
    }

    @GetMapping("/users")
    public RestMessage getUsers(
            @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize
    ) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        return RestMessageUtil.pageToRestMessage(userDetailsService.findUsersWithPage(pageable));
    }

    @DeleteMapping("/users/{userId}")
    public RestMessage deleteUser(
            @PathVariable("userId") Long uid
    ) {
        return RestMessageUtil.objectToRestMessage(userDetailsService.delete(uid));
    }
}
