package edu.upc.dsa;

import edu.upc.dsa.models.Game;
import edu.upc.dsa.models.Map;
import edu.upc.dsa.models.Object;
import edu.upc.dsa.models.Player;

import java.util.List;

public interface GameInterface {
    public String LogIn  (String usuario_log, String psw_log);
    public String SignUp (int id_sign, String usuario_sign, String psw_sign, double money_sign);  //inicializar listas o pasarlas?
    public Player GetUser (String name_player);
    public Player DeletePlayer (String name_del, String psw_del );
    public Player ChangeName (String name_ch, String psw_ch);
    public Player Log_Out (String name_out);

    public Object BuyObject (String obj_buy);
    public Object AddObject (String obj_add);
    public Object UseObject (String obj_use);
    public List<Object> GetAllObjects ();
    public List<Object> GetUserObjects (String name);

    public Game AddGame (String player, Game partida);
    public Game GetGame (int id_game);
    public List<Game> GetAllGames ();
    public List<Game> GetGamesByUser (String user);

    public Map GetMap (int id_map);

    public List<String> addConectado (String usu_con);


    public void addJugador(Player player);

    public void clear();

}