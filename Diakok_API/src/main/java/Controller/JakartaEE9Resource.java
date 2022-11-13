package Controller;

import Service.xmlBeolvas;
import business.DiakIro;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import model.Diak;
import org.json.JSONObject;

@Path("jakartaee9")
public class JakartaEE9Resource {

    private DiakIro DiakService = DiakIro.getEgyed();

    @GET // manuálisan megjeleníthető diák
    @Path("DiakManualis")
    @Produces(MediaType.APPLICATION_JSON)
    public Response Diak() {
        Diak d = new Diak("Erik", 19, 4);
        d.tValaszto(d);
        JSONObject obj = new JSONObject();
        obj.put("Diak nev", d.getNev().toString());
        obj.put("Diak kor", d.getKor().toString());
        obj.put("Diak osztaly", d.getOsztaly().toString());
        obj.put("Diak tagozat", d.getTagozat().toString());
        return Response.ok(obj.toString()).build();
    }

    @GET
    @Path("XmlKivalaszt") // ?keres= használatával beírhatjuk, hogy hányadik elemet szeretnénk megtekinteni
    @Produces(MediaType.APPLICATION_JSON)
    public Response Beolvas(@QueryParam("keres") int keres) {
        return Response.ok(new xmlBeolvas().Beolvas(keres).toString()).build();
    }

    @POST // Postman használatával küldhető post kérés
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String createDiak(Diak ujDiak
    ) {
        ujDiak.tValaszto(ujDiak); // A tagozatot nem szükséges megadni, a tValaszto függvény miatt
        return DiakService.addDiak(ujDiak);
    }

    @GET // a POST-al küldött elemeket itt iratja ki a listából
    @Path("lista")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Diak> getCustomers() {
        return DiakService.getdiakList();
    }
}
