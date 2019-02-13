import java.util.Arrays;
import java.util.Random;

public class HeapArrayImplementation {

	public static void main(String[] args) {
		Random random = new Random();
		
		int[] arr = new int[11]; //Size taken as 11 (first element is size of heap) remaining 10 are elements of array
		
		
		arr[0]=arr.length-1;
		for (int i=1;i<arr.length;i++)
		{
			arr[i]=random.nextInt(100); //generate random 2 digit numbers
		}
		
		//Initial array traversal
		System.out.print("Initial array                :  ");
		for (int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+"  ");
		}
		System.out.println("\n");
		
		//MIN Heap creation
		arr = makeMinHeap(arr);
		
		//After heap creation traversal
		System.out.print("After heap                   :  ");
		for (int i=0;i<arr.length;i++) 
		{
			System.out.print(arr[i]+"  ");
		}
		System.out.println("\n");
		
		//Insert new element
		arr = Arrays.copyOf(arr, arr.length+1);
		arr[0]++;
		arr[arr[0]]=random.nextInt(100);
		
		//After insertion traversal
		System.out.print("After insert element at end  :  ");
		for (int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+"  ");
		}
		System.out.println("\n");
				
		arr = makeMinHeap(arr); //Restructure MIN Heap
		
		//After insert heap creation traversal
		System.out.print("After insert heap            :  ");
		for (int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+"  ");
		}
		System.out.println("\n");
			
		//Delete element
		arr[1] = arr[arr[0]];
		arr = Arrays.copyOf(arr, arr.length-1);
		arr[0]--;
				
		//After deletion traversal
		System.out.print("After deleting first element :  ");
		for (int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+"  ");
		}
		System.out.println("\n");
						
		arr = makeMinHeap(arr);  //Restructure MIN Heap
				
		//After delete heap creation traversal
		System.out.print("After delete heap            :  ");
		for (int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+"  ");
		}
		System.out.println("\n");
	}

	private static int[] makeMinHeap(int[] arr) {
		int parent_indx = arr[0]/2;
		int min_chld_indx = 0;
		int min_chld2_indx = 0;
		int temp = 0;
		boolean lchildExists = false;
		boolean rchildExists = false;
		boolean valueSwapped = false;
		
		while(parent_indx>0)
		{
			lchildExists = false;
			rchildExists = false;
			valueSwapped = false;
			
			if (arr[0]>= (parent_indx*2))
				lchildExists = true;
			if (arr[0]>= ((parent_indx*2)+1))
				rchildExists = true;
			
			if (lchildExists||rchildExists)
			{
				if (lchildExists&&rchildExists)
					if (arr[(parent_indx*2)+1]<arr[(parent_indx*2)])
						min_chld_indx = (parent_indx*2)+1;
					else
						min_chld_indx = (parent_indx*2);
				else
					min_chld_indx = (parent_indx*2);
				
				if (arr[parent_indx]>arr[min_chld_indx])
					valueSwapped = true;
				
				if (valueSwapped)
				{
					temp = arr[parent_indx];
					arr[parent_indx] = arr[min_chld_indx];
					arr[min_chld_indx] = temp;
					
					while(min_chld_indx<arr[0])
					{
						lchildExists = false;
						rchildExists = false;
						valueSwapped = false;
						
						if (arr[0]>= (min_chld_indx*2))
							lchildExists = true;
						if (arr[0]>= (min_chld_indx*2)+1)
							rchildExists = true;
						
						if (lchildExists||rchildExists)
						{
							if (lchildExists&&rchildExists)
								if (arr[(min_chld_indx*2)+1]<arr[(min_chld_indx*2)])
									min_chld2_indx = (min_chld_indx*2)+1;
								else
									min_chld2_indx = (min_chld_indx*2);
							else
								min_chld2_indx = (min_chld_indx*2);
							
							if (arr[min_chld_indx]>arr[min_chld2_indx])
								valueSwapped = true;
							
							if (valueSwapped)
							{
								temp = arr[min_chld_indx];
								arr[min_chld_indx] = arr[min_chld2_indx];
								arr[min_chld2_indx] = temp;
								min_chld_indx = min_chld2_indx;
							}
							else
								break;
						}
						else
							break;
					}
				}
					
			}
			
			parent_indx--;		
		}
		return arr;
	}

}
