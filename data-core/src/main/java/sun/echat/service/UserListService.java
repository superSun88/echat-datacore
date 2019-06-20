package sun.echat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import sun.echat.domain.Const;
import sun.echat.domain.UserInfo;
import sun.echat.mapper.UserListMapper;
import sun.echat.util.CommonUtil;

@Service
public class UserListService {

    @Autowired
    private UserListMapper userListMapper;

    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public void onlineUserInfo(UserInfo userInfo){

        UserInfo param = new UserInfo();
        param.setIp(userInfo.getIp());
        List<UserInfo> userInfos = userListMapper.selectUserInfo(param);

        if(CollectionUtils.isEmpty(userInfos)){
            param.setId(CommonUtil.ID());
            param.setNickName(Const.getRandomNickName());
            param.setOnline(1);
            userListMapper.saveUserInfo(param);
        }else{
            userInfo = userInfos.get(0);
            param.setOnline(1);
            param.setId(userInfo.getId());
            userListMapper.updateUserInfo(param);
        }
    }

    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public void offlineUserInfo(UserInfo userInfo){

        UserInfo param = new UserInfo();
        param.setIp(userInfo.getIp());
        List<UserInfo> userInfos = userListMapper.selectUserInfo(param);

        if(!CollectionUtils.isEmpty(userInfos)){
            userInfo = userInfos.get(0);
            param.setOnline(0);
            param.setId(userInfo.getId());
            userListMapper.updateUserInfo(param);
        }
    }


    @Transactional(readOnly = true)
    public List<UserInfo> selectUserInfo(UserInfo userInfo){
        return userListMapper.selectUserInfo(userInfo);

    }

   
}
