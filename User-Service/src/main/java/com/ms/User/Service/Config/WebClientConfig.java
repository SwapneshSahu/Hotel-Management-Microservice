package com.ms.User.Service.Config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;


@Configuration
public class WebClientConfig {

	
	@Bean
	//@LoadBalanced
	public  WebClient getWebClient() {
	    return WebClient.builder().build();
	}

//	 private final LoadBalancerClient loadBalancerClient;
//
//	    public WebClientConfig(LoadBalancerClient loadBalancerClient) {
//	        this.loadBalancerClient = loadBalancerClient;
//	    } 
////	@Bean
////	@LoadBalanced
////	public WebClient.Builder loadBalancedWebClientBuilder() {
////		return WebClient.builder().filter(new LoadBalancerExchangeFilterFunction());
////	}
//
//	@Bean
//	public WebClient getWebClient() {
//		return WebClient.builder().build();
//	}
	
	
}
