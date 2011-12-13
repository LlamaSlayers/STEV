package net.llamaslayers.stev.server;

import java.io.IOException;
import net.llamaslayers.gamelib.buzzwordbingo.router.Router;
import net.llamaslayers.gamelib.networkedlua.LuaUtil;
import net.llamaslayers.gamelib.networking.AbstractServer;
import net.llamaslayers.gamelib.networking.ServerClient;
import net.llamaslayers.gamelib.scripting.Lua;
import net.llamaslayers.stev.shared.LuaClasses;

public class Server extends AbstractServer {
	public Server(int port) throws IOException {
		super(port);
	}

	@Override
	public void handleNewConnection(ServerClient client) {
		Lua lua = new Lua();
		LuaClasses.register(lua);
		LuaUtil.install(lua, client);
		Router router = new Router(lua, client);
		router.addRoute("login", LoginHandler.instance);
		router.addRoute("npctest", new NPCTestHandler(router));
	}
}
