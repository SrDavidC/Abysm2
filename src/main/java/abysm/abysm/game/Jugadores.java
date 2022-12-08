package abysm.abysm.game;

import java.util.HashMap;

public class Jugadores {
    HashMap<String,String> jugadores;
    public Jugadores(){
        this.jugadores = new HashMap<>();
        jugadores.put("SRDQRK","No le bast"+'\u00F3'+" con traicionar a SN, sino que ahora tambien tracion" + '\u00F3'+  " a su propio server." +
                " SrDqrk ha fallecido");
        jugadores.put("ZEKTRUM"," Sabia que era furro, pero no tanto");
        jugadores.put("IGAMER"," No le supo al SkyWars");
    }

    public HashMap<String, String> getJugadores() {
        return jugadores;
    }

    public void setJugadores(HashMap<String, String> jugadores) {
        this.jugadores = jugadores;
    }
}
