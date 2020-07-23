import java.text.DecimalFormat;

class SungJukDTO implements Comparable<SungJukDTO>{
	private int no;
	private String name;
	private int kor, eng, math, tot;
	private double avg;
	DecimalFormat df = new DecimalFormat("##.###");


	public SungJukDTO(int no, String name, int kor, int eng, int math){
		this.no = no;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	public void calcTot(){
		tot = kor + eng + math;
	}
	public void calcAvg(){
		avg = tot/3.0;
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
	public int getTot(){
		return tot;
	}	
	public double getAvg(){
		return avg;
	}

	@Override
	public String toString(){
		return no + "\t" + name + "\t" + kor + "\t" + eng + "\t" + math + "\t" + tot + "\t" + df.format(avg);
	}
	@Override
	public int compareTo(SungJukDTO o){
		if(this.tot < o.tot) return 1;
		else if(this.tot == o.tot) return 0;
		else return -1;
	}
}
