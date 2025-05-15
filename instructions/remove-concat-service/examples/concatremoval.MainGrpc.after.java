
import com.spotify.apollo.grpc.server.GrpcServer;
import com.spotify.foo.service.FooServiceImpl;

class Main {
  static void configure(final Environment environment) {
    final FooServiceImpl fooService = new FooServiceImpl();

    final GrpcServer grpcServer = environment.resolve(GrpcServer.class);
    grpcServer.addService(FooService.server(fooService));

    try {
      grpcServer.start();
    } catch (final IOException e) {
      throw new RuntimeException("Failed to start service", e);
    }
  }
}
