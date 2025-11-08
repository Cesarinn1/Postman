package com.example.soaplogin.endpoint;

import com.example.soap_login_service.LoginRequest;
import com.example.soap_login_service.LoginResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class LoginEndpoint {

    private static final String NAMESPACE_URI = "http://www.example.com/soap-login-service";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "LoginRequest")
    @ResponsePayload
    public LoginResponse login(@RequestPayload LoginRequest request) {
        LoginResponse response = new LoginResponse();

        // Simulacion de logica de autenticacion
        String username = request.getUsername();
        String password = request.getPassword();

        // Validacion simple (usuarios de ejemplo)
        if (isValidUser(username, password)) {
            response.setStatus("SUCCESS");
            response.setMessage("Login exitoso. Bienvenido " + username + "!");
        } else {
            response.setStatus("FAILURE");
            response.setMessage("Usuario o contrasena incorrectos");
        }

        return response;
    }

    private boolean isValidUser(String username, String password) {
        // Base de datos simulada de usuarios validos
        return (username.equals("admin") && password.equals("admin123")) ||
               (username.equals("user") && password.equals("user123")) ||
               (username.equals("test") && password.equals("test123"));
    }
}
