package com.demo.companies.service;



import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.companies.model.CompaniesModelRs;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * @Descripction: Implementación de Servicio Companies
 * @Autor: Sofía Orozco (sofia.orozco@ibm.com)
 * @version: 1
 */
@Service("GetCompaniesService")
public class GetCompaniesService implements IgetCompanies {
	
	@Autowired
	private RestTemplate restTemplate;
	@Value("${urlCompanies}")
	private String urlCompanies;
	Gson gson = new Gson();

	@Override
	public CompaniesModelRs getCompaniesList(String type) throws Exception {
		CompaniesModelRs companieObj = new CompaniesModelRs();
		try {
			String respEntity = restTemplate.exchange(urlCompanies, HttpMethod.GET,null, String.class).getBody();
			JsonArray listArrayCompanies = gson.fromJson(respEntity, JsonArray.class);
			for(int i = 0; i < listArrayCompanies.size(); i++) {
				JsonObject obj = listArrayCompanies.get(i).getAsJsonObject();
				CompaniesModelRs companie = gson.fromJson(obj, CompaniesModelRs.class);
				if(companie.getId().equals(type)) {
					companieObj = companie;
				}
			}
		}
		
		catch (Exception e) {
			throw new Exception(e.getMessage(), e.getCause());
		}
				
		return companieObj;
	}

}
