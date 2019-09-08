package com.providus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import springfox.documentation.annotations.ApiIgnore;

/**
 * 
 * @author SUMIT VERMA
 *
 */
@Controller
@ApiIgnore
public class HomeController {
	@RequestMapping("/")
	public RedirectView localRedirect() {
	    RedirectView redirectView = new RedirectView();
	    redirectView.setUrl("/swagger-ui.html");
	    return redirectView;
	}
}
