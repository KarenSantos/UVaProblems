package solutions;

import java.util.Scanner;

class Problem624 {

	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);
        
        int totalMinutes, totalSongs, totalSubArrays, maxCounter = 0;
        int [] current = null;
        int [] best = null;
        int [] tracks;
        
        while(sc.hasNext()){
            int max = 0;
            totalMinutes = sc.nextInt();
            totalSongs = sc.nextInt();
            totalSubArrays = 1<<totalSongs;        // 2^totalSongs;
            tracks = new int [totalSongs];
           
            for(int i = 0 ; i < totalSongs ; i++){
                tracks[i] = sc.nextInt();
            }
            
            for(int i = 0;i<totalSubArrays;i++){
                int counter = 0;
                int sum = 0;
                current = new int [totalSongs];
                for(int j = 0;j<totalSongs;j++){
                    if(((1<<j)&i)!=0){
                        sum +=  tracks[j];
                        current[counter] = tracks[j];
                        if(sum>totalMinutes)
                            break;
                        counter++;
                    }
                }
                if(sum > max && sum <=totalMinutes){
                    max = sum;
                    maxCounter = counter;
                    best = new int [totalSongs];
                    for(int l = 0 ; l < counter  ; l++){
                        best[l] = current[l];
                    }
                }else if(sum >= max && sum <=totalMinutes && counter>maxCounter){
                    max = sum;
                    maxCounter = counter;
                    for(int l = 0 ; l < counter  ; l++){
                        best[l] = current[l];
                    }
                }
            }
			String result = result(best);
			System.out.println(result);
		}
	}

	private static String result(int[] best){
		String result = "";
		int sum = 0;
		
		for (int i = 0; i < best.length; i++){
			if (best[i]!= 0){
				result += best[i] + " ";
				sum += best[i];
			}
		}
		return result += "sum:" + sum;
	}
}
