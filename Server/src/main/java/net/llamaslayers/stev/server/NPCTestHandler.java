package net.llamaslayers.stev.server;

import java.io.Serializable;
import net.llamaslayers.gamelib.buzzwordbingo.router.PacketRoute;
import net.llamaslayers.gamelib.buzzwordbingo.router.Router;
import net.llamaslayers.stev.server.npc.NPCGenerator;
import net.llamaslayers.stev.server.npc.v1.NPCTemplate;
import net.llamaslayers.stev.shared.NPC;

class NPCTestHandler implements PacketRoute {
	private final Router router;
	NPCTestHandler(Router router) {
		this.router = router;
	}


	@Override
	public void route(Serializable packet) {
		NPCTemplate template = NPCGenerator.generate();
		router.send("npctest", (Serializable) new NPC(null, template.size, template.color, template.name));
	}
}
