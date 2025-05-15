import static java.util.Objects.requireNonNull;

import com.spotify.concat.v1.ConcatRequest;
import com.spotify.concat.v1.ConcatResponse;
import com.spotify.concat.v1.ConcatService;
import io.grpc.Context;
import io.grpc.Status;	
import java.util.concurrent.CompletionStage;	
import org.slf4j.Logger;	
import org.slf4j.LoggerFactory;	

public class ConcatServiceImpl implements ConcatService {	
  private static final Logger LOG = LoggerFactory.getLogger(ConcatServiceImpl.class);	

  private final AsyncConcat asyncConcat;	

  public ConcatServiceImpl(final AsyncConcat asyncConcat) {	
    this.asyncConcat = requireNonNull(asyncConcat);	
  }	

  @Override	
  public CompletionStage<ConcatResponse> concat(	
      final Context context, final ConcatRequest request) {	
    return asyncConcat	
        .concat(request, context)	
        .thenApply(result -> ConcatResponse.newBuilder().setResponse(result).build())	
        .exceptionally(	
            throwable -> {	
              LOG.warn("Failed to concat", throwable);	
              throw Status.INTERNAL.asRuntimeException();	
            });	
  }	
}	
