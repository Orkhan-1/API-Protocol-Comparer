package org.tech.with.orkhan.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.tech.with.orkhan.service.BookServiceImpl;

import java.io.IOException;

public class GRPCServer {

    public static void main(String args[]) throws IOException, InterruptedException {

        Server server = ServerBuilder.forPort(9090).addService(new BookServiceImpl()).build();

        server.start();

        System.out.println("Server is running on port: " + server.getPort());

        server.awaitTermination();

    }
}
