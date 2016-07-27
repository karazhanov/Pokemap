package com.omkarmoghe.pokemap.models.map;

import com.google.android.gms.maps.model.Marker;
import com.pokegoapi.api.map.pokemon.CatchablePokemon;

/**
 * Created by socrates on 7/24/2016.
 */
public class MarkerExtended {

    private Marker marker;

    public MarkerExtended(Marker marker) {
        this.marker = marker;
    }

    public Marker getMarker() {
        return marker;
    }

    public void setMarker(Marker marker) {
        this.marker = marker;
    }
}
