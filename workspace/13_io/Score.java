import javax.swing.table.*;

interface Score{
	public void input(ScoreDTO dto);
	public void output(DefaultTableModel model);
	public int search(DefaultTableModel model, String hak);
	public void to_desc();
	public void load();
	public void save();
}