package cn.zzuli.yangoj.utils;

import cn.zzuli.yangoj.exception.BusinessException;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;

/**
 * 短信发送工具类
 */
public class SMSUtils {

	/**
	 * 发送短信
	 * @param signName 签名
	 * @param templateCode 模板
	 * @param phoneNumbers 手机号
	 * @param param 参数
	 */
	public static void sendMessage(String signName, String templateCode, String phoneNumbers, String param){
		DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI5tDEQw885dthvF6NL7ub", "bugWKf34Uq1OuIxLEyQjOwXhO2j0GG");
		IAcsClient client = new DefaultAcsClient(profile);

		SendSmsRequest request = new SendSmsRequest();
		request.setSysRegionId("cn-hangzhou");
		request.setPhoneNumbers(phoneNumbers);
		request.setSignName(signName);
		request.setTemplateCode(templateCode);
		request.setTemplateParam("{\"code\":\""+param+"\"}");
		try {
			SendSmsResponse response = client.getAcsResponse(request);
			if (response == null){
				throw new BusinessException(1001,"发送失败");
			}
		}catch (ClientException e) {
			throw new BusinessException(Integer.parseInt(e.getErrCode()),e.getMessage());
		}
	}

}
