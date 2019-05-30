package sun.echat.service;

import java.util.List;
import java.util.Map;

import sun.echat.domain.UserInfo;

public interface UserListService {

    public void saveUserInfo(UserInfo userInfo);
    
    public List<UserInfo> selectUserInfo(UserInfo userInfo);

   
}
