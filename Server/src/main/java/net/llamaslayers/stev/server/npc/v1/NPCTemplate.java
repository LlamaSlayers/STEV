package net.llamaslayers.stev.server.npc.v1;

import java.awt.Color;
import java.io.Serializable;

public class NPCTemplate implements Serializable {
	private static final long serialVersionUID = 1L;

	public final Species species;
	public final String name;
	public final double size;
	public final Color color;

	public NPCTemplate(Species species, String name, double size, Color color) {
		this.species = species;
		this.name = name;
		this.size = size;
		this.color = color;
	}
}
