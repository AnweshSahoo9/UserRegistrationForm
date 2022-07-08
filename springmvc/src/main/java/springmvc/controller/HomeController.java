package springmvc.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/first")
public class HomeController {

	//Model 
	@RequestMapping(path="/home" ,method=RequestMethod.GET)
	public String home(Model model)
	{
		System.out.println("This is home url");
		model.addAttribute("name","Anwesh Sahoo");
		model.addAttribute("id", 1421);
		
		List<String> friends = new ArrayList<String>();
		friends.add("Vandan");
		friends.add("Roshni");
		friends.add("ABC");
		friends.add("Uttam");
		
		model.addAttribute("f", friends);
		
		return "index";  //this is the name of the view that we saw in spring-servlet
	}
	
	@RequestMapping("/about")
	public String about()
	{
		System.out.println("this is about controller");
		return "about";
	}
	
	//ModelAndView
	@RequestMapping("/help")
	public ModelAndView help() {
		System.out.println("This is help Controller");
		
		//creating model and view object
		ModelAndView modelAndView = new ModelAndView();
		
		//setting the data
		modelAndView.addObject("name","Uttam Shukla");
		modelAndView.addObject("rollnumber",123414);
		LocalDateTime now =	LocalDateTime.now();
		modelAndView.addObject("time",now);
		
		//marks
		List<Integer> list = new ArrayList<Integer>();
		list.add(12);
		list.add(3434);
		list.add(2134);
		list.add(2345);
		list.add(9090900);
		
		modelAndView.addObject("marks", list);
		
		
		//setting the view name
		modelAndView.setViewName("help");
		
		return modelAndView;
	}
}
