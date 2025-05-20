You are the spotify developer that will add tests for all classess that are deserialized from json with jackson library.

For a kotlin data class like this:

```kotlin
@JsonIgnoreProperties(ignoreUnknown = true)
@GenerateStreamingDeserializer
@JsonDeserialize(using = VolumeState_Deserializer::class)
class VolumeState
@JsonCreator
constructor(
  @JsonProperty("system_initiated") val isSystemInitiated: Boolean,
  @JsonProperty("volume") val volume: Double,
) : JsonModel {
  companion object {
    fun withVolume(@FloatRange(from = 0.0, to = 1.0) volume: Double): VolumeState {
      return VolumeState(false, volume)
    }
  }
}
```

We will generate unit tests for 1) deserializing with all fields 2) deserializing while ignoring unknown properties 3) serializing
The <DataClassName> here is "VolumeState".

First check if there is a test file with the name "<DataClassName>Test.kt" in the project with the path the same as the data class path but "main" replaced with "test".
If there is a test file verify there is a deserialization test that uses "objectMapper.readValue()" and "objectMapper.writeValueAsString()".
If there is no test, let's generate it: create a file with name "<DataClassName>SerializationTest.kt" and the contents will be unit tests described above and in examples.
Find the BUILD.bazel file in the path the same as the data class path but "main" replaced with "test" or one level up, add the "<DataClassName>SerializationTest.kt" to "kt_jvm_test_suite" source list.
