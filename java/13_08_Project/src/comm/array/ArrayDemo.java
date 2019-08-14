package comm.array;

public class ArrayDemo {
	private char arr[];
	
	public ArrayDemo() {
		
	}
	
	public char[] getArr() {
		return arr;
	}

	public void setArr(char[] arr) {
		this.arr = arr;
	}
	
	public void createArray(int length) {
		arr = new char[length];
		for(int i=0; i<arr.length; i++) {
			arr[i]=(char)('A'+i);
		}
	}
	
	public char[] getArray(){
		return arr;
	}

	
}
