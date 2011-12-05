package com.manning.gwtia.ch14.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

public class PhotoDetails implements IsSerializable {
	
	String title;
	String tags;
	String id;
	String thubnailUrl;
	String largeUrl;

	public PhotoDetails() {}

	public PhotoDetails(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getThubnailUrl() {
		return thubnailUrl;
	}

	public void setThubnailUrl(String thubnailUrl) {
		this.thubnailUrl = thubnailUrl;
	}

	public String getLargeUrl() {
		return largeUrl;
	}

	public void setLargeUrl(String largeUrl) {
		this.largeUrl = largeUrl;
	}
	
	
}
