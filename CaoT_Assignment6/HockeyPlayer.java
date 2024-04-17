/* Author: Mr. Guglielmi
Date: 25/03/2024
Description: This class implements a simple data type for a hockey player, with
a name, goals, and assists
*/
public class HockeyPlayer{

	private int goals;
	private int assists;
	private String name;
	
	HockeyPlayer (String n, int g, int a){
		this.name = n;
		this.goals = g;
		this.assists = a;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getGoals(){
		return this.goals;
	}
	
	public int getAssists(){
		return this.assists;
	}
	
	public int getPoints(){
		return this.goals + this.assists;
	}
	
	public String toString(){
		String temp = this.name + " Goals: " + this.goals + " Assists: " + this.assists;
		return temp;
	}
}