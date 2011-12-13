package net.llamaslayers.stev.server.item;

import java.util.Random;
import net.llamaslayers.stev.shared.items.*;

public class Alchemy {
	public static int[][] estimate(Item... input) {
		int[] sum = new int[3];
		int[] count = new int[3];
		int overallSum = 0;
		int overallCount = input.length;
		for (Item item : input) {
			int type;
			if (item instanceof Material) {
				type = 0;
			} else if (item instanceof Gear) {
				type = 1;
			} else {
				type = 2;
			}
			sum[type] += item.tier;
			overallSum += item.tier;
			count[type]++;
		}
		int overallAverage = overallSum / overallCount;
		int[] average = {
			(sum[0] + overallAverage) / (count[0] + 1),
			(sum[1] + overallAverage) / (count[1] + 1),
			(sum[2] + overallAverage) / (count[2] + 1)};
		int[] min = new int[3];
		int[] max = new int[3];
		for (int i = 0; i < 3; i++) {
			min[i] = Math.max(average[i] - 2 + count[i] / 3, 1);
			max[i] = Math.max(average[i] + average[i] / 10 + 2 + count[i] / 4, 1);
		}

		return new int[][] {min, max};
	}

	public static Item[] generate(Item... input) {
		int[][] estimates = estimate(input);
		Item[] items = new Item[3];
		Random r = new Random();

		{
			int tier = r.nextInt(estimates[1][0] - estimates[0][0] + 1) + estimates[0][0];
			Item item;
			if (r.nextInt(2) < 1) { // 50% papyrus
				item = new Material(getMaterialName(Material.Type.PAPYRUS, tier), tier, Material.Type.PAPYRUS);
			} else if (r.nextInt(5) < 2) { // 20% metal/leather/wood/cloth
				Material.Type type = r.nextBoolean()
						? (r.nextBoolean() ? Material.Type.CLOTH : Material.Type.LEATHER)
						: (r.nextBoolean() ? Material.Type.WOOD : Material.Type.METAL);
				item = new Material(getMaterialName(type, tier), tier, type);
			} else if (r.nextInt(3) < 2) { // 20% element
				item = new Material(getMaterialName(Material.Type.ELEMENT, tier), tier, Material.Type.ELEMENT);
			} else { // 10% ink
				item = new Material(getMaterialName(Material.Type.INK, tier), tier, Material.Type.INK);
			}
			items[0] = item;
		}

		{
			int tier = r.nextInt(estimates[1][1] - estimates[0][1] + 1) + estimates[0][1];
			Item item = null; // TODO: Gear
			items[1] = item;
		}

		{
			int tier = r.nextInt(estimates[1][2] - estimates[0][2] + 1) + estimates[0][2];
			Item item = null; // TODO: Scrolls
			items[2] = item;
		}

		return items;
	}

	private static String getMaterialName(Material.Type type, int tier) {
		return "Tier " + tier + " " + type.name();
	}
}
