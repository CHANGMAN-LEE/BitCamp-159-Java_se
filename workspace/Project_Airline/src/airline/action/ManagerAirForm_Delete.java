package airline.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import airline.bean.PlaneDTO;
import airline.dao.AirlineDAO;

public class ManagerAirForm_Delete {
	private PlaneDTO planeDTO;
	private AirlineDAO airlineDAO = new AirlineDAO();
	private DefaultTableModel model;
	private List<PlaneDTO> list = new ArrayList<PlaneDTO>();
	
	public ManagerAirForm_Delete(DefaultTableModel model) {
		this.model = model;
		String planecode = JOptionPane.showInputDialog("삭제하실 비행기코드를 입력하세요.");

		// DB
		airlineDAO.plane_delete(planecode);
		
		output(model);
	}
	
	public int output(DefaultTableModel model) {
		this.model = model;
		model.setRowCount(0);
		int sw = 0;
		airlineDAO = new AirlineDAO();
		list = airlineDAO.getplaneList();
		for (PlaneDTO planeDTO : list) {
			Vector<String> v = new Vector<String>();
			v.add(planeDTO.getPlaneCode());
			v.add(planeDTO.getDate());
			v.add(planeDTO.getDeparture());
			v.add(planeDTO.getArrival());
			v.add(planeDTO.getTime1());
			v.add(planeDTO.getTime2());
			v.add(planeDTO.getPrice());
			v.add(planeDTO.getTotalSeat());
			model.addRow(v);
			sw = 1;
		}
		return sw;
	}
}