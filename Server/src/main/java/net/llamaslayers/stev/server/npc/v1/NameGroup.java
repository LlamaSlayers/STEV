package net.llamaslayers.stev.server.npc.v1;

import java.awt.Color;
import java.io.Serializable;

public class NameGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	public final Color colorHint;
	public final String[] synonyms;

	public NameGroup(Color colorHint, String... synonyms) {
		this.colorHint = colorHint;
		this.synonyms = synonyms;
	}

	public static final NameGroup NAMEGROUP_RED = new NameGroup(new Color(255, 0, 0), "Burning", "Flame-Bitten", "Firey", "Angry");
	public static final NameGroup NAMEGROUP_YELLOW = new NameGroup(new Color(255, 255, 0), "Glowing", "Bright", "Aged", "Golden", "Yellowed");
	public static final NameGroup NAMEGROUP_GREEN = new NameGroup(new Color(0, 255, 0), "Slimy", "Acidic", "Acid", "Acrid");
}
