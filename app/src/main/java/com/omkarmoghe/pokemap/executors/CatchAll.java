package com.omkarmoghe.pokemap.executors;

import android.os.AsyncTask;
import android.util.Log;

import com.omkarmoghe.pokemap.controllers.net.NianticManager;
import com.omkarmoghe.pokemap.views.map.MapWrapperFragment;
import com.pokegoapi.api.map.pokemon.CatchResult;
import com.pokegoapi.api.map.pokemon.CatchablePokemon;
import com.pokegoapi.api.map.pokemon.EncounterResult;

import java.util.ArrayList;
import java.util.List;

import POGOProtos.Networking.Responses.CatchPokemonResponseOuterClass;

/**
 * Created by karazhanov on 27.07.16.
 */
public class CatchAll extends AsyncTask<Void, CatchAll.Progress, Void> {

    public static class Progress {
        CatchablePokemon catchablePokemon;
        String log;

        public Progress(CatchablePokemon cp, String s) {
            catchablePokemon = cp;
            log = s;
        }
    }

    private NianticManager nianticManager;
    private MapWrapperFragment mapWrapperFragment;
    private int cathing = 0;
    private int notCathing = 0;
//    private List<CatchablePokemon> forRemove = new ArrayList<>();

    public CatchAll(NianticManager nianticManager, MapWrapperFragment mapWrapperFragment) {
        this.nianticManager = nianticManager;
        this.mapWrapperFragment = mapWrapperFragment;
    }

    @Override
    protected void onPreExecute() {
        mapWrapperFragment.log("Start catching " + mapWrapperFragment.getPokemons().size() + " pokemons");
    }

    @Override
    protected Void doInBackground(Void... voids) {
        List<CatchablePokemon> pokemons = mapWrapperFragment.getPokemons();
        for (CatchablePokemon cp : pokemons) {
            try {
                nianticManager.setLocation(cp.getLatitude(), cp.getLongitude(), 0D);
                EncounterResult encResult = cp.encounterPokemon();
                String s;
                if (encResult.wasSuccessful()) {
                    CatchResult result = cp.catchPokemonWithRazzBerry();
                    s = "Attempt to catch:" + cp.getPokemonId()+" "+result.getStatus();
                    if(CatchPokemonResponseOuterClass.CatchPokemonResponse.CatchStatus.CATCH_SUCCESS == result.getStatus()){
                        cathing++;
                    } else {
                        notCathing++;
                    }
//                    forRemove.add(cp);
                } else {
                    s = "Can't to catch:" + cp.getPokemonId()+ " " + encResult.getStatus();
                    notCathing++;
                }
                publishProgress(new Progress(cp, s));
//                Thread.sleep(500);
            } catch (Exception ignored){
                ignored.printStackTrace();
            }
        }
        pokemons.clear();
        return null;
    }

    @Override
    protected void onProgressUpdate(Progress... values) {
        Progress p = values[0];
        mapWrapperFragment.removePokeMarker(p.catchablePokemon);
        mapWrapperFragment.log(p.log);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        mapWrapperFragment.log("End catching. Catch " + cathing + ", runned away " + notCathing);
    }
}
