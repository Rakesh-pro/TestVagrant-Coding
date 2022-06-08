
import java.util.*;

public class Main
{
    // 1st question
    static Map<String,int[]> map = new LinkedHashMap<>();
    
    // sum & count of filtered teams from (findConsecutiveNLosses/findConsecutive2Losses)
    static int filteredTeamsPointsSum = 0;
    static int countOfFilteredTeams = 0;
    
    // inserts data into the data structure declared above
    public static void insertData(String teamName,int points,int[] last5Records){
        if(teamName != "" && points >=0){
            int[] arr = new int[6];
            arr[0] = points;
            for(int i=0;i<last5Records.length;i++){
                arr[i+1] = last5Records[i];
            }
            map.put(teamName,arr);return;
        }
        System.out.println("Enter valid Team Name and Points");
    }
    
    // display a leaderboard with all Tema names , Points , their last 5 records 
    // 1 indicates match win / 0 indicates match loss
    public static void display(){
        int count=1;
        for(Map.Entry<String,int[]> entry:map.entrySet()){
            int[] sarr = new int[6];
            sarr = entry.getValue();
            System.out.print((count++)+" "+entry.getKey() +" "+sarr[0]+" ");
            for(int i=1;i<6;i++){
                System.out.print(sarr[i]+" ");
            }
            System.out.println();
        }
    }
    
    
    
    //2nd question
    /*
    we can use findConsecutiveNLosses method 
    for finding the teams who 
    have lossed consectutively 2 times.
    */
    
    public static void findConsecutive2Losses(){
        for(Map.Entry<String,int[]> entry:map.entrySet()){
            String teamName = entry.getKey();
            int[] lr = new int[6];
            lr = entry.getValue();
            int j=1;
            while(j<5){
                if(lr[j] == 0 && lr[j+1]==0){
                    System.out.println(teamName);
                    filteredTeamsPointsSum += lr[0];
                    countOfFilteredTeams++;
                    break;
                }
                j++;
            }
        }
    }
    
    //3rd question
    public static void findConsecutiveNLosses(int n){
        for(Map.Entry<String,int[]> entry:map.entrySet()){
            String teamName = entry.getKey();
            int[] lr = new int[6];
            lr = entry.getValue();
            int j=1;
            int ncount = 1;
            boolean isFound = false;
            while(j<5){
                if(lr[j] == 0 && lr[j+1]==0){
                    ncount++;
                    if(ncount == n){
                        System.out.println(teamName);
                        filteredTeamsPointsSum += lr[0];
                        countOfFilteredTeams++;
                        isFound = true;
                        break;
                    }
                }
                j++;
            }
            if(!isFound && ncount == n){
                System.out.println(teamName);
                filteredTeamsPointsSum += lr[0];
                countOfFilteredTeams++;
            }
        }
    }
    
    
    //4th question getting average of filtered teams points 
    public static void getAverageOfFilteredTeams(){
        System.out.println((double)filteredTeamsPointsSum/countOfFilteredTeams);
    }
    
	public static void main(String[] args) {
	    
	   // Scanner scn = new Scanner(System.in);
	   // // taking 10 entries
	   // for(int t=0;t<3;t++){
	   //     System.out.print("Team Name:- ");
	   //     String teamName = scn.next();
	   //     System.out.println();
	        
	   //     System.out.print("Points:- ");
	   //     int points = scn.nextInt();
	   //     System.out.println();
	        
	   //     System.out.println("Enter last 5 records (1 -> win) (0 -> loss)");
	   //     int[] records = new int[5];
	   //     for(int i=0;i<records.length;i++){
	   //         records[i] = scn.nextInt();
	   //     }
	        
	   //     insertData(teamName,points,records);
	   // }
	   
	   // {points,1st match,2nd match,3rd match,4th match,5th match}
	    int[] team1 = {20,1,1,0,0,1}; // GT
        int[] team2 = {18,1,0,0,1,1}; // LSG
        int[] team3 = {16,1,0,1,0,0}; // RR
        int[] team4 = {20,1,1,0,0,1}; // DC
        int[] team5 = {18,1,0,0,1,1}; // RCB
        int[] team6 = {16,1,0,1,0,0}; // KKR
        int[] team7 = {20,1,1,0,0,1}; // PBKS
        int[] team8 = {18,1,0,0,1,1}; // SRH
        int[] team9 = {16,1,0,1,0,0}; // CSK
        int[] team10 = {20,1,1,0,0,1}; // MI
        map.put("GT",team1);
        map.put("LSG",team2);
        map.put("RR",team3);
        map.put("DC",team4);
        map.put("RCB",team5);
        map.put("KKR",team6);
        map.put("PBKS",team7);
        map.put("SRH",team8);
        map.put("CSK",team9);
        map.put("MI",team10);
        
	    display();
	    System.out.println();
	    findConsecutive2Losses();
	    System.out.println();
	    findConsecutiveNLosses(4); // n = 4
	    getAverageOfFilteredTeams();
	}
}
