package com.example.movierental.services;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.Serializable;

@Named
@ViewScoped
public class MovieDownloadService implements Serializable {
    public void downloadMovie(String movieId) {
        Client client = ClientBuilder.newClient();

        String url = "https://amazon.movies.com/api/movies/" + movieId + "/download";
        Invocation.Builder requestBuilder = client.target(url)
                .request(MediaType.APPLICATION_JSON);

        Response response = requestBuilder.post(Entity.json(null));
        if (response.getStatus() == Response.Status.OK.getStatusCode()) {
            String responseBody = response.readEntity(String.class);
            System.out.println("Response: " + responseBody);
        } else {
            System.out.println("API call failed with status: " + response.getStatus());
        }

        response.close();
        client.close();
    }
}
