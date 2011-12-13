package net.llamaslayers.stev.server.npc;

import java.awt.Color;
import java.util.Random;
import net.llamaslayers.stev.server.npc.v1.NPCTemplate;
import net.llamaslayers.stev.server.npc.v1.NameGroup;
import net.llamaslayers.stev.server.npc.v1.Species;

public class NPCGenerator {
	private NPCGenerator() {
	}
	private static final Random rand = new Random();

	public static NPCTemplate generate() {
		Species species = Species.values()[rand.nextInt(Species.values().length)];
		NameGroup nameGroup = species.nameGroups[rand.nextInt(species.nameGroups.length)];
		return new NPCTemplate(species, nameGroup.synonyms[rand.nextInt(nameGroup.synonyms.length)] + " " + species.baseNames[rand.nextInt(species.baseNames.length)], rand.nextDouble() / 5 + 0.9, jitter(nameGroup.colorHint));
	}

	private static Color jitter(Color colorHint) {
		return new Color(
				clampColor(colorHint.getRed() + rand.nextInt(64) - rand.nextInt(64)),
				clampColor(colorHint.getGreen() + rand.nextInt(64) - rand.nextInt(64)),
				clampColor(colorHint.getBlue() + rand.nextInt(64) - rand.nextInt(64)));
	}

	private static int clampColor(int raw) {
		return Math.min(Math.max(raw, 0), 255);
	}
}
