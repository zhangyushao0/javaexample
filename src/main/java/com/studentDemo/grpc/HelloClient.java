package com.studentDemo.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class HelloClient {
    public static void main(String[] args) throws Exception {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        HelloServiceGrpc.HelloServiceBlockingStub stub = HelloServiceGrpc.newBlockingStub(channel);

        HelloResponse response = stub.sayHello(HelloRequest.newBuilder().setName("World").build());

        System.out.println(response.getMessage());

        HelloResponse response2 = stub.sayHelloAgain(HelloRequest.newBuilder().setName("World").build());

        System.out.println(response2.getMessage());
        channel.shutdown();
    }
}
