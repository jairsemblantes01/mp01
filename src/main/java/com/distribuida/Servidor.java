package com.distribuida;

import io.helidon.microprofile.server.Server;

import java.io.IOException;

public class Servidor {
    public static void main(final String[] args) throws IOException {
        Server server = startServer();
        System.out.println("http://localhost:" + server.port());
    }

    static Server startServer() {
        return Server.create().start();
    }
}