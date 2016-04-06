package onight.tfw.rest.web.action.ext;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;
import onight.tfw.rest.utils.BeanFactory;
import onight.tfw.rest.web.action.BasicCtrl;
import onight.tfw.rest.web.bean.MailInfo;
import onight.tfw.rest.web.bean.ReturnInfo;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("/excomm")
public class EXCommCtrl extends BasicCtrl {

	private static JavaMailSender mailSender = (JavaMailSender)BeanFactory.getBean("mailSender");
	private static SimpleMailMessage simpleMailMessage = (SimpleMailMessage)BeanFactory.getBean("simpleMailMessage");

	/**
	 * ajax发送电子邮件
	 * url:'http://ip/rest/excomm/sendmail' 
	 * data:'{"sendTo":"mail@*.com.cn","sendSubject":"msBao eMail testing","sendText":"msBao eMail DataContent"}' 
	 * type:'POST'
	 * return:' {"description":"failed","retcode":0,"retObj":"","success":false} '
	 */
	@RequestMapping(value="/sendmail",method=RequestMethod.POST)
	@ResponseBody
	public ReturnInfo sendMail(@RequestBody MailInfo mailInfo,HttpServletRequest req) {
		try {
			simpleMailMessage.setTo(mailInfo.getSendTo());
			simpleMailMessage.setSubject(mailInfo.getSendSubject());
			simpleMailMessage.setText(mailInfo.getSendText());
			mailSender.send(simpleMailMessage);
			return ReturnInfo.Success;
		} catch (Exception e) {
			log.warn("sendMail add error..",e);
		}
		return ReturnInfo.Faild;
	}
	
	/**
	 * ajax发送短信
	 * url:'http://ip/rest/excomm/sendmessage' 
	 * data:'{"key1":"value1","key2":"value2",...}' 
	 * type:'POST'
	 * return:' {"description":"failed","retcode":0,"retObj":"","success":false} '
	 */
	@RequestMapping(value="/sendmessage",method=RequestMethod.POST)
	@ResponseBody
	public ReturnInfo sendMessage(@RequestBody MailInfo mailInfo,HttpServletRequest req) {
		try {
			simpleMailMessage.setTo(mailInfo.getSendTo());
			simpleMailMessage.setSubject(mailInfo.getSendSubject());
			simpleMailMessage.setText(mailInfo.getSendText());
			mailSender.send(simpleMailMessage);
			
			//MimeMessage mailMessage = mailSender.createMimeMessage();
			//MimeMessageHelper mailMessageHelper = new MimeMessageHelper(mailMessage,true,"utf-8");
			//mailMessageHelper.setTo(mailInfo.getSendTo());
			//mailMessageHelper.setTo(mailInfo.getSendSubject());
			//mailMessageHelper.setTo(mailInfo.getSendText());
			//mailMessageHelper.setFrom(simpleMailMessage.getFrom());
			return ReturnInfo.Success;
		} catch (Exception e) {
			log.warn("sendMail add error..",e);
		}
		return ReturnInfo.Faild;
	}

}
