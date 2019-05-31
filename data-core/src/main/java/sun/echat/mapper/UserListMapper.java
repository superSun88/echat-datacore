package sun.echat.mapper;

import java.util.List;
import java.util.Map;

import sun.echat.domain.UserInfo;

public interface UserListMapper {

    public void saveUserInfo(UserInfo userInfo);
    public void updateUserInfo(UserInfo userInfo);
    
    public List<UserInfo> selectUserInfo(UserInfo userInfo);

   
}
