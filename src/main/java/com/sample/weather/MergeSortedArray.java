
public class MergeSortedArray {

	public static void main(String[] args) {
		int[] inputArr1= {15,30,45,60,75};
		int[] inputArr2= {10,15,20,25,30};
		
		int[] arr=merge(inputArr1,inputArr2);
		
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
		
		
	}

	private static int[] merge(int[] inputArr1, int[] inputArr2) {
		
		int[] result=new int[inputArr1.length+inputArr2.length];
		int k=0;
		int arrIndex1=0;
		int arrIndex2=0;
		
			while(arrIndex1<=inputArr1.length-1 && arrIndex2<=inputArr2.length-1) {
			
			if(inputArr1[arrIndex1]<=inputArr2[arrIndex2]) {
				result[k]=inputArr1[arrIndex1];
				arrIndex1=arrIndex1+1;
			}else {
				result[k]=inputArr2[arrIndex2];
				arrIndex2=arrIndex2+1;
			}
			k=k+1;
			
		}
		if(arrIndex1<=inputArr1.length-1) {
			
			while(arrIndex1<=inputArr1.length-1) {
				result[k]=inputArr1[arrIndex1];
				arrIndex1=arrIndex1+1;
				k=k+1;
			}
		}else if(arrIndex2<=inputArr2.length-1) {
			while(arrIndex2<=inputArr2.length-1) {
				result[k]=inputArr2[arrIndex2];
				arrIndex2=arrIndex2+1;
				k=k+1;
			}
		}
		
		return result;
		
		
		
	}
}
