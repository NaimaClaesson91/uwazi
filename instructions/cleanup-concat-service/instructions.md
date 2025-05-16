# Remove ConcatService from package

ConcatService is not used as part of the functionality of a service. It can be safely removed.

Your task is to:

1. Remove the ConcatService implementation and grpc server configuration from the Main service code
2. You should remove the Concat.proto file
3. You should remove any references to the ConcatService, ConcatRequest and ConcatResponse including imports like: 'com.spotify.concat.v1.ConcatService', 'com.spotify.concat.v1.ConcatRequest' and 'com.spotify.concat.v1.ConcatResponse'

These files explicitly should be removed:
* AsyncConcat.java
* AsyncConcatTest.java
* ConcatServiceImpl.java
* ConcatServiceTest.java
* concat.proto

Tips:
* DO NOT UPDATE ANY FILES THAT ARE NOT IN THE '## Target Files' SECTION OF THE PLAN
* DO NOT CHANGE THE NAME OF ANY CLASSES INCLUDING TEST CLASSES. For example do not update ContainerIT to ContainerTest