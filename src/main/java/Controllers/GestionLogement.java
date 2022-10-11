package Controllers;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import Entities.Logement;
import Entities.RendezVous;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Path("/LOgement")
@Api
public class GestionLogement {

	public static List<Logement> listLog =new  ArrayList<Logement>() ;  


	public GestionLogement() {

		Logement Log1 = new Logement(1,"27, Rue des roses","Ariana","Studio","cuisine equipee","ghazela",400) ; 
		Logement Log2 = new Logement(2,"30, Rue des fleures","tunis","Studio","cuisine equipee","lac",1400) ; 
		listLog.add(Log1) ; 
		listLog.add(Log2) ; 
		System.out.print(listLog);

}
	
	public int getIndex(List <Logement> l , Logement r ) {
		for(Logement t:l) {
			if(t.getReference()==r.getReference()) 
				return l.indexOf(r); 
			
		}
		return -1 ;
		
	}
	
	
	
	@Path("/AllLogements")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "get all Log")
	@ApiResponses({
		@ApiResponse(code=200, message="Success")
	})
 		
		public Response displayLogements() {
			GenericEntity<List<Logement>> entity = new GenericEntity<List<Logement>>(listLog) {}; 

			if(listLog.size()!=0)
				return Response.status(Status.OK).entity(entity).build();
			else
				return Response.status(Status.NOT_FOUND).build();
		 

	}
	
	@Path("/RetrieveLogementByDelegation/") 
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "retrieve logement by delegation ")
	@ApiResponses({
		@ApiResponse(code=200, message="Success")
	})
	public Response getlistLog(@QueryParam(value="delegation") String delegation)
	{
		List<Logement> listLogements = new ArrayList<Logement>() ; 
		for (Logement l:listLog) {
	       if((l.getDelegation()).equals(delegation)) {
	    	   listLogements.add(l);
	    	   	    	
	    	
	       }
		}
		
		if(listLogements.size()!=0)
 	   return Response.status(Status.OK).entity(listLogements).build();

		return Response.status(Status.NOT_FOUND).entity("n'existe pas un logement avec la delegation entré").build();
		
	}	
	
	@Path("/RetrieveLogementByGouvernorat/") 
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "retrieve logement by gouvernorat ")
	@ApiResponses({
		@ApiResponse(code=200, message="Success")
	})
	public Response getlistLogbygouv(@QueryParam(value="gouvernorat") String g)
	{
		List<Logement> listLogements = new ArrayList<Logement>() ; 
		for (Logement l:listLog) {
	       if((l.getGouvernorat()).equals(g)) {
	    	   listLogements.add(l);
	    	   	    	
	    	
	       }
		}
		
		if(listLogements.size()!=0)
 	   return Response.status(Status.OK).entity(listLogements).build();

		return Response.status(Status.NOT_FOUND).entity("n'existe pas un logement avec la gouvernorat entré").build();
		
	}
 
	@Path("/RetrieveLogementByType/") 
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "retrieve logement by type ")
	@ApiResponses({
		@ApiResponse(code=200, message="Success")
	})
	public Response getlistLogbytype(@QueryParam(value="type") String t)
	{
		List<Logement> listLogements = new ArrayList<Logement>() ; 
		for (Logement l:listLog) {
	       if((l.getGouvernorat()).equals(t)) {
	    	   listLogements.add(l);
	    	   	    	
	    	
	       }
		}
		
		if(listLogements.size()!=0)
 	   return Response.status(Status.OK).entity(listLogements).build();

		return Response.status(Status.NOT_FOUND).entity("n'existe pas un logement avec la gouvernorat entré").build();
		
	}

	
	
	@Path("/LogementByRef") 
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "logement by ref")
	@ApiResponses({
		@ApiResponse(code=200, message="Success")
	})
	public Response getlistRDV(@QueryParam(value="refLogement") int ref)
	{

 		for (Logement l:listLog) {
	       if(l.getReference()==ref) {
	     	   return Response.status(Status.OK).entity(l).build();

 	    	
	    	
	       }
		}
 		
  	   return Response.status(Status.OK).entity("logement n'existe pas avec ce ref").build();

	}
	
	
	@Path("/LogementByPrice") 
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "logement by prix max")
	@ApiResponses({
		@ApiResponse(code=200, message="Success")
	})
	public Response getLogByMaxPrice(@QueryParam(value="maxprice") float prix)
	{
		List<Logement> listLogements = new ArrayList<Logement>() ; 

 		for (Logement l:listLog) {
	       if(l.getPrix()< prix) {
	    	   
	    	   listLogements.add(l);
	    	   

 	    	
	    	
	       }

		}
 		if(listLogements.size()!=0)
 			return Response.status(Status.OK).entity(listLogements).build();

			return Response.status(Status.OK).entity("n'existe pas des logements avec ce limite de prix ").build();

 		


	}
	
	
	
	
	/*
	@Path("/Logement/add")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Post a RDV")
	@ApiResponses({
		@ApiResponse(code=200, message="Success")
	})
	public Response addLogement(Logement rdv) {
		if(listLog.add(rdv)) {
			return Response.status(Status.OK).entity("RDV added successfully").build() ;
		}
		
		return Response.status(Status.NOT_ACCEPTABLE).entity("RDV added successfully").build() ;

	}
	
	@Path("/Logement") 
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Post a RDV")
	@ApiResponses({
		@ApiResponse(code=200, message="Success")
	})
	public Response getlistLog(@QueryParam(value="refLogement") int ref)
	{
		List<Logement> refRdv = new ArrayList<Logement>() ; 
		for (Logement r:listLog) {
	       if(r.getL().getReference()==ref) {
	    	   
	    	   refRdv.add(r);
	    	
	    	
	       }
		}
		
		if(refRdv.size()!=0)
 	   return Response.status(Status.OK).entity(refRdv).build();

		return Response.status(Status.NOT_FOUND).entity("n'existe pas").build();
		
	}	
	
	
	
	@Path("/Logement/{id}") 
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Post a RDV")
	@ApiResponses({
		@ApiResponse(code=200, message="Success")
	})
	public Response getRDV(@PathParam(value="id") int id)
	{
		List<Logement> refRdv = new ArrayList<Logement>() ; 
		for (Logement r:listLog) {
	       if(r.getL().getReference()==id) {
	    	   
	    	     	   return Response.status(Status.OK).entity(r).build();

	    	
	    	
	       }

		}
			       		return Response.status(Status.NOT_FOUND).entity("n'existe pas").build();

		 

		
	}	
	
	
	@Path("delete/Logement/{id}")
	@DELETE 
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "DELETE a RDV")
	@ApiResponses({
		@ApiResponse(code=200, message="Success")
	})
	public Response deleteRdv(@PathParam(value="id") int id ) {
		
		for(Logement r:listLog) {
			if(r.getId()==id) {
				listLog.remove(id);
				return Response.status(Status.OK).entity("deleted ").build() ; 
			}
		}
		return Response.status(Status.OK).entity("no RDV found with this id ").build() ; 

		
	}


	
	@Path("update/Logement/{id}")
	@PUT 
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "update a RDV")
	@ApiResponses({
		@ApiResponse(code=200, message="Success")
	})
	public Response udateRdv(@PathParam(value="id") int id ) {
		
		for(Logement r:listLog) {
			if(getIndex(listLog,r) != -1 ) {
				listLog.set(getIndex(listLog,r),r) ; 
				return Response.status(Status.OK).entity("updated").build();
			}
		}
		return Response.status(Status.NOT_FOUND).entity("Rdv not found").build();

	 

		
	}
*/
}
