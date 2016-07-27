package com.omkarmoghe.pokemap.models.map;

import com.google.android.gms.maps.model.Marker;
import com.pokegoapi.api.map.fort.Pokestop;

/**
 * Created by socrates on 7/24/2016.
 */
public class PokestopMarkerExtended extends MarkerExtended {

    private Pokestop pokestop;

    public PokestopMarkerExtended(Pokestop pokestop, Marker marker) {
        super(marker);
        this.pokestop = pokestop;
    }

    public Pokestop getPokestop() {
        return pokestop;
    }

    public void setPokestop(Pokestop pokestop) {
        this.pokestop = pokestop;
    }
}
