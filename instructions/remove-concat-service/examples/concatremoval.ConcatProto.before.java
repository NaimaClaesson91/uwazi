@@ -1,24 +0,0 @@
syntax = "proto3";

package spotify.concat.v1;

option java_multiple_files = true;
option java_package = "com.spotify.concat.v1";

// A ConcatRequest takes two strings to be concatenated with the option to reverse the result.
message ConcatRequest {
  string string_one = 1;
  string string_two = 2;
  // Optionally reverse the concat response.
  bool reverse = 3;
}

// The response field contains the concatenated string.
message ConcatResponse {
  string response = 1;
}

// ConcatService will concatenate your strings.
service ConcatService {
  rpc Concat(ConcatRequest) returns (ConcatResponse) {}
}