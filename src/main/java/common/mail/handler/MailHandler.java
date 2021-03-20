package common.mail.handler;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


// 서비스 임플에서 컨트롤러로 요청하는 것이라 여기도 컨트롤러이다
@Controller
public class MailHandler {
	
	@PostMapping("mail")
	public String writeMail(@RequestParam Map<String, Object> data, Model model) {
		
		// 메일에서 링크를 누르는 화면 보여주는 jsp이다.
		// 메일양식이있는 jsp로 이동시켜준다.
		
		// JSP에 뿌려줄 데이터를 모델에담아준다.
		model.addAllAttributes(data);
		
		// view 로 보낸다.
		return "mail-template/" + data.get("mail-template");
	}

}
