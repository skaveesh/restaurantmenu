package net.codegen.restaurantmenu.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by samintha on 3/17/2017.
 */


public class JwtToken {

    private String username;
    private String token;
    private boolean isAuthenticated;

    public JwtToken(String username) { //to create token
        this.username = username;

        createToken();
    }

    public JwtToken(String token, boolean dummy) { //to authenticate from exists token
        this.token = token;

        authenticateUserFromAuthToken();
    }

    public String getToken() {
        return new JSONObject().put("token", token).toString();
    }

    public String getUsername() {
        return username;
    }

    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    private void createToken() {
        //making a new token for authorization this waiter in next time
        Map<String, Object> claimmap = new HashMap<String, Object>();
        claimmap.put("username", (Object) this.username);
        this.token = Jwts.builder()
                .setClaims(claimmap)
                .setIssuer("Login for Restaurant Staff")
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + 7 * 24 * 60 * 60 * 1000)) //set expiration to week
                .signWith(SignatureAlgorithm.HS512, Constance.AUTHORIZATION_PASSWORD)
                .compact();
    }

    private void authenticateUserFromAuthToken() {
        try {
            if (token.startsWith("Bearer "))
                this.token = this.token.substring(7);
            else
                throw new Exception("error token");

            Jws<Claims> claims = Jwts.parser()
                    .requireIssuer("Login for Restaurant Staff")
                    .setSigningKey(Constance.AUTHORIZATION_PASSWORD)
                    .parseClaimsJws(token);

            if (new Date().before(claims.getBody().getExpiration())) {
                this.username = claims.getBody().get("username").toString();
                isAuthenticated = true;
            } else {
                throw new Exception("error token");
            }
        } catch (Exception e) {
            isAuthenticated = false;
        }
    }
}
