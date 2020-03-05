package httpMqtt;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;

@Controller
public class CusErrorController implements ErrorController {

	@RequestMapping("/error")
	@ResponseBody
	public String handleError(HttpServletRequest request) {
		return "Hello :)";
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}
}