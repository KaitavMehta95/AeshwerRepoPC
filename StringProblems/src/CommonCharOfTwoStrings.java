import java.util.HashSet;

/*Print common characters of two Strings in alphabetical order
 * http://www.geeksforgeeks.org/print-common-characters-two-strings-alphabetical-order-2/
 */
public class CommonCharOfTwoStrings {
	
	void commonChar(String str1,String str2){
		
		int[] freq1 = new int[26];
		int[] freq2 = new int[26];
		
		int length1 = str1.length();
        int length2 = str2.length();
 
        for (int i = 0 ; i < length1 ; i++)
           freq1[str1.charAt(i) - 'a'] += 1;
 
        for (int i = 0 ; i < length2 ; i++)
           freq2[str2.charAt(i) - 'a'] += 1;
        
        // If a common index is non-zero, it means that the letter corresponding to that index is common to both strings
        for (int i = 0 ; i < 26 ; i++)
        {
            if (freq1[i] != 0 && freq2[i] != 0)
            {
                // Find the minimum of the occurence of the character in both strings and print the letter that many number of times
                for (int j = 0 ; j < Math.min(freq1[i], freq2[i]) ; j++)
                    System.out.print(((char)(i + 'a')));
            }
        }
		
		
	}

	public static void main(String[] args) {
		 String str1 = "geeks";
		 String str2 = "forgeeks";
		 CommonCharOfTwoStrings test = new CommonCharOfTwoStrings();
	     test.commonChar(str1,str2);
	}
	
}
