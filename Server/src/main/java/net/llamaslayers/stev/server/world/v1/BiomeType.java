package net.llamaslayers.stev.server.world.v1;

import java.io.Serializable;

public class BiomeType implements Serializable {
	public final Biome a, b;

	public BiomeType(Biome a, Biome b) {
		if (a.ordinal() > b.ordinal()) {
			Biome c = b;
			b = a;
			a = c;
		}
		this.a = a;
		this.b = b;
	}

	public boolean isTransitional() {
		return !a.equals(b);
	}
}
