class SungJuk {
	private String name;
	private int kor, eng, math, tot;
	private double avg;
	private char grade;

	public void setData(String n, int k, int e, int m){
		name = n;
		kor = k;
		eng = e;
		math = m;
	}
	public String getName(){
		return name;
	}
	public int getKor(){
		return kor;
	}
	public int getEng(){
		return eng;
	}
	public int getMath(){
		return math;
	}


	public void calcTot(){
		tot = kor + eng + math;
	}
	public int getTot(){
		return tot;
	}


	public void calcAvg(){
		avg = tot/3.0;
	}
	public double getAvg(){
		return avg;
	}


	public void calcGrade(){
		if(avg >= 90){
			grade = 'A';
		}else if(avg >= 80){
			grade = 'B';
		}else if(avg >= 70){
			grade = 'C';
		}else if(avg >= 60){
			grade = 'D';
		}else{
			grade = 'F';
		}
	}
	public char getGrade(){
		return grade;
	}
}