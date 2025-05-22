# Remove any references to HoG in the config file

Hermes Over gRPC aka HOG - is completely deprecated and needs to be removed and cleaned up from all services.
Therefore all references to HOG should be removed from any services config file. No other changes should be made to the config file.
The references might differ but they should be similar to the ones below and the references might be commented out or not:

"// Hermes Over gRPC (HOG) IS DEPRECATED"
"// hog.enabled: "discouraged""
"// hog.enabled: false"
"// hog.enabled: true"
"hog.enabled: "true""
"# This enables hermes over grpc on client side."
"# https://backstage.spotify.net/docs/grpc/hermes-over-grpc/#enabling-calling-other-services-using-hog"


Your task is to:

1. Remove all references to HOG in the config file.
2. Make sure that the config file is still valid and does not contain any syntax errors.
3. Do not make any other changes to the config file.

You should not give me a plan for this task, instead you should update the config file.
