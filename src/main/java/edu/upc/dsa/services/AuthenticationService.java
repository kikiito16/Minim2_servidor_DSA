package edu.upc.dsa.services;

import edu.upc.dsa.GameImpl;
import edu.upc.dsa.GameInterface;
import edu.upc.dsa.models.api.CompleteCredentials;
import edu.upc.dsa.models.api.Credentials;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api(value = "/auth")
@Path("/auth")
public class AuthenticationService {

    private GameInterface gameInterface;

    public AuthenticationService()
    {
        this.gameInterface = GameImpl.getInstance();
    }

    @POST
    @ApiOperation(value = "Sign Up", notes = "Create a new account and log in")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = Integer.class),
            @ApiResponse(code = 404, message = "Username already exists"),

    })
    @Path("/signup")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response signUp(CompleteCredentials cred) {
        int res = gameInterface.signUp(cred);
        if(res == -1)
            return Response.status(404).build();
        else
            return Response.status(200).entity(res).build();
    }


    @POST
    @ApiOperation(value = "Log In", notes = "Authenticate and log in")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = Integer.class),
            @ApiResponse(code = 404, message = "Incorrect username or password"),
            @ApiResponse(code = 409, message = "Unknown error")
    })
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(Credentials cred) {

        int res = gameInterface.logIn(cred.getUsername(), cred.getPassword());

        if(res == -1)
            return Response.status(404).build();
        else if(res == -2)
            return  Response.status(409).build();
        else
            return Response.status(200).entity(res).build();
    }

    @POST
    @ApiOperation(value = "Log Out", notes = "Log out")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 404, message = "User not found")

    })
    @Path("/logout")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response logOut(Credentials cred) {

        int res = gameInterface.logOut(cred.getUsername());

        if(res == 0)
            return Response.status(200).build();
        else
            return Response.status(404).build();
    }

}
