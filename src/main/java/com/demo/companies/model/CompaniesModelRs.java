package com.demo.companies.model;

import java.util.ArrayList;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CompaniesModelRs {
	
	private String id;
	private String company;
	private String description;
	private ArrayList<VideoModel> videos;
	

}
