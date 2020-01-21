/**
 * 
 */
package com.strandls.traits;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.strandls.activity.controller.ActivitySerivceApi;
import com.strandls.observation.controller.ObservationServiceApi;
import com.strandls.taxonomy.controllers.TaxonomyServicesApi;

/**
 * @author Abhishek Rudra
 *
 */
@Singleton
public class SwaggerFilter implements Filter {

	@Inject
	public TaxonomyServicesApi taxonomyService;

	@Inject
	public ActivitySerivceApi activityService;

	@Inject
	public ObservationServiceApi observationService;

	/**
	 * 
	 */
	public SwaggerFilter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request2 = (HttpServletRequest) request;

		String header = request2.getHeader(HttpHeaders.AUTHORIZATION);

		taxonomyService.getApiClient().addDefaultHeader(HttpHeaders.AUTHORIZATION, header);
		activityService.getApiClient().addDefaultHeader(HttpHeaders.AUTHORIZATION, header);
		observationService.getApiClient().addDefaultHeader(HttpHeaders.AUTHORIZATION, header);

		chain.doFilter(request2, response);
	}

}
