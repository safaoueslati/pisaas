package com.esprit.service;


import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.esprit.http.client.MyHTTPClient;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Path("/NotificationService")
@Stateless
public class NotificationService {
	@EJB
	MyHTTPClient httpClient;
	
	@GET
	@Path("/Notification")
	@Produces(MediaType.APPLICATION_JSON)
	public String GetNotification(){
		
		return httpClient.GET("http://recrut.azurewebsites.net/api/Notification");
	
	}
	@GET
	@Path("/{IdNot}")   
	@Produces(MediaType.APPLICATION_JSON)
public String getNotifById(@PathParam("IdNot") int a){
		
	Gson gson = new GsonBuilder().create();
	//return httpCylient.GET("http://clouddevprojectwebapi2015.azurewebsites.net/api/User/"+id);
	String cat = gson.fromJson(httpClient.GET("http://recrut.azurewebsites.net/api/Notification/"+a), String.class);

    String json = gson.toJson(cat);
	return json;
	}
	
	@POST
	@Path("/CreateNotification")
	@Consumes(MediaType.APPLICATION_JSON)
	public void CreateNotification(String NotificationJson){
		System.out.println(NotificationJson);
		System.out.println("************************************");
		httpClient.POST("http://recrut.azurewebsites.net/api/Notification",NotificationJson);
	}
	@PUT
	@Path("/{IdNot}")
	@Consumes(MediaType.APPLICATION_JSON)
	public String UpdateReward(@PathParam("IdNot") String a, String b)
	{
		  httpClient.PUT("http://recrut.azurewebsites.net/api/Notification/"+a,b);
		  return b;
	}
}

