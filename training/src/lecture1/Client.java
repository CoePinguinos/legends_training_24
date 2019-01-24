package lecture1;


public class Client {

	public static void main(String[] args) {
		IGamePlayer player = new GamePlayer("Edward");
		player.login("greatePlayer", "password");
		player.killBoss();
		player.upgrade();
	}

}
