package QuickSort;

public class Quicksort {
	
	public static void main(String[]args){
		
		int[] array = {32, 2, 6, 4, 89, 8, 10, 12, 68, 45};
		
		int leftIndex = 0, rightIndex = array.length - 1;
		
		System.out.println("Before the Sort: ");
		for(int i = 0; i < 10; i++)			
		System.out.print(array[i] + " ");
		System.out.println();
		System.out.println();
		
		quickSort(array, leftIndex, rightIndex);
		
		System.out.println("After the Sort: ");
		for(int i = 0; i < 10; i++)			
		System.out.print(array[i] + " ");
		System.out.println();
		System.out.println();
	}


	public static void quickSort(int[]list, int left, int right){
		
		int pivot, temp;
		int l = left, r = right;
		
		if (left < right){
			
			pivot = list[left];

			while (l < r){
				
				while (list[r] > pivot)
					
					r--;
				
				while (l < r && list[l] <= pivot)
					
					l++;

			    temp = list[l];
				list[l] = list[r];
				list[r] = temp;
				
				System.out.println("the New Sort: ");
				for(int i = 0; i < 10; i++)			
				System.out.print(list[i] + " ");
				System.out.print("//" + temp);
				System.out.println();
				System.out.println();
				
			}
			
				list[left] = list[r];
			    list[r] = pivot;

			    
			    quickSort(list, left, r - 1);
			    quickSort(list, r + 1, right);
		}
	}
}
