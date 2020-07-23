import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class DrCanvas extends Canvas{
	private MsPaint msPaint;
	private ShapeDTO dto;
	private Image bufferImg;
	private Graphics bufferG;

	public DrCanvas(MsPaint msPaint){
		this.msPaint = msPaint;
		setBackground(new Color(200, 191, 231));
	}

	public void update(Graphics g){
		int x1,x2,y1,y2,z1,z2;
		//사각영역
		Dimension d = this.getSize();
		if(bufferG == null){
			bufferImg = this.createImage(d.width, d.height); //이미지 객체 생성
			bufferG = bufferImg.getGraphics();
		}

		bufferG.setColor(this.getBackground());
		bufferG.fillRect(0,0,d.width, d.height);

		for(ShapeDTO dto : msPaint.getList()){
			x1 = dto.getX1(); y1 = dto.getY1(); z1 = dto.getZ1();
			x2 = dto.getX2(); y2 = dto.getY2(); z2 = dto.getZ2();

			switch(dto.getCombo()){
				case 0: bufferG.setColor(new Color (255,0,0));
					break;
				case 1: bufferG.setColor(new Color (0,255,0));
					break;
				case 2: bufferG.setColor(new Color (0,0,255));
					break;
				case 3: bufferG.setColor(new Color (200,0,255));
					break;
				case 4: bufferG.setColor(new Color (0,255,255));
					break;
			}

			int xs = x1 < x2 ? x1 : x2;			//x1가 x2보다 작으면 x1, 크면 x2
			int ys = y1 < y2 ? y1 : y2;
			int widths = x1 < x2 ? x2-x1 : x1-x2;
			int heights = y1 < y2 ? y2-y1 : y1-y2;
			if(dto.getFill()){
				if(dto.getShape() == Figure.LINE) bufferG.drawLine(x1, y1, x2, y2);
				else if(dto.getShape() == Figure.CIRCLE) bufferG.fillOval(xs, ys, widths, heights);
				else if(dto.getShape() == Figure.RECT) bufferG.fillRect(xs, ys, widths, heights);
				else if(dto.getShape() == Figure.ROUNDRECT) bufferG.fillRoundRect(xs, ys, widths, heights, z1, z2);
				else if(dto.getShape() == Figure.PEN) bufferG.drawLine(x1, y1, x2, y2);
			}else{
				if(dto.getShape() == Figure.LINE) bufferG.drawLine(x1, y1, x2, y2);
				else if(dto.getShape() == Figure.CIRCLE) bufferG.drawOval(xs, ys, widths, heights);
				else if(dto.getShape() == Figure.RECT) bufferG.drawRect(xs, ys, widths, heights);
				else if(dto.getShape() == Figure.ROUNDRECT) bufferG.drawRoundRect(xs, ys, widths, heights, z1, z2);
				else if(dto.getShape() == Figure.PEN) bufferG.drawLine(x1, y1, x2, y2);
			}
		}//for dto
		//--------------------------------------------------------------------------------------------------------
		//좌표 얻기
		x1 = Integer.parseInt(msPaint.getX1T().getText().trim());
		y1 = Integer.parseInt(msPaint.getY1T().getText().trim());
		x2 = Integer.parseInt(msPaint.getX2T().getText().trim());
		y2 = Integer.parseInt(msPaint.getY2T().getText().trim());
		z1 = Integer.parseInt(msPaint.getZ1T().getText().trim());
		z2 = Integer.parseInt(msPaint.getZ2T().getText().trim());

		//색 얻기
		switch(msPaint.getCombo().getSelectedIndex()){
			case 0: bufferG.setColor(new Color (255,0,0));
				break;
			case 1: bufferG.setColor(new Color (0,255,0));
				break;
			case 2: bufferG.setColor(new Color (0,0,255));
				break;
			case 3: bufferG.setColor(new Color (200,0,255));
				break;
			case 4: bufferG.setColor(new Color (0,255,255));
				break;
		}

		//그리기
		int x = x1 < x2 ? x1 : x2;			//x1가 x2보다 작으면 x1, 크면 x2
		int y = y1 < y2 ? y1 : y2;
		int width = x1 < x2 ? x2-x1 : x1-x2;
		int height = y1 < y2 ? y2-y1 : y1-y2;
		if(msPaint.getFill().isSelected()){
			if(msPaint.getLine().isSelected()) bufferG.drawLine(x, y1, x2, y2);
			else if(msPaint.getCircle().isSelected()) bufferG.fillOval(x, y, width, height);
			else if(msPaint.getrRect().isSelected()) bufferG.fillRect(x, y, width, height);
			else if(msPaint.getRoundRect().isSelected()) bufferG.fillRoundRect(x, y, width, height, z1, z2);
			//else if(msPaint.getPen().isSelected()) g.drawLine(x1, y1, x2, y2);
		}else{
			if(msPaint.getLine().isSelected()) bufferG.drawLine(x1, y1, x2, y2);
			else if(msPaint.getCircle().isSelected()) bufferG.drawOval(x, y, width, height);
			else if(msPaint.getrRect().isSelected()) bufferG.drawRect(x, y, width, height);
			else if(msPaint.getRoundRect().isSelected()) bufferG.drawRoundRect(x, y, width, height, z1, z2);
			//else if(msPaint.getPen().isSelected()) g.drawLine(x1, y1, x2, y2);
		}
		
		paint(g);
	}//update()

	public void paint(Graphics g){
		g.drawImage(bufferImg, 0, 0, this);
	}//paint()
}