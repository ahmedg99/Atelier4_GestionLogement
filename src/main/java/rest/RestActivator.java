package rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import Controllers.GestionLogement;
import Controllers.GestionRendezVous;
import io.swagger.jaxrs.config.BeanConfig;
@ApplicationPath("/rest")
public class RestActivator extends Application{
	@Override
	public Set<Class<?>> getClasses() {

	Set<Class<?>> resources = new HashSet();
	resources.add(GestionRendezVous.class);
	resources.add(GestionLogement.class);
	// Available at localhost:port/swagger.json
	resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
	resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);
	return resources;

	}
	public RestActivator() {
		super();
		
		BeanConfig beanConfig = new BeanConfig();
		
		beanConfig.setVersion("1.0.0");
		beanConfig.setSchemes(new String[]{"http"});
		beanConfig.setHost("localhost:8080");
		beanConfig.setBasePath("atelier4_Logement/rest");
		beanConfig.setResourcePackage("Controllers");
		beanConfig.setScan(true);
	}

}
