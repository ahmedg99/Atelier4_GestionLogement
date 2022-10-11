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


@Path("/RendezVous")
@Api
public class GestionRendezVous {
	
	
	public static List<RendezVous> listRdv =new  ArrayList<RendezVous>() ;  


	public GestionRendezVous() {

		RendezVous RDV1 = new RendezVous(1, "17-9-2015", "10:15", "55214078",new Logement(1)) ; 
		RendezVous RDV2 = new RendezVous(2, "18-9-2015", "11:15", "55214079",new Logement(1)) ; 
		listRdv.add(RDV1) ; 
		listRdv.add(RDV2) ; 
		System.out.print(listRdv);

}
	
	public int getIndex(List <RendezVous> l , RendezVous r ) {
		for(RendezVous t:l) {
			if(t.getId()==r.getId()) 
				return l.indexOf(r); 
			
		}
		return -1 ;
		
	}
	
	
	
	@Path("/Allrendesvous")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "get all RDV")
	@ApiResponses({
		@ApiResponse(code=200, message="Success")
	})
 		
		public Response displayEmployeesList() {
			GenericEntity<List<RendezVous>> entity = new GenericEntity<List<RendezVous>>(listRdv) {}; 

			if(listRdv.size()!=0)
				return Response.status(Status.OK).entity(entity).build();
			else
				return Response.status(Status.NOT_FOUND).build();
		 

	}
	
 
	
	@Path("/rendezvous/add")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Post a RDV")
	@ApiResponses({
		@ApiResponse(code=200, message="Success")
	})
	public Response addRendezVous(RendezVous rdv) {
		if(listRdv.add(rdv)) {
			return Response.status(Status.OK).entity("RDV added successfully").build() ;
		}
		
		return Response.status(Status.NOT_ACCEPTABLE).entity("RDV added successfully").build() ;

	}
	
	@Path("/rendezvous") 
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Post a RDV")
	@ApiResponses({
		@ApiResponse(code=200, message="Success")
	})
	public Response getlistRDV(@QueryParam(value="refLogement") int ref)
	{
		List<RendezVous> refRdv = new ArrayList<RendezVous>() ; 
		for (RendezVous r:listRdv) {
	       if(r.getL().getReference()==ref) {
	    	   
	    	   refRdv.add(r);
	    	
	    	
	       }
		}
		
		if(refRdv.size()!=0)
 	   return Response.status(Status.OK).entity(refRdv).build();

		return Response.status(Status.NOT_FOUND).entity("n'existe pas").build();
		
	}	
	
	
	
	@Path("/rendezvous/{id}") 
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Post a RDV")
	@ApiResponses({
		@ApiResponse(code=200, message="Success")
	})
	public Response getRDV(@PathParam(value="id") int id)
	{
		List<RendezVous> refRdv = new ArrayList<RendezVous>() ; 
		for (RendezVous r:listRdv) {
	       if(r.getL().getReference()==id) {
	    	   
	    	     	   return Response.status(Status.OK).entity(r).build();

	    	
	    	
	       }

		}
			       		return Response.status(Status.NOT_FOUND).entity("n'existe pas").build();

		 

		
	}	
	
	
	@Path("delete/rendezvous/{id}")
	@DELETE 
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "DELETE a RDV")
	@ApiResponses({
		@ApiResponse(code=200, message="Success")
	})
	public Response deleteRdv(@PathParam(value="id") int id ) {
		
		for(RendezVous r:listRdv) {
			if(r.getId()==id) {
				listRdv.remove(id);
				return Response.status(Status.OK).entity("deleted ").build() ; 
			}
		}
		return Response.status(Status.OK).entity("no RDV found with this id ").build() ; 

		
	}


	
	@Path("update/rendezvous/{id}")
	@PUT 
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "update a RDV")
	@ApiResponses({
		@ApiResponse(code=200, message="Success")
	})
	public Response udateRdv(@PathParam(value="id") int id ) {
		
		for(RendezVous r:listRdv) {
			if(getIndex(listRdv,r) != -1 ) {
				listRdv.set(getIndex(listRdv,r),r) ; 
				return Response.status(Status.OK).entity("updated").build();
			}
		}
		return Response.status(Status.NOT_FOUND).entity("Rdv not found").build();

	 

		
	}
	
	

}
