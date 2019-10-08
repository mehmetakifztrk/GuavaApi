package com.java.guava.guava_api;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.base.Splitter;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class GuavaJoinSplit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GuavaJoinSplit guavaJoinSplit = new GuavaJoinSplit();
		System.out.println(guavaJoinSplit.convertList2String());
		System.out.println(guavaJoinSplit.convertMap2String());
		System.out.println(guavaJoinSplit.ignoreNull());
		System.out.println(guavaJoinSplit.replaceNull());
		System.out.println(guavaJoinSplit.convertString2List());
		System.out.println(guavaJoinSplit.convertString2Map());
		System.out.println(guavaJoinSplit.multiSplit());
		System.out.println(guavaJoinSplit.getFilterData());
		System.out.println(guavaJoinSplit.getCustomerFilterData());
	}
	
	public String convertList2String() {
		List<String>  names = Lists.newArrayList("Ali","Veli","Deli");
		String name = Joiner.on("/").join(names);
		String join = String.join("-", names);
		System.out.println(join);
		return name;
	}
	
	public String convertMap2String() {
		Map<String,Integer> map = Maps.newHashMap();	
		map.put("abc", 10);
		map.put("sdf", 20);
		String result = Joiner.on(",").withKeyValueSeparator("=").join(map);
		return result;
	}
	
	public String ignoreNull() {
		List<String>  names = Lists.newArrayList("aaa","ssss","ddddd",null,null);
		String name = Joiner.on("/").skipNulls().join(names);
		return name;
	}
	
	public String replaceNull() {
		List<String>  names = Lists.newArrayList("aaa","ssss","ddddd",null,null);
		String name = Joiner.on("/").useForNull("No Name").join(names);
		return name;
	}
	
	public List<String> convertString2List() {
		String name = "mehmet-mustafa-kemal";
		List<String> names = Splitter.on("-").trimResults().splitToList(name);
		return  names;
	}
	
	public Map<String, String> convertString2Map(){
		String entry ="abc=10,sdf=20";
		Map<String, String> map = Splitter.on(",").withKeyValueSeparator("=").split(entry);
		return map;
	}
	
	public List<String> multiSplit() {
		String results = "elma,armut..kiraz,,,üzüm,,.,muz";
		List<String> strings = Splitter.onPattern("[,|.]").omitEmptyStrings().splitToList(results);
		return strings;
	}
	
	public Iterable<String> getFilterData(){
		List<String>  names = Lists.newArrayList("Ali","Veli","Deli");
		// case sensitive var
		Iterable<String> iterable = Iterables.filter(names, Predicates.containsPattern("Al"));
		return iterable;
	}
	
	public Collection<String> getCustomerFilterData(){
		Predicate<String> predicate = new Predicate<String>() {
			
			public boolean apply(String input) {
				// TODO Auto-generated method stub
				return input.startsWith("A");
			}
		};
		List<String>  names = Lists.newArrayList("Ali","Veli","Deli");
		Collection<String> collection = Collections2.filter(names, predicate);
		return collection;
	}
	
}
