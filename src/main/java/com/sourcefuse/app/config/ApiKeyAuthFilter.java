package com.sourcefuse.app.config;

import java.io.IOException;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ApiKeyAuthFilter extends OncePerRequestFilter
{

	private String apiKeyHeader;

	private AuthenticationManager authenticationManager;

	public ApiKeyAuthFilter(String apiKeyHeader)
	{
		this.apiKeyHeader = apiKeyHeader;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain)
			throws ServletException, IOException
	{
		try
		{

			filterChain.doFilter(req, res);
		} catch (Exception e)
		{
			res.sendError(HttpServletResponse.SC_UNAUTHORIZED);
			return;
		}

	}

	public void setAuthenticationManager(AuthenticationManager authenticationManager)
	{
		this.authenticationManager = authenticationManager;
	}

}
