import java.io.*;
import java.util.*;
import javax.swing.*;				//JOptionPane
import javax.swing.table.*;			//DefaultTableModel

class ScoreImpl implements Score{
	private List<ScoreDTO> list = new ArrayList<ScoreDTO>();

	public void input(ScoreDTO dto){
		list.add(dto);
	}
	public void output(DefaultTableModel model){
		model.setRowCount(0);
		for(ScoreDTO dto : list){
			Vector<String> v =  new Vector<String>();
			v.add(dto.getHak());
			v.add(dto.getName());
			v.add(dto.getKor()+"");
			v.add(dto.getEng()+"");
			v.add(dto.getMath()+"");
			v.add(dto.getTot()+"");
			v.add(dto.getAvg());
			model.addRow(v);
		}
	}
	public int search(DefaultTableModel model, String hak){
		model.setRowCount(0);
		int sw=0;
		for(ScoreDTO dto : list){
			if(hak.equals(dto.getHak())){
				Vector<String> v =  new Vector<String>();
				v.add(dto.getHak());
				v.add(dto.getName());
				v.add(dto.getKor()+"");
				v.add(dto.getEng()+"");
				v.add(dto.getMath()+"");
				v.add(dto.getTot()+"");
				v.add(dto.getAvg());
				model.addRow(v);
				sw=1;
			}
		}
		return sw;
	}
	public void to_desc(){
		Collections.sort(list);
	}
	public void save(){
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showSaveDialog(null);
		File file = null;
		if (result == JFileChooser.APPROVE_OPTION) file = chooser.getSelectedFile();
		if(file == null) return;
		try{
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			for(ScoreDTO dto : list) oos.writeObject(dto);
			oos.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public void load(){
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showOpenDialog(null);
		File file = null;
		if (result == JFileChooser.APPROVE_OPTION) file = chooser.getSelectedFile();
		if(file == null) return;
		list.clear();
		try{
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			while(true){
				try{
					ScoreDTO dto = (ScoreDTO)ois.readObject();
					list.add(dto);
				}catch(IOException e){
					break;
				}
			}
			ois.close();
		}catch(IOException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
}