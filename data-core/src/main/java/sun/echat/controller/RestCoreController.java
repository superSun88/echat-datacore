package sun.echat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sun.echat.domain.UserInfo;
import sun.echat.service.UserListService;
import sun.echat.util.CommonUtil;

@RestController
public class RestCoreController {
   
    @Autowired
    private UserListService userListService;
    
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String index(){

        UserInfo userInfo = new UserInfo();
		userInfo.setId(CommonUtil.ID());
		userInfo.setIp("127.0.0.1");
		userInfo.setNickName("a");
		userListService.saveUserInfo(userInfo);
        return "hello";
    }
}