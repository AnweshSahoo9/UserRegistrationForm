package springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springmvc.model.User;
import springmvc.service.UserService;

@Controller
public class ContactController {
	
	@Autowired
	private UserService userService;
	
	
	@ModelAttribute
	public void commonDataForModel(Model m) {
		m.addAttribute("Header", "LearnCodeWith Durgesh");
		m.addAttribute("Desc", "Home for Programmer");
	}

	@RequestMapping("/contact")
	public String showForm(Model m)
	{
		
		return "contact";
	}
	
	/*
	 * @RequestMapping(path="/processform",method=RequestMethod.POST) public String
	 * handleForm(
	 * 
	 * @RequestParam(name="email", required=true) String userEmail,
	 * 
	 * @RequestParam("userName") String userName,
	 * 
	 * @RequestParam("password") String userPassword, Model model) //by default
	 * required is true, you can set it to false if it's optional { //
	 * System.out.println("user email "+userEmail); //
	 * System.out.println("user name "+userName); //
	 * System.out.println("user password "+userPassword);
	 * 
	 * User user = new User(); user.setEmail(userEmail); user.setUserName(userName);
	 * user.setPassword(userPassword);
	 * 
	 * System.out.println(user);
	 * 
	 * // model.addAttribute("name", userName); // model.addAttribute("email",
	 * userEmail); // model.addAttribute("password", userPassword);
	 * 
	 * model.addAttribute("user", user); return "success"; }
	 */
	
	
	//ModelAttribute
	@RequestMapping(path="/processform",method=RequestMethod.POST)
	public String handleForm(@ModelAttribute User user, Model model)
	{
		System.out.println(user);
		
		//process
		//model.addAttribute("user", user);
		
		this.userService.createUser(user);
		int createdUser = this.userService.createUser(user);
		model.addAttribute("msg", "User created with id "+createdUser);
		return "success";
	}
}
