package net.llamaslayers.stev.server;

import java.io.Serializable;
import net.llamaslayers.gamelib.buzzwordbingo.router.PacketRoute;

class LoginHandler implements PacketRoute {
	@Override
	public void route(Serializable packet) {
		// TODO
	}

	static final LoginHandler instance = new LoginHandler();
}
