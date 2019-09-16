package com.mycompany.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Image {
	
	private Long imageId;
	private String description;
	private String url;
	public Image(Long imageId, String description, String url) {
		super();
		this.imageId = imageId;
		this.description = description;
		this.url = url;
	}
	
	
	
	
	

}
