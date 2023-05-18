package com.sourcefuse.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig
{

	@Value("${api.header.name}")
	private String apiKeyHeader;

	@Value("${api.key}")
	private String secretKey;

	public SecurityFilterChain filterChain1(HttpSecurity http) throws Exception
	{

		ApiKeyAuthFilter filter = new ApiKeyAuthFilter(apiKeyHeader);
		filter.setAuthenticationManager(new AuthenticationManager()
		{

			@Override
			public Authentication authenticate(Authentication authentication) throws AuthenticationException
			{
				String principal = (String) authentication.getPrincipal();
				if (!secretKey.equals(principal))
				{
					throw new BadCredentialsException("The API key not valid.");
				}
				authentication.setAuthenticated(true);
				return authentication;
			}

		});
		http.securityMatcher("/source/**").csrf().disable().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().addFilter(filter).authorizeRequests()
				.anyRequest().authenticated();

		return http.build();
	}

}
