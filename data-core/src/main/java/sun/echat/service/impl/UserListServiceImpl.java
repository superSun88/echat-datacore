package sun.echat.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import sun.echat.domain.UserInfo;
import sun.echat.mapper.UserListMapper;
import sun.echat.service.UserListService;

@Service
public class UserListServiceImpl implements UserListService{

    private static final Logger logger = LoggerFactory.getLogger(UserListServiceImpl.class);
    @Autowired
    private UserListMapper userListMapper;

    @Override
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public void saveUserInfo(UserInfo userInfo){

        UserInfo param = new UserInfo();
        param.setIp(userInfo.getIp());
        List<UserInfo> userInfos = userListMapper.selectUserInfo(param);
        if(CollectionUtils.isEmpty(userInfos)){
            userListMapper.saveUserInfo(userInfo);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserInfo> selectUserInfo(UserInfo userInfo){
        return userListMapper.selectUserInfo(userInfo);

    }

   
}
