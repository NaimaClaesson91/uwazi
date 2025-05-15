import static java.util.concurrent.CompletableFuture.completedFuture;

import com.spotify.concat.v1.ConcatRequest;
import io.grpc.Context;
import java.util.concurrent.CompletionStage;

public class AsyncConcat {

  public CompletionStage<String> concat(final ConcatRequest request, final Context context) {
    return completedFuture(request).thenApply(this::doConcat);
  }

  private String doConcat(final ConcatRequest request) {
    return request.getReverse()
        ? (request.getStringTwo() + request.getStringOne())
        : (request.getStringOne() + request.getStringTwo());
  }
}