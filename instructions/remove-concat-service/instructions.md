# Remove ConcatService from package

ConcatService is not used as part of the functionality of a service. It can be safely removed.

Your task is to: 
1. Remove the ConcatService implementation and grpc server configuration from the Main service code 
2. You should remove the Concat.proto file and any references to the ConcatService, ConcatRequest and ConcatResponse 
3. Remove any references to ConcatService from the tests

These files explicitly should be removed: 
* AsyncConcat.java
* AsyncConcatTest.java
* ConcatServiceImpl.java
* ConcatServiceTest.java
* concat.proto

Tips: 
* DO NOT UPDATE ANY FILES THAT ARE NOT IN THE '## Target Files' 
