package ru.verlioka.cmf.samples;

import java.security.Principal;
import java.util.Locale;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping(value = "/study")
public class StudyController {
	//Так можно объявить используемые контроллеры
	public static final String REQUEST_METHOD_VIEW_NAME = "study_jsp/get_post_demo";
	public static final String OTHER_VIEW_NAME = "study_jsp/home";
	public static final String CONTENT_VIEW_NAME = "study_jsp/content_demo";
	//Формируем и передаем страницу study	
	//В представление study.jsp передаем параметры
	
	@RequestMapping(value = "/simple1")                // Идентификатор метода: http://localhost:8080/gastroli/study/simple1
	public String simpleModel1(Model model) {
		model.addAttribute("name", "John");
		model.addAttribute("path", "/simple1");
		return "study_jsp/study";
	}

	
	@RequestMapping(value = "/simple2")                // Идентификатор метода http://localhost:8080/gastroli/study/simple2
	public ModelAndView simpleModel2() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("study_jsp/study");
		mav.addObject("name", "John");
		mav.addObject("path", "/simple2");
		return mav;
	}
	
	
	// Идентификатор метода http://localhost:8080/gastroli/study/pathvariable/<имя_категории>/<имя_продукта>/
	// С помощью @PathVariable можно передавать в контроллер части адресной строки (сама строка может варьироваться)
	@RequestMapping(value = "/pathvariable/{category}/{product}")
	public String pathVariable(@PathVariable String category, @PathVariable("product") String productName, Model model) {
		
		model.addAttribute("categoryName", category);
		model.addAttribute("productName", productName);
		
		return "study_jsp/path_var_demo";
	}
		
	// Идентификатор метода http://localhost:8080/gastroli/study/requestmethod
	@RequestMapping(value = "/requestmethod", method = RequestMethod.GET)  
	public String requestMethodGet(Model model) {
		model.addAttribute("method", "get");
		return REQUEST_METHOD_VIEW_NAME;
	}

	// Идентификатор метода http://localhost:8080/gastroli/study/requestmethod
	// Используется в конструкциях, передающих данные методом POST, например, в HTML-формах
	// Можно сделать через спец инструменты, например, в Google Chrome есть Advanced REST Client
	@RequestMapping(value = "/requestmethod", method = RequestMethod.POST)
	public String requestMethodPost(Model model) {
		model.addAttribute("method", "post");
		return REQUEST_METHOD_VIEW_NAME;
	}
	
	// Идентификатор метода http://localhost:8080/gastroli/study/headers
	//Дополнительно проверяет тип заголовка и вызывается, если тип - text 
	@RequestMapping(value = "/headers", headers="content-type=text/*")
	public String headersText(Model model) {
		
		model.addAttribute("contentType", "text/*");
		
		return OTHER_VIEW_NAME;
	}

	//Идентификатор метода http://localhost:8080/gastroli/study/headers
	//Дополнительно проверяет тип заголовка и вызывается, если тип - json	
	@RequestMapping(value = "/headers", headers="content-type=application/json")
	public ResponseEntity<String> headersJson() {
		String json = "{\"contentType\":\"application/json\"}";
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<String>(json, responseHeaders, HttpStatus.CREATED);
	}
	
	//Идентификатор метода http://localhost:8080/gastroli/study/webrequest
    //WebRequest позволяет оперировать большим количеством полезных параметров (см. доки)
	@RequestMapping(value = "/webrequest")
	public String webRequest(WebRequest webRequest, Model model) {
		model.addAttribute("content", "Session id (WebRequest): " + webRequest.getSessionId() );
		return CONTENT_VIEW_NAME;
	}
	
	//Идентификатор метода http://localhost:8080/gastroli/study/locale
	@RequestMapping(value = "/locale")
	public String locale(Locale locale, Model model) {
		model.addAttribute("content", "Locale language: " + locale.getLanguage() );
		return CONTENT_VIEW_NAME;
	}
	
	//Идентификатор метода http://localhost:8080/gastroli/study/principal
	@RequestMapping(value = "/principal")
	public String principal(Principal principal, Model model) {
		model.addAttribute("content", "Principal: " + (principal == null ? "null" : principal.getName() ) );
		return CONTENT_VIEW_NAME;
	}
	
	//Идентификатор метода http://localhost:8080/gastroli/study/responsebody
	// Передаем результат непосредственно в браузер, минуя представление
	@RequestMapping(value = "/responsebody")
	@ResponseBody
	public String responseBody()  {
	  return "Hello World";
	}

	// ------------------------------------------------------
	
	
}