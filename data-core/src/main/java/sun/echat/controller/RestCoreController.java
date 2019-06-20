package sun.echat.controller;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sun.echat.domain.Response;
import sun.echat.domain.UserInfo;
import sun.echat.service.UserListService;

@RestController
public class RestCoreController {
    private static final Logger logger = LoggerFactory.getLogger(RestCoreController.class);
   
    @Autowired
    private UserListService userListService;
    
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String index(){

    
        return "hello";
    }

    @RequestMapping(value = "/onlineUser",method = RequestMethod.POST)
    public Response<String> onlineUser(UserInfo userInfo){
        logger.info("创建或者上线用户 user:{}",JSONObject.toJSON(userInfo).toString());  
        Response<String> response = new Response<>();

        //注册新用户
        try{
            userListService.onlineUserInfo(userInfo);
            response.setCode("1");
            response.setMsg("创建用户或者更新上线状态成功");
            return response;

        }catch(Exception e){
            logger.error("创建用户或者更新上线状态异常 user:{}",JSONObject.toJSON(userInfo).toString(),e);
            response.setCode("0");
            response.setMsg("创建用户或者更新上线状态失败");
            return response;

        }
        

    }

    @RequestMapping(value = "/offlineUser",method = RequestMethod.POST)
    public Response<String> offlineUser(UserInfo userInfo){        
        logger.info("下线用户 user:{}",JSONObject.toJSON(userInfo).toString());    
        Response<String> response = new Response<>();

        //注册新用户
        try{
            userListService.offlineUserInfo(userInfo);
            response.setCode("1");
            response.setMsg("下线成功");
            return response;

        }catch(Exception e){
            logger.error("下线失败异常 user:{}",JSONObject.toJSON(userInfo).toString(),e);
           
            response.setCode("0");
            response.setMsg("下线失败");
            return response; 
        }
        

    }

    @RequestMapping(value = "/get_online_users",method = RequestMethod.GET)
    public Response<List<UserInfo>> onlineUsers(){
        logger.info("获取在线用户 ");    
        Response<List<UserInfo>> response = new Response<>();

        //注册新用户
        try{
            UserInfo userInfo = new UserInfo();
            userInfo.setOnline(1);
            List<UserInfo> users = userListService.selectUserInfo(userInfo);
            response.setCode("1");
            response.setMsg("获取在线用户成功");
            response.setData(users);
            return response;


        }catch(Exception e){
            logger.error("获取在线用户异常 ",e);

            response.setCode("0");
            response.setMsg("获取在线用户失败");
            return response;

        }
        

    }


}