/*
Author: Mr. Guglielmi
Date: 25/03/2024
Description: A class that contains the skating roster for a hockey team
*/

import java.util.Scanner;
import java.io.*;

public class Roster{

	HockeyPlayer players[];
	
	Roster(){									//to simplify for this program:
		players = new HockeyPlayer[18]; //a hockey team will always have 18 skaters on the roster
	}
	
	Roster(String f){
		players = new HockeyPlayer[18];
		loadRoster(f);
	}
	
	//utility method to load players from a file
	private void loadRoster(String filename){
		Scanner s;
		File f;
		try{
			f = new File (filename);
			s = new Scanner(f);
			
			for(int i = 0; i < 18; i++){
				String line = s.nextLine();
				String temp[] = line.split (",");
				//file format: name, goals, assists
				this.players[i] = new HockeyPlayer (temp [0], Integer.parseInt(temp [1]), Integer.parseInt(temp [2])); 
			}
		}
		catch (Exception e){
			System.out.println (e.getMessage());
		}
		
		return;
	}
	
	public void display(){
		//display the roster using the player to string methods
		for (HockeyPlayer i : players){
			System.out.println (i.toString());
		}
		return;
	}
	//insert assignment methods below this point
   public void sort(int x){ // public sorting method, 1 = sort by goal else sort by points
      mergeSort(players,18,x);
   }
   private static void mergeSort (HockeyPlayer[] arr, int n, int method){ // takes in array to sort, length of array, and sort by points or goals
      if(n == 1) return; // if array is size of 1, return the array to be merged
      int x = n/2; // split array in 2
      HockeyPlayer[] left = new HockeyPlayer[x]; // array for left side of split
      HockeyPlayer[] right = new HockeyPlayer[n-x]; // right side
      for(int i = 0; i < x; i++){ // fill arrays
         left[i] = arr[i];
      }
      for(int i = x; i < n; i++){
         right[i-x] = arr[i];
      }
      mergeSort(left, x, method); // break down further
      mergeSort(right, n-x, method);
      merge(arr, right, left, x, n-x, method); // merge

   }
	private static void merge (HockeyPlayer a[], HockeyPlayer r[], HockeyPlayer l[], int left, int right, int method){  //merging method
		int i = 0, j = 0, k = 0;//indexes for right, left, merged arr
		
		while (i < left && j < right){ // while index for right and left are less than their arr size
         boolean b = false;
         if(method == 1){ // compare is left criteria is less than right
            b = l[i].getGoals() <= r[j].getGoals();
         }else if(method == 2){
            b = l[i].getPoints() <= r[j].getPoints();
         }else{
            b = l[i].getAssists() <= r[j].getAssists();
         }
			if (b){ // if left array element at index has less, put in array first
				a[k++] = l[i++];
			}
			else {
				a[k++] = r[j++]; // else right is less so put that in first
			}
		}
		
		while (i < left){ // when one array is completly added into the merged array, add the remaining of the other
			a[k++] = l[i++];
		}
		
		while (j < right){
			a[k++] = r[j++];
		}
	
	}
   //searching methods for finding players in roster
   public int getPlayer(String s){
      for(int i = 0; i < players.length; i++){
         if(players[i].getName().equals(s)){
            return i;
         }
      }
      return -1;
   }
   public int getPlayerByGoals(int x){
      sort(1);
      int l = 0;
      int h = players.length-1;
      while(l<=h){
         int mid = (l+h)/2;
         if(players[mid].getGoals() == x){
            return mid;
         }else if(players[mid].getGoals() > x){
            h = mid-1;
         }else{
            l = mid+1;
         }
      }
      return -1;
   }
   public int getPlayerByAssists(int x){
      sort(3);
      int l = 0;
      int h = players.length-1;
      while(l<=h){
         int mid = (l+h)/2;
         if(players[mid].getAssists() == x){
            return mid;
         }else if(players[mid].getAssists() > x){
            h = mid-1;
         }else{
            l = mid+1;
         }
      }
      return -1;
   }
}