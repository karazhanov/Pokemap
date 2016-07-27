package com.omkarmoghe.pokemap;

import android.os.Environment;

import com.pokegoapi.api.map.pokemon.CatchablePokemon;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by karazhanov on 27.07.16.
 */
public class Utils {

    private static final String FORMAT = "SpawnPointId: %20s | %20.15d | %20.15d | %20s";

    public static String convert(List<CatchablePokemon> pokeList) {
        StringBuilder sb = new StringBuilder();
        for (CatchablePokemon catchablePokemon : pokeList) {
            sb.append(convert(catchablePokemon)).append("\n");
        }
        return sb.toString();
    }

    public static String convert(CatchablePokemon poke) {
        return String.format(FORMAT, poke.getSpawnPointId(), poke.getLatitude(), poke.getLongitude(), poke.getPokemonId());
    }

    public static void saveToFile(List<CatchablePokemon> pokeList) {
        String filename = "pokemonlist.txt";
        File file = new File(Environment.getExternalStorageDirectory(), filename);
        FileOutputStream fos;
        byte[] data = convert(pokeList).getBytes();
        try {
            fos = new FileOutputStream(file);
            fos.write(data);
            fos.flush();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
