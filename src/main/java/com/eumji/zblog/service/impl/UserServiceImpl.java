package com.eumji.zblog.service.impl;

import com.eumji.zblog.mapper.UserMapper;
import com.eumji.zblog.vo.User;
import com.eumji.zblog.service.UserService;
import com.eumji.zblog.vo.UserInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;

/**
 * Created by GeneratorFx on 2017-04-11.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User loadUserByUsername(String username) {
        return userMapper.getUser(username);
    }

    @Override
    public UserInfo getUserInfo() {
        return userMapper.getUserInfo();
    }

    @Override
    public void updateAvatar(String url, String username) {
        userMapper.updateAvatar(url,username);
    }
}


