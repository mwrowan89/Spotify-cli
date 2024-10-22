package org.example.services;

import org.apache.hc.core5.http.ParseException;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.credentials.ClientCredentials;
import se.michaelthelin.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;

import java.io.IOException;
import java.net.URI;

public class SpotifyService {
    private final String API_URL = "https://api.spotify.com/v1/search?q=artist:";
    private final String CLIENT_ID = "6c372ce912574a7d9277e273ad0b5be2";
    private final String CLIENT_SECRET = "d87baae9da33459aba91e165dfa180f8";

    SpotifyApi spotifyApi = new SpotifyApi.Builder()
            .setClientId(CLIENT_ID)
            .setClientSecret(CLIENT_SECRET)
            .setRedirectUri(URI.create("http://localhost:9000"))
            .build();

    private final ClientCredentialsRequest CLIENT_CREDENTIAL_REQUEST =
            spotifyApi.clientCredentials().build();
    public SpotifyService() {
        getClientCredentials();
    }


    private void getClientCredentials(){
        try {
            ClientCredentials clientCredentials =
                    CLIENT_CREDENTIAL_REQUEST.execute();
            spotifyApi.setAccessToken(clientCredentials.getAccessToken());
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
