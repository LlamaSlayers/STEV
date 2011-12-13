package net.llamaslayers.stev.server.world.v1;

import net.llamaslayers.stev.server.Meta;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Tile implements Serializable {
	private static final long serialVersionUID = 1L;

	public final Biome biome;
	public final String modelName;
	public final Edge leftEdge;
	public final Edge topEdge;
	public final Edge rightEdge;
	public final Edge bottomEdge;
	public final Set<Meta> meta;

	public Tile(Biome biome, String modelName) {
		this.biome = biome;
		this.modelName = modelName;
		leftEdge = topEdge = rightEdge = bottomEdge = Edge.NOT_PASSABLE;
		meta = Collections.emptySet();
	}

	public Tile(Biome biome, String modelName, Edge leftEdge, Edge topEdge, Edge rightEdge, Edge bottomEdge) {
		this.biome = biome;
		this.leftEdge = leftEdge;
		this.topEdge = topEdge;
		this.rightEdge = rightEdge;
		this.bottomEdge = bottomEdge;
		this.modelName = modelName;
		meta = Collections.emptySet();
	}

	public Tile(Biome biome, String modelName, Edge leftEdge, Edge topEdge, Edge rightEdge, Edge bottomEdge, Meta... meta) {
		this.biome = biome;
		this.modelName = modelName;
		this.leftEdge = leftEdge;
		this.topEdge = topEdge;
		this.rightEdge = rightEdge;
		this.bottomEdge = bottomEdge;
		this.meta = Collections.unmodifiableSet(new HashSet<Meta>(Arrays.asList(meta)));
	}
}
