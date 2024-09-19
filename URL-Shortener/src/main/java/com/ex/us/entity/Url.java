package com.ex.us.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "urls")
public class Url {
	@Id
	@Column(name = "short_url")
	private String shortUrl;
	
	@Column(name = "actual_url")
	private String actualUrl;
	
	public Url() {}
	
	public Url(String shortUrl, String actualUrl) {
		this.shortUrl = shortUrl;
		this.actualUrl = actualUrl;
	}

	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

	public String getActualUrl() {
		return actualUrl;
	}

	public void setActualUrl(String actualUrl) {
		this.actualUrl = actualUrl;
	}
	
}
