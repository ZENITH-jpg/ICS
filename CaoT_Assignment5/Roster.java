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
	public void sort(int x){
      mergeSort(players,18,x);
   }
	//insert assignment methods below this point
   private void mergeSort (HockeyPlayer[] arr, int n, int method){
      if(n == 1) return;
      int x = n/2;
      HockeyPlayer[] left = new HockeyPlayer[x];
      HockeyPlayer[] right = new HockeyPlayer[n-x];
      for(int i = 0; i < x; i++){
         left[i] = arr[i];
      }
      for(int i = x; i < n; i++){
         right[i-x] = arr[i];
      }
      mergeSort(left, x, method);
      mergeSort(right, n-x, method);
      if(method == 1){
         mergeGoals(arr, right, left, x, n-x);
      }else{
         mergePoints(arr, right, left, x, n-x);
      }
   }
	private void mergeGoals (HockeyPlayer a[], HockeyPlayer r[], HockeyPlayer l[], int left, int right){
		int i = 0, j = 0, k = 0;
		
		while (i < left && j < right){
			if (l[i].getGoals() <= r[j].getGoals()){
				a[k++] = l[i++];
			}
			else {
				a[k++] = r[j++];
			}
		}
		
		while (i < left){
			a[k++] = l[i++];
		}
		
		while (j < right){
			a[k++] = r[j++];
		}
	
	}
   private void mergePoints (HockeyPlayer a[], HockeyPlayer r[], HockeyPlayer l[], int left, int right){
		int i = 0, j = 0, k = 0;
		
		while (i < left && j < right){
			if (l[i].getPoints() <= r[j].getPoints()){
				a[k++] = l[i++];
			}
			else {
				a[k++] = r[j++];
			}
		}
		
		while (i < left){
			a[k++] = l[i++];
		}
		
		while (j < right){
			a[k++] = r[j++];
		}
	
	}
}