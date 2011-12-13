package net.llamaslayers.stev.server.npc.v1;

import java.io.Serializable;
import net.llamaslayers.stev.server.Meta;

public class NPCSpawner implements Meta, Serializable {
	private static final long serialVersionUID = 1L;
	public final NPCTemplate template;

	public NPCSpawner(NPCTemplate template) {
		this.template = template;
	}
}
