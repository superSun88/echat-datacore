package sun.echat.datacore;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import sun.echat.EchatApplication;
import sun.echat.domain.UserInfo;
import sun.echat.service.UserListService;
import sun.echat.service.UserListService;
import sun.echat.util.CommonUtil;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EchatApplication.class)
public class EchatApplicationTests {
	private static final Logger logger = LoggerFactory.getLogger(EchatApplicationTests.class);


	@Resource
	private UserListService userListService;

	
	
	@Test
	public void contextLoads() {
		logger.info("dfdfdsf");
		UserInfo userInfo = new UserInfo();
		userInfo.setId(CommonUtil.ID());
		userInfo.setIp("127.0.0.1");
		userInfo.setNickName("a");
		try{
			// userListService.saveUserInfo(userInfo);

		}catch(Exception e){
			logger.error("",e);
			throw e;
		}
	}

}
