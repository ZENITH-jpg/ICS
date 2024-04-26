import java.util.ArrayList;

public class Polynomial{
	
	protected ArrayList<Term> terms;
	
	Polynomial (){
		terms = new ArrayList<Term>();
	}
	
	Polynomial (Term[] t){
		terms = new ArrayList<Term>();
		for (Term a : t){
			terms.add(a);
		}
	}
	
	public int evaluate (int x){
		int total = 0;
		for (int i = 0; i < terms.size(); i++){
			total += terms.get(i).evaluate (x);
		}
		return total;
	}
	
	//put the polynomial in order
	public void sortPoly(){
		int i = 0;
		while (i < terms.size()){
			if (i == 0 || !terms.get(i).isGreater (terms.get(i - 1))){
				i++;
			}
			else{
				swap (i, i -1);
				i--;
			}
		}
	}
	
	private void swap(int i, int j){
		Term temp = terms.get(i);
		terms.set (i, terms.get(j));
		terms.set (j, temp);
	}
	
	public String toString(){
		String s = "";
		
		for (int i = 0; i < terms.size(); i++){
			s += terms.get(i).toString() + " + ";
		}
		
		return s.substring(0, s.length()-3);
	}
	
	public int getOrder(){
		sortPoly();
		return terms.get(0).getExp();
	}
	
	public void addTerm (Term t){
		terms.add(t);
	}

}
