/**
 * Software and Programming II - Coursework One
 * Student - Gerard Mason(gmason02)
 */


import java.util.Scanner;
public class TwoArrays {

	public static void main(String[] args) {
		final int maxInts=100; //Create constant to limit each array to 100 elements
		int[] arrayOne = new int[maxInts];
		int[] arrayTwo = new int[maxInts];
		int countNum=0;
		int countNumTwo=0;
		Scanner input = new Scanner(System.in); 
		
		//Recieve input from the user and populate the first array
		for(int i=0;i<maxInts;i++){
			System.out.println("Please enter the numbers for the first array(enter 0 to finish): ");
			arrayOne[i]=input.nextInt();
			countNum++;
			//If 0 is entered by the user keyboard input moves to the next array input below
			if(arrayOne[i]==0){
				break;
			}
			
		}
		
		//Input from user to populate second array
		for(int i=0;i<maxInts;i++){
			System.out.println("Please enter the numbers for the second array(enter 0 to finish): ");
			arrayTwo[i]=input.nextInt();
			countNumTwo++;
			if(arrayTwo[i]==0){
				break;
			}
		}
		
		//Call to method to remove duplicates from the first array
		duplicates(arrayOne);
		
		duplicates(arrayTwo);
		
		
		
		/*
		 * If the user inputs 0 for each array the following if statement will ensure that the user receives a message that
		 * the arrays are empty 
		 */
		if(countNum==1&&countNumTwo==1){
			System.out.println("Both arrays are empty.");
		}
		
		System.out.print("The elements of the first array are: ");
		
		for(int i=0; i<countNum;i++){
			if(arrayOne[i]!=0){
			System.out.print(" "+arrayOne[i]);
			}
		}
	
		
		
		System.out.println();
		
		System.out.print("The elements of the second array are: ");
	   
		for(int i=0; i<countNumTwo;i++){
			if(arrayTwo[i]!=0){
			System.out.print(" "+arrayTwo[i]);
			}
		}
		System.out.println();
		
		//Call the intersect method
		intersect(arrayOne, arrayTwo);
		
		/*
		 * would have been used to access union method - see notes below
		 * 
		 * union(arrayOne, arrayTwo);
		 */
		
	}
	
		
	
/*
 * The following method is used to remove duplicates from each array.
 * Arrays are run through the method one at a time. 
 */

	public static int[] duplicates(int[] a) {
		
		
	    int b = a.length;
	    for (int i = 0; i < b; i++) {
	        for (int j = i + 1; j < b; j++) {
	            if (a[i] == a[j]) {                  
	                //int c creates a marker/counter that allows the method to check the array from left to right
	                int c = j;
	                for (int k = j+1; k < b; k++, c++) {
	                    a[c] = a[k];
	                }
	                b--;
	                j--;
	            }
	        }
	    }
	    //New array with the duplicates removed is created an returned
	    int[] dupRemoved = new int[b];
	    for(int i = 0; i < b; i++){
	        dupRemoved[i] = a[i];
	    }
	    return dupRemoved;
	}

	public static void intersect(int[] a, int[] b) {
		System.out.print("The following elements appear in both arrays:");
		int count = 0;
		for(int i=0; i<a.length; i++) {
	        for(int j=0; j<b.length; j++) {
	            //Without the addition of &&a[i]!=0 the method printed out all 100 elements even though they are 0.
	        	if(a[i] == b[j]&&a[i]!=0) {
	            	System.out.print(" "+a[i]);
	                count++;
	                break;
	            }
	            
	        }
	     }
		System.out.println();
		System.out.println("The number of common elements is "+count);
	}
	
	/*
	 *The below code was intended to help to print the unique element values from each array.
	 *However I did not have time to complete this.
	 *The idea was to create a union of arrayOne and arrayTwo, remove the duplicates and then compare each array to a new array
	 *and work out the unique values from there.
	 * 
	 public static void union(int[] a, int[] b){
		duplicates(a);
		duplicates(b);
		int unique[] = new int[a.length+b.length];
		int counter = 0;
		for(int i = 0; i < a.length; i++){
			unique[i] = a[i];
			counter++;
		}
		for(int j = 0; j < b.length; j++){
			unique[counter] = b[j];
			counter++;
		}
		duplicates(unique);
		System.out.print("Union:");
		for(int k=0; k<unique.length; k++){
			if(unique[k]!=0){
		System.out.print(" "+unique[k]);
			}
		}
		System.out.println();
	
		
		int test[] =new int[unique.length];
		    for(int l=0; l<a.length; l++) {
		        for(int j=0; j<b.length; j++) {
		            if(a[l] == b[j]) {
		                test[l]=a[l];
		                break;
		            }
		        }
		    }
		    
		    for(int i=0; i<unique.length; i++) {
		            for(int j=0; j<test.length; j++) {
		                if(test[i] == unique[j]) {
		                    System.out.println(test[i]+ "is unique to array one.");
		                    break;
		                }
		            }
		        }
		    }*/
		
		
	}
		
	
	

	
	





