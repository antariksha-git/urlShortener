package com.ex.us.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ex.us.service.UrlService;

@Controller
public class UrlController {
	
	private UrlService urlService;
	
	public UrlController(UrlService urlService) {
		this.urlService = urlService;
	}
	
	@RequestMapping("/app/{shortUrl}")
	public String redirectToActualUrl(@PathVariable("shortUrl") String shortUrl) {
		String actualUrl = urlService.findActualUrlByShortUrl(shortUrl);
		return "redirect:" + actualUrl;
	}
	
	@GetMapping("/")
	public String getHome(Model model) {
		model.addAttribute("urls", urlService.getAllUrls());
		return "home.jsp";
	}
	
	@GetMapping("/delete-url")
	public String deleteUrl(@RequestParam("shortUrl") String shortUrl) {
		urlService.deleteActualUrlByShortUrl(shortUrl);
		return "redirect:/";
	}
	
	@PostMapping("save-url")
	public String saveUrl(@RequestParam("actualUrl") String actualUrl) {
		urlService.saveUrl(actualUrl);
		return "redirect:/";
	}
	
	
}
