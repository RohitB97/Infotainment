import java.io.*;
import java.util.*;

class Hash_Map{

	private ArrayList<ArrayList<String>> hash_table = new ArrayList<ArrayList<String>>(1000);

	private Set<Integer> keySet = new HashSet<Integer>();

	public Hash_Map(){
		for(int i=0;i<1000;i++){
			ArrayList<String> temp_list = new ArrayList<String>();
			this.hash_table.add(temp_list);
		}
	} 

	public void put(int key,String value){
		int index = key % 1000;
		this.hash_table.get(index).add(value);
		this.keySet.add(key);
	}

	public String get(int key){
		int index = key % 1000;
		String temp_var = this.hash_table.get(index).remove(0);
		this.hash_table.get(index).add(temp_var);
		return temp_var;
	}

	public boolean containsKey(int key){
		int index = key % 1000;
		if(this.hash_table.get(index).size() != 0)
			return true;
		else
			return false;
	}

	public Set keySet(){
		return (this.keySet);
	}
}

public class Infotainment{

	public static void main(String[] args) throws FileNotFoundException, IOException {
		File file = new File("input.txt");
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		String str,sub_strings[];

		boolean first_line = true;

		int total_time = 0, input_length = 0;
		
		Hash_Map hash_map = new Hash_Map();
		
		while((str = br.readLine()) != null){
			
			if(first_line){
				total_time = Integer.parseInt(str);
				first_line = false;
			}
			
			else{
				sub_strings = str.split(",");
				hash_map.put(Integer.parseInt(sub_strings[1]),sub_strings[0]);
				input_length++;
			}
		}

		for(Object j : hash_map.keySet()){

			int i = (int) j;

			if(input_length == 1)
				System.out.println(hash_map.get(i));

			if(hash_map.containsKey(total_time - i)){

				String movie1 = hash_map.get(i);
				String movie2 = hash_map.get(total_time - i);
				
				if(movie1 != movie2){
					System.out.println(movie1);
					System.out.println(movie2);
					break;
				}
			}
		}

	}
}