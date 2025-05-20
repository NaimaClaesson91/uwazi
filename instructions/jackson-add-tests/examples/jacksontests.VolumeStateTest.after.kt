import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class VolumeStateTest {

  private lateinit var objectMapper: ObjectMapper

  @Before
  fun setUp() {
    objectMapper = ObjectMapper()
  }

  @Test
  fun `test deserialize with all fields`() {
    // language=JSON
    val json =
      """
            {
                "system_initiated": true,
                "volume": 0.75
            }
        """
        .trimIndent()

    val volumeState = objectMapper.readValue(json, VolumeState::class.java)

    assertTrue(volumeState.isSystemInitiated)
    assertEquals(0.75, volumeState.volume, 0.0)
  }

  @Test
  fun `test deserialize ignores unknown properties`() {
    // language=JSON
    val json =
      """
            {
                "system_initiated": true,
                "volume": 0.75,
                "unknown_field": "value"
            }
      """
        .trimIndent()

    val volumeState = objectMapper.readValue(json, VolumeState::class.java)

    assertFalse(volumeState.isSystemInitiated)
    assertEquals(0.75, volumeState.volume, 0.0)
  }

  @Test
  fun `test serialize`() {
    val volumeState = VolumeState(isSystemInitiated = true, volume = 0.75)
    val json = objectMapper.writeValueAsString(volumeState)

    assertTrue(json.contains("\"volume\":0.75"))
    assertTrue(json.contains("\"systemInitiated\":true"))
  }
}

