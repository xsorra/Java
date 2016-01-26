package QuickSort;

public class Quick {

		public static void main(String[] args){
			
			int list[]={32, 2, 6, 4, 89, 8, 10, 12, 68, 45};
			int left = 0, right = list.length - 1;
			
			System.out.println("Before the Sort: ");
			for(int i = 0; i < 10; i++)			
			System.out.print(list[i] + " ");
			System.out.println();
			System.out.println();
			
			quickSort(list, left, right);
			
			System.out.println("After the Sort: ");
			for(int i = 0; i < 10; i++)			
			System.out.print(list[i] + " ");
			System.out.println();
			System.out.println();
		}
	
		public static void quickSort(int[] list, int left, int right){
			
			int l = left;
			int r = right;
			
			if (right - left >= 1){
			
				int pivot = list[left];
				
				while (r > l){
				
					while (list[l] <= pivot && l <= right && r > l){
						
						l++;
					}
					while (list[r] > pivot && r >= left && r >= l){
						
						r--;
					}
					if (r > l)
					
						swap(list, l, r);

				}
				
				swap(list, left, r);
				
				quickSort(list, left, r - 1);
				quickSort(list, r + 1, right);
				
				
			}
			
				else
				
					return;
		}
		
		
		 
		public static void swap(int[] list, int newLeft, int newRight){
			
			int newValue = list[newLeft];
			list[newLeft] = list[newRight];
			list[newRight] = newValue;
			
			System.out.println("Swapping number: " + newValue);
			
			for(int i = 0; i < 10; i++)			
			System.out.print(list[i] + " ");
			System.out.println();
			System.out.println();

		}
	} 

