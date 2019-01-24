package lecture1;
public class GamePlayerProxy implements IGamePlayer {
     private IGamePlayer gamePlayer;
     public GamePlayerProxy(IGamePlayer _gamePlayer){
             this.gamePlayer = _gamePlayer;
     }
     public void killBoss() {
             this.gamePlayer.killBoss();
     }
     public void login(String user, String password) {
             this.gamePlayer.login(user, password);
     }
     public void upgrade() {
             this.gamePlayer.upgrade();
     }
     public IGamePlayer getProxy(){
             return this;
     }
}