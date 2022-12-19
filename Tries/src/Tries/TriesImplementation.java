package Tries;


class Node{
	
	Node[] links=new Node[26];
	boolean flag;
	
	Node() {
	}

	public boolean containsKey(char ch) {
		return links[ch-'a']!=null;
	}

	public void put(char ch, Node node) {
		links[ch-'a']=node;
	}

	public Node get(char ch) {
		return links[ch-'a'];
	}

	public void setEnd() {
		flag=true;
		
	}

	public boolean isEnd() {
		return flag;
	}
	
	
}

public class TriesImplementation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str="kunal";
		String str1="madne";
		String str2="kunalmadne";
		
		//Trie trie= new Trie();
		
		Trie.insert(str1);
		Trie.insert(str2);
		Trie.insert(str);
		
		
		System.out.println(Trie.search("kun")+" "+
		Trie.search("madne")+" "+
		Trie.search("arvind")+" "+
		Trie.search("kunalmadne"));
		
		System.out.println(Trie.startsWith("kun"));
		
	}

}


class Trie{
	
	private static Node root=new Node();;
	Trie(){
		
		
	}
	
	public static void insert(String str) {
		
		Node node =root;
		for(int i=0; i<str.length(); i++) {
			if(!node.containsKey(str.charAt(i))) {
				node.put(str.charAt(i),new Node());
			}
			node=node.get(str.charAt(i));
		}
		node.setEnd();
	}
	
	public static boolean search(String str) {
		
		Node node =root;
		for(int i=0; i<str.length(); i++) {
			if(!node.containsKey(str.charAt(i))) {
				return false;
			}
			node=node.get(str.charAt(i));
			
		}
		return node.isEnd();
	}
	
	public static boolean startsWith(String str) {
		
		Node node =root;
		for(int i=0; i<str.length(); i++) {
			if(!node.containsKey(str.charAt(i))) {
				return false;
			}
			node=node.get(str.charAt(i));
			
		}
		return true;
	}
	
}


















