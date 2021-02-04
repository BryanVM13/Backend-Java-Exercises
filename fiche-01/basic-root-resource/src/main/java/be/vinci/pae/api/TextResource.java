package be.vinci.pae.api;

import java.util.List;

import be.vinci.pae.domain.Text;
import be.vinci.pae.services.DataServiceTextCollection;

import jakarta.inject.Singleton;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Singleton
@Path("/texts")
public class TextResource {
	
	@POST 
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Text create(Text text) {
		if(text == null || text.getContent() == null || text.getContent().isBlank()
				|| text.getLevel() == null || text.getLevel().isEmpty()) 
			throw new WebApplicationException(Response.status(Status.BAD_REQUEST).entity("Lack of mandatory info").type("text/plain").build());			
		
		DataServiceTextCollection.addText(text);
		return text;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Text> getAllTexts(){
		return DataServiceTextCollection.getText();
	}
}
