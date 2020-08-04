package com.demo.companies.controller;

import java.util.concurrent.Delayed;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.companies.model.CompaniesModelRs;
import com.demo.companies.service.GetCompaniesService;
import com.demo.companies.service.IgetCompanies;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "/")
public class CompaniesController {

	/**
	 * @Description: Controlador del servicio api companies
	 * @Autor: Catalina Sofia Orozco Soto (sofia.orozco@ibm.com)
	 * 
	 */
	final  Logger logger  = LoggerFactory.getLogger(GetCompaniesService.class);
	@Autowired
	private IgetCompanies getCompaniesService;

	@GetMapping(path = "/information")
	public ResponseEntity<Object> getCompanies(@RequestParam(name = "type", required = true) String type)
			throws Exception {
		CompaniesModelRs companieResponse = getCompaniesService.getCompaniesList(type);
		logger.info("Service GetCompanies for: <"+ type + "> success");
		return new ResponseEntity<>(companieResponse, HttpStatus.OK);
	}

}
