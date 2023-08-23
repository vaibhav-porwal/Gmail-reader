package com.dishoom.resources;

import com.dishoom.gmail.EmailService;
import com.google.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

@Path("/v1")
@Singleton
@Slf4j
@Produces(MediaType.APPLICATION_JSON)
public class KoohooResource {

    private final EmailService emailService;

    @Inject
    public KoohooResource(EmailService emailService) {
        this.emailService = emailService;
    }

    @GET
    @Path("/extractOtp")
    public Response extractOtp() {
        return Response.ok().entity(emailService.extractLatestOtp())
            .build();
    }
}
