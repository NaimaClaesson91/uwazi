import com.spotify.apollo.Environment;
import com.spotify.apollo.route.Route;
import com.spotify.concat.v1.CallRemoteConcatService;

class Main {
  static void configure(final Environment environment) {
    final AsyncConcat asyncConcat = new AsyncConcat();
    final ConcatServiceImpl service = new ConcatServiceImpl(asyncConcat);
    final FooServiceImpl fooService = new FooServiceImpl();

    final GrpcServer grpcServer = environment.resolve(GrpcServer.class);
    grpcServer.addService(ConcatService.server(service));
    grpcServer.addService(FooService.server(fooService));

    try {
      grpcServer.start();
    } catch (final IOException e) {
      throw new RuntimeException("Failed to start service", e);
    }
  }
}
