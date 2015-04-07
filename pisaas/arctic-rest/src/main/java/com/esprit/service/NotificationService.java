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
	public String GetNotificationById(@PathParam("IdNot") String a){
		
		return httpClient.GET("http://recrut.azurewebsites.net/api/Notification/"+a);
	}
	
	@POST
	@Path("/CreateNotification")
	@Consumes(MediaType.APPLICATION_JSON)
	public void CreateNotification(String NotificationJson){
		System.out.println(NotificationJson);
		System.out.println("************************************");
		httpClient.POST("http://recrut.azurewebsites.net/api/Notification",NotificationJson);
	}
	
	@DELETE
	@Path("/{IdNot}")
	public String suppNotification(@PathParam("IdNot") String a){
		
		return httpClient.DELETE("http://recrut.azurewebsites.net/api/Notification/"+a);
	}
	
	@PUT
	@Path("/{IdNot}")
	@Consumes(MediaType.APPLICATION_JSON)
	public String UpdateNotification(@PathParam("IdNot") Integer a, String b)
	{
		return httpClient.PUT("http://recrut.azurewebsites.net/api/Notification/"+a,b);
	}
	
}

