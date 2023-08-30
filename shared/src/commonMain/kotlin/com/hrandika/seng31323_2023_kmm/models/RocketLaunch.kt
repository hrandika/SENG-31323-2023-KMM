import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RocketLaunch (
    @SerialName("flight_number") val flightNumber: Int,
    @SerialName("name") val name: String,
    @SerialName("date_utc") val dateUTC: String,
    @SerialName("success") val success: Boolean?,
)