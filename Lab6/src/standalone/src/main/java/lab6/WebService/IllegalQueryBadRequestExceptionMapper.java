package lab6.WebService;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class IllegalQueryBadRequestExceptionMapper implements ExceptionMapper<IllegalQueryBadRequestException> {
    @Override
    public Response toResponse(IllegalQueryBadRequestException e) {
        return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
    }
}