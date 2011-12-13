package net.llamaslayers.stev.client;

import java.io.IOException;
import java.net.InetAddress;
import net.llamaslayers.gamelib.buzzwordbingo.router.Router;
import net.llamaslayers.gamelib.networkedlua.LuaUtil;
import net.llamaslayers.gamelib.networking.AbstractClient;
import net.llamaslayers.gamelib.scripting.Lua;
import net.llamaslayers.gamelib.scripting.LuaException;
import net.llamaslayers.stev.shared.LuaClasses;

public class Main {
	public static void main(String[] args) throws IOException, LuaException, InterruptedException {
		AbstractClient client = new AbstractClient(InetAddress.getLocalHost(), 57345) {};
		LuaClasses.register(Lua.GLOBAL_CONTEXT);
		LuaUtil.install(client);
		Router router = new Router(Lua.GLOBAL_CONTEXT, client);
		client.start();
		Lua.GLOBAL_CONTEXT.run("router:addRoute('npctest', function (npc) print(npc:getName()) end)"
				+ "router:send('npctest', 0)");
		client.join();
	}
}
