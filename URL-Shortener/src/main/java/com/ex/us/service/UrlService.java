package com.ex.us.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ex.us.entity.Url;
import com.ex.us.repository.UrlRepository;
import com.example.utils.RandomStringGenerator;

@Service
public class UrlService {
	
	private UrlRepository urlRepository;
	
	public UrlService(UrlRepository urlRepository) {
		this.urlRepository = urlRepository;
	}
	
	public void saveUrl(String actualUrl) {
		Url url = new Url();
		url.setActualUrl(actualUrl);
		url.setShortUrl(RandomStringGenerator.generateRandomString());
		urlRepository.saveUrl(url);
	}
	
	public List<Url> getAllUrls() {
		return urlRepository.getAllUrls();
	}
	
	public String findActualUrlByShortUrl(String shortUrl) {
		return urlRepository.findActualUrlByShortUrl(shortUrl);
	}

	public void deleteActualUrlByShortUrl(String shortUrl) {
		urlRepository.deleteActualUrlByShortUrl(shortUrl);
	}

}
