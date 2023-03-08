package datastruct;

public class ListManipulator {

	public static void main(String[] args) {
		UnsortedList<Integer> list = MyUnsortedList.of();

		list.append(6);
		list.append(5);
		list.append(4);
		list.append(3);
		
		System.out.println("Created a list of size " + list.size());
	}

}
