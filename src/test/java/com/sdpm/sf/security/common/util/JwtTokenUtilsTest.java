package com.sdpm.sf.security.common.util;

import com.sdpm.sf.security.dto.SfUserDTO;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author shirukai
 */
public class JwtTokenUtilsTest {

    @Test
    public void createToken() throws Exception {
        SfUserDTO sfUserDTO = new SfUserDTO();
        sfUserDTO.setId(13453L);
        sfUserDTO.setPassword("2");
        sfUserDTO.setUrl("");
        sfUserDTO.setUsername("派蒙");
        sfUserDTO.setRole("admin");
        String token = JwtTokenUtils.createToken(sfUserDTO);
        System.out.println(JwtTokenUtils.validateToken(token));

    }

    @Test
    public void validateToken() {
        System.out.println(JwtTokenUtils.validateToken("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxIiwiaWQiOiIxIiwidXNlcm5hbWUiOiLmtL7okpkifQ.t-vJi1f_NrjclS-CSyHUS30Yq_xqJ1TxaGve6lmPsyk"));
    }
}