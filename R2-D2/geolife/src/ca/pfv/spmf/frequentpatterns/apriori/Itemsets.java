package ca.pfv.spmf.frequentpatterns.apriori;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a set of itemsets. They are ordered by size. For
 * example, level 1 means itemsets of size 1 (that contains 1 item).
 * 
 * Copyright (c) 2008-2012 Philippe Fournier-Viger
 * 
 * This file is part of the SPMF DATA MINING SOFTWARE
 * (http://www.philippe-fournier-viger.com/spmf).
 * 
 * SPMF is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * SPMF is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * SPMF. If not, see <http://www.gnu.org/licenses/>.
 */
public class Itemsets {
	// itemsets ordered by size
	private final List<List<ItemsetApriori>> levels = new ArrayList<List<ItemsetApriori>>(); 
	private int itemsetsCount = 0;
	private final String name;

	public Itemsets(String name) {
		this.name = name;
		levels.add(new ArrayList<ItemsetApriori>()); // We create an empty level
														// 0 by default.
	}

	public void printItemsets(int nbObject) {
		System.out.println(" ------- " + name + " -------");
		int patternCount = 0;
		int levelCount = 0;
		for (List<ItemsetApriori> level : levels) {
			System.out.println("  L" + levelCount + " ");
			for (ItemsetApriori itemset : level) {
				System.out.print("  pattern " + patternCount + ":  ");
				itemset.print();
				System.out.print("support :  "
						+ itemset.getSupportRelatifFormatted(nbObject));
				patternCount++;
				String closed = itemset.isClose() ? "closed" : "";
				System.out.print(" (" + itemset.getAbsoluteSupport() + "/"
						+ nbObject + ") " + closed);
				if (itemset.isPseudoclose()) {
					System.out.print("pseudo-closed, closure: ");
					itemset.getClosure().print();
					System.out.print(" ("
							+ itemset.getClosure().getAbsoluteSupport() + "/"
							+ nbObject + ")");
				}
				System.out.println("");
			}
			levelCount++;
		}
		System.out.println(" --------------------------------");
	}

	public void addItemset(ItemsetApriori itemset, int k) {
		while (levels.size() <= k) {
			levels.add(new ArrayList<ItemsetApriori>());
		}
		levels.get(k).add(itemset);
		itemsetsCount++;
	}

	public List<List<ItemsetApriori>> getLevels() {
		return levels;
	}

	public int getItemsetsCount() {
		return itemsetsCount;
	}

}
