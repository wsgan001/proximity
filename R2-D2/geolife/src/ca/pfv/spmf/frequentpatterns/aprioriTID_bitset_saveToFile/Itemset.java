package ca.pfv.spmf.frequentpatterns.aprioriTID_bitset_saveToFile;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/**
 * This class represents an itemset (a set of items)
 *
 * Copyright (c) 2008-2012 Philippe Fournier-Viger
 * 
 * This file is part of the SPMF DATA MINING SOFTWARE
 * (http://www.philippe-fournier-viger.com/spmf).
 *
 * SPMF is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * SPMF is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with SPMF.  If not, see <http://www.gnu.org/licenses/>.
 */
public class Itemset{
	private final List<Integer> items = new ArrayList<Integer>(); // ordered
	private BitSet transactionsIds = new BitSet();
	int cardinality =0;
	
	public Itemset(){
	}

	public double getRelativeSupport(int nbObject) {
		return ((double)cardinality) / ((double) nbObject);
	}
	
	public String getSupportRelatifFormatted(int nbObject) {
		double frequence = ((double)cardinality) / ((double) nbObject);
		DecimalFormat format = new DecimalFormat();
		format.setMinimumFractionDigits(0); 
		format.setMaximumFractionDigits(2); 
		return format.format(frequence);
	}
	
	public int getAbsoluteSupport(){
		return transactionsIds.size();
	}

	public void addItem(Integer value){
			items.add(value);
	}

	
	public List<Integer> getItems(){
		return items;
	}
	
	public Integer get(int index){
		return items.get(index);
	}
	
	public void print(){
		System.out.print(toString());
	}
	
	public String toString(){
		StringBuffer r = new StringBuffer ();
		for(Integer attribute : items){
			
			r.append(attribute.toString());
			r.append(' ');
		}
		return r.toString();
	}

	public void setTransactioncount(BitSet listTransactionIds, int cardinality) {
		this.transactionsIds = listTransactionIds;
		this.cardinality = cardinality;
	}
	
//	public void setTransactioncount(BitSet listTransactionIds) {
//		this.transactionsIds = listTransactionIds;
//		this.cardinality = listTransactionIds.size();
//	}

	public int size(){
		return items.size();
	}

	public BitSet getTransactionsIds() {
		return transactionsIds;
	}
}