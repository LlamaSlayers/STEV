package net.llamaslayers.stev.shared;

import java.awt.Color;
import java.io.Serializable;
import se.krka.kahlua.integration.annotations.LuaClass;
import se.krka.kahlua.integration.annotations.LuaMethod;

@LuaClass
public class NPC implements Serializable {
	private static final long serialVersionUID = 1L;
	public final String modelName;
	public final double size;
	public final Color color;
	public final String name;

	public NPC(String modelName, double size, Color color, String name) {
		this.modelName = modelName;
		this.size = size;
		this.color = color;
		this.name = name;
	}

	@LuaMethod
	public String getName() {
		return name;
	}
}
