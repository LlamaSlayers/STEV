package net.llamaslayers.stev.shared;

import net.llamaslayers.gamelib.scripting.Lua;

public class LuaClasses {
	public static void register(Lua lua) {
		lua.exposer.exposeClass(NPC.class);
	}
}
