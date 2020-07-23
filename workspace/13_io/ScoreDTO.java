import java.io.Serializable;
import java.text.DecimalFormat;

class ScoreDTO implements Comparable<ScoreDTO>, Serializable{
	private String hak;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private double avg;

	public void setHak(String hak) {this.hak = hak;}
	public void setName(String name) {this.name = name;}
	public void setKor(int kor) {this.kor = kor;}
	public void setEng(int eng) {this.eng = eng;}
	public void setMath(int math) {this.math = math;}

	public void calc() {
		tot = kor + eng + math;
		avg = tot/3.0;
	}

	public String getHak() {return hak;}
	public String getName() {return name;}
	public int getKor() {return kor;}
	public int getEng() {return eng;}
	public int getMath() {return math;}
	public int getTot() {return tot;}
	public String getAvg() {return new DecimalFormat("0.###").format(avg);}

	public int compareTo(ScoreDTO dto) {
		return this.tot < dto.tot ? 1 : -1;
	}
}