package com.sdpm.sf.security.service;

import com.sdpm.sf.security.common.exception.SmartFarmingSecurityException;
import com.sdpm.sf.security.common.util.JwtTokenUtils;
import com.sdpm.sf.security.common.util.PasswordEncryptor;
import com.sdpm.sf.security.dto.SfUserDTO;
import com.sdpm.sf.security.entity.SfUser;
import com.sdpm.sf.security.repository.SfUserRepository;
import com.sdpm.sf.security.vo.SfUserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

/**
 * @author shirukai
 */
@Service
public class UserDetailsService {
    @Autowired
    private SfUserRepository sfUserRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Page<SfUserDTO> findUsersWithPage(Pageable pageable) {
        Page<SfUser> users = sfUserRepository.findAll(pageable);
        return users.map(this::toDTO);
    }

    private SfUserDTO toDTO(SfUser user) {
        SfUserDTO dto = new SfUserDTO();
        BeanUtils.copyProperties(user, dto);
        dto.setToken(JwtTokenUtils.createToken(dto));
        return dto;
    }

    public SfUserDTO login(String username, String password) {
        SfUser sfUser = sfUserRepository.findSfUserByUsername(username.trim());
        if (sfUser == null || !passwordEncoder.matches(password, sfUser.getPassword())) {
            throw new SmartFarmingSecurityException("登录失败，用户不存在或密码不正确。");
        }
        SfUserDTO sfUserDTO = new SfUserDTO();
        BeanUtils.copyProperties(sfUser, sfUserDTO);
        String token = JwtTokenUtils.createToken(sfUserDTO);
        sfUserDTO.setToken(token);
        return sfUserDTO;
    }

    public SfUserDTO loadUserByUsername(String s) {
        SfUser sfUser = sfUserRepository.findSfUserByUsername(s);
        if (sfUser == null) {
            return null;
        }
        SfUserDTO sfUserDTO = new SfUserDTO();
        BeanUtils.copyProperties(sfUser, sfUserDTO);
        return sfUserDTO;
    }

    public SfUserDTO registry(SfUserVO sfUserVO) {
        if (!StringUtils.hasLength(sfUserVO.getUsername())) {
            throw new SmartFarmingSecurityException("用户名不能为空。");
        }
        if (!StringUtils.hasLength(sfUserVO.getPassword())) {
            throw new SmartFarmingSecurityException("密码不能为空。");
        }
        if (sfUserVO.getUrl() == null) {
            throw new SmartFarmingSecurityException("url不能为空。");
        }
        String password = passwordEncoder.encode(sfUserVO.getPassword());
        SfUser sfUser = new SfUser();
        if (sfUserVO.getId() != null) {
            sfUser.setId(sfUserVO.getId());
        }
        sfUser.setDescription(sfUserVO.getDescription());
        sfUser.setUsername(sfUserVO.getUsername());
        sfUser.setPassword(password);
        sfUser.setUrl(sfUserVO.getUrl());
        sfUser.setRole(sfUserVO.getRole());
        sfUser.setBasePassword(PasswordEncryptor.encode(sfUserVO.getPassword()));
        sfUser = sfUserRepository.save(sfUser);
        SfUserDTO sfUserDTO = new SfUserDTO();
        BeanUtils.copyProperties(sfUser, sfUserDTO);
        return sfUserDTO;
    }

    public String delete(Long uid) {
        Optional<SfUser> optional = sfUserRepository.findById(uid);
        if (!optional.isPresent()) {
            throw new SmartFarmingSecurityException("用户不存在。");
        }
        sfUserRepository.delete(optional.get());
        return "删除成功";
    }

    public Optional<SfUser> findById(Long uid) {
        return sfUserRepository.findById(uid);
    }
}
