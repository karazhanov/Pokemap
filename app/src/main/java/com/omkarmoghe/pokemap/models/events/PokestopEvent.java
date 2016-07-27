package com.omkarmoghe.pokemap.models.events;

import com.pokegoapi.api.map.fort.Pokestop;
import com.pokegoapi.api.map.pokemon.CatchablePokemon;

import java.util.List;

/**
 * Created by Jon on 7/23/2016.
 */
public class PokestopEvent implements IEvent {

    private List<Pokestop> pokestops;

    public PokestopEvent(List<Pokestop> pokestops) {
        this.pokestops = pokestops;
    }

    public List<Pokestop> getPokestops() {
        return pokestops;
    }

    public void setPokestops(List<Pokestop> pokestops) {
        this.pokestops = pokestops;
    }
}
