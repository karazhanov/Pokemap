package com.omkarmoghe.pokemap.models.map;

import com.pokegoapi.api.map.pokemon.CatchablePokemon;
import com.google.android.gms.maps.model.Marker;

/**
 * Created by socrates on 7/24/2016.
 */
public class PokemonMarkerExtended extends MarkerExtended {

    private CatchablePokemon catchablePokemon;

    public PokemonMarkerExtended(CatchablePokemon catchablePokemon, Marker marker) {
        super(marker);
        this.catchablePokemon = catchablePokemon;
    }

    public CatchablePokemon getCatchablePokemon() {
        return catchablePokemon;
    }

    public void setCatchablePokemon(CatchablePokemon catchablePokemon) {
        this.catchablePokemon = catchablePokemon;
    }
}
