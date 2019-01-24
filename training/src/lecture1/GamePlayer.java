package lecture1;
public class GamePlayer implements IGamePlayer {
	private String name;
	private IGamePlayer proxy;

	public GamePlayer(String _name) {
		this.name = _name;
	}

	public IGamePlayer getProxy() {
		this.proxy = new GamePlayerProxy(this);
		return this.proxy;
	}

	public void killBoss() {
		if (this.isProxy()) {
			System.out.println(this.name + " is killing boss!");
			
		} else {
			System.out.println("Please use Proxy to access");
		}
	}

	public void login(String user, String password) {
             if(this.isProxy()){
                     System.out.println(this.name + "has logged successfully via login ID " + user);
             }else{
                     System.out.println("Please use Proxy to access");;
          }
     }

	public void upgrade() {
		if (this.isProxy()) {
			System.out.println(this.name + " has upgraded one level!");
		} else {
			System.out.println("Please use Proxy to access");
		}
	}

	private boolean isProxy() {
		if (this.proxy == null) {
			return false;
		} else {
			return true;
		}
	}
}