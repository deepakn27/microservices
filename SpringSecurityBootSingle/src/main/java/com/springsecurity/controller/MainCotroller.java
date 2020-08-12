package com.springsecurity.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springsecurity.service.ApplicationDataService;

@Controller
@RequestMapping
public class MainCotroller {

	@Value("${session.max.interval}")
	String maxinterval;
	
	
	@Autowired
	ApplicationDataService appdataService;
	
	 @RequestMapping(value = { "/" }, method = RequestMethod.GET)
	    public String welcomePage(Model model) {
		   
		 return "redirect:/login";
	    }
	 
	    @RequestMapping(value = "/admin", method = RequestMethod.GET)
	    public String adminPage(Model model, Principal principal) {
	         
	        User loginedUser = (User) ((Authentication) principal).getPrincipal();
	 
	        
	        model.addAttribute("userInfo",loginedUser.toString());
	         
	        return "adminPage";
	    }
	 
	    @RequestMapping(value = "/login", method = RequestMethod.GET)
	    public String loginPage(Model model,@RequestParam(value = "error", required = false) Boolean error, 
	            @RequestParam(value = "logout", required = false) Boolean logout,
	            @RequestParam(value = "maxsession", required = false) Boolean maxsession
	            , @RequestParam(value = "emailid", required = false) String emailid
	            ,@RequestParam(value = "invalidsession", required = false) Boolean invalidsession) {
	 
	    	 
	    	 
	    	 if (emailid!=null) {
	    		 model.addAttribute("emailid",emailid);
	 	    	}
	    	 
	    	if (error != null && error.equals(true)) {
	    	model.addAttribute("error", "Invalid Credential"); 
	    	}
	    	
	    	if (logout != null && logout.equals(true)) {
	    	model.addAttribute("logout", "User Logged Out"); 
	    	}
	    	
	    	if (maxsession != null && maxsession.equals(true)) {
		    	model.addAttribute("maxsession", "Maximum Session Exceeded,Only one session is allowed per user"); 
		    	}
	    	
	    	if (invalidsession != null && invalidsession.equals(true)) {
		    	model.addAttribute("invalidsession", "Session is invalid"); 
		    	}
	    	
	    	if (maxsession != null && maxsession.equals(true)) {
		    	model.addAttribute("maxsession", "Another session is already active"); 
		    	}
	        return "loginPage";
	    }
	 
	    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
	    public String logoutSuccessfulPage(Model model) {
	        model.addAttribute("title", "Logout");
	        return "logoutSuccessfulPage";
	    }
	 
	    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	    public String userInfo(Model model, Principal principal,HttpSession session) {
	    	System.out.println("maxinterval - "+ session.getMaxInactiveInterval());
	        String userName = principal.getName();
	        return "redirect:/openUserDashboard";
	    }
	    
	    @RequestMapping(value = "/openUserDashboard", method = RequestMethod.GET)
	    public String openUserDashboard(Model model, Principal principal) {
	    		String appData = appdataService.getApplicationData();
	    	System.out.println("appData = "+ appData);
	    	 model.addAttribute("userInfo", appData);
	    	 return "userInfoPage";
	    }
	 
	    @RequestMapping(value = "/403", method = RequestMethod.GET)
	    public String accessDenied(Model model, Principal principal) {
	 
	        if (principal != null) {
	            User loginedUser = (User) ((Authentication) principal).getPrincipal();
	 
	            
	 
	            model.addAttribute("userInfo", loginedUser.toString());
	 
	            String message = "Hi " + principal.getName() //
	                    + "<br> You do not have permission to access this page!";
	            model.addAttribute("message", message);
	 
	        }
	 
	        return "403Page";
	    }
	    
	    
	    @RequestMapping(value="/prelogin",method=RequestMethod.POST,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
        public String createRole(@RequestBody MultiValueMap<String, String> formData){
	    	
	    	List<String> username = formData.get("username");
	    	String emailid = username.get(0);
	    	System.out.println(emailid);
	    	return "redirect:/login?emailid="+emailid;
          }
	    
	   
}
