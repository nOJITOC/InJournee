package ru.mmteams91.quest

import androidx.annotation.RequiresPermission
import com.google.android.gms.maps.model.LatLng
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.AutocompletePrediction
import com.google.android.libraries.places.api.model.LocationBias
import com.google.android.libraries.places.api.model.RectangularBounds
import com.google.android.libraries.places.api.net.FetchPhotoRequest
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest
import com.google.android.libraries.places.api.net.FindCurrentPlaceRequest
import com.google.android.libraries.places.api.net.PlacesClient
import com.google.android.libraries.places.widget.Autocomplete
import java.util.jar.Manifest

class QuestRepository : IQuestRepository {

    @RequiresPermission(android.Manifest.permission.ACCESS_FINE_LOCATION)
    fun generateQuest(location: LatLng): Quest? {
        val client: PlacesClient
        return null
    }

}