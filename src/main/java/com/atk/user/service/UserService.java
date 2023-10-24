package com.atk.user.service;

import com.atk.user.VO.Department;
import com.atk.user.VO.ResponseTemplate;
import com.atk.user.entity.SysUser;
import com.atk.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;

    public SysUser saveUser(SysUser sysUser) {
        return userRepository.save(sysUser);
    }

    public ResponseTemplate getUserWithDepartment(Long userId) {
        SysUser sysUser = userRepository.findByUserId(userId);
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + sysUser.getDepartmentId(),Department.class);
        ResponseTemplate responseTemplate = new ResponseTemplate();
        responseTemplate.setSysUser(sysUser);
        responseTemplate.setDepartment(department);

        return responseTemplate;
    }
}
