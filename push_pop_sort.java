import java.util.Scanner;
class push_pop_sort {
	static int exetime = 0;
	public static void sort(int[] data) {
		//stage1
		int n = data.length-1;
		int[] stack = new int[n+1], array = new int[n+1];
		int top = -1, arraylength = -1, dataIndex=0;

		while(true) {
		/*
			//check 
			System.out.print("stack: ");
			for(int i=0 ; i<=top ; i++) {
				System.out.print(stack[i]+" ");
			}
			System.out.println();
			System.out.print("data: ");
			for(int i=0 ; i<=n ; i++) {
				System.out.print(data[i]+" ");
			}
			System.out.println();
			System.out.println();
		*/
			//stage2
			while(top<0 || n>=0 && data[n]<=stack[top]) {
				stack[++top] = data[n--];
				exetime++;
			}
			//if all data push to stack, then finished 
			if(n<0) {
				break;
			}
			//stage3
			while(dataIndex<=n) {	//stack and array not empty
				if(top<0 || data[dataIndex] <= stack[top]) {	//dequeue data to stack
					stack[++top] = data[dataIndex++];
					exetime++;
				}else{		//pop stack to new array
					while(top>=0 && data[dataIndex]>stack[top]) {
						array[++arraylength] = stack[top--];
						exetime++;
					}
				}
			}
			
			//record new array to data
			n = arraylength;
			for(int i=0 ; i<=n ; i++) {
				data[i] = array[i];
			}
			
			arraylength = -1; 		//reset array 
			dataIndex = 0;			//dataIndex point to data[0]
		}
		
		for(int i=0 ; i<=top ; i++) {
			data[i] = stack[top-i];
		}
	}
	
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		System.out.println("please input length of data and their numbers: ");
		int n = input.nextInt();

		int[] data = new int[n];
		for(int i=0 ; i<n ; i++) {
			data[i] = input.nextInt();
		}
		
		sort(data);
		
		System.out.println("sorted data: ");
		for(int i=0 ; i<n; i++) {
			System.out.print(data[i]+" ");
		}
		System.out.println();
		System.out.print("comparison times: " + exetime);
	}
}