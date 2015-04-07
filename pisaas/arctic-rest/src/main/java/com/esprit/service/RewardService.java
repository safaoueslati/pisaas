package com.esprit.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.esprit.http.client.MyHTTPClient;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Path("/RewardService")
@Stateless
public class RewardService {
	@EJB
	MyHTTPClient httpClient;
	
	@GET
	@Path("/Reward")
	@Produces(MediaType.APPLICATION_JSON)
	public String GetReward(){
		
		return httpClient.GET("http://recrut.azurewebsites.net/api/Reward");
	
	}
	
	@GET
	@Path("/{Id_rew}")   
	@Produces(MediaType.APPLICATION_JSON)
	public String GetRewardById(@PathParam("Id_rew") String a){
		
		return httpClient.GET("http://recrut.azurewebsites.net/api/Reward/"+a);
	}
	
	@POST
	@Path("/CreateReward")
	@Consumes(MediaType.APPLICATION_JSON)
	public void CreateReward(String RewardJson){
		System.out.println(RewardJson);
		System.out.println("************************************");
		httpClient.POST("http://recrut.azurewebsites.net/api/Reward",RewardJson);
	}
	
	@DELETE
	@Path("/{Id_rew}")
	public String suppReward(@PathParam("Id_rew") String a){
		
		return httpClient.DELETE("http://recrut.azurewebsites.net/api/Reward/"+a);
	}
	
	@PUT
	@Path("/{Id_rew}")
	@Consumes(MediaType.APPLICATION_JSON)
	public String UpdateReward(@PathParam("Id_rew") Integer a, String b)
	{
		return httpClient.PUT("http://recrut.azurewebsites.net/api/Reward/"+a,b);
	}
	
	
}

