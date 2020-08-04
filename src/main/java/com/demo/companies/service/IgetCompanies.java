package com.demo.companies.service;

import com.demo.companies.model.CompaniesModelRs;

public interface IgetCompanies {

	public CompaniesModelRs getCompaniesList(String type) throws Exception;
}
