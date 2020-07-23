package airline.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import airline.bean.BookDTO;
import airline.bean.MemberDTO;
import airline.bean.PaymentDTO;
import airline.bean.PlaneDTO;

public class AirlineDAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@192.168.0.143:1521:xe";
	private String username = "c##project";
	private String password = "1234";
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public AirlineDAO() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//member=========================================================================================
	public int getSeq() {
		int seq = 0;
		getConnection();
		String sql = "SELECT seq_member.NEXTVAL from dual";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			seq = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} // try,catch
		} // try,catch,finally
		return seq;
	}// getSeq()

	public int member_insert(MemberDTO memberDTO) {
		int count = 0;
		getConnection();
		String sql = "insert into member values(?,?,?,?,?,?,?,?,?,?,?)";
		System.out.println(memberDTO.getSeq());
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberDTO.getSeq());
			pstmt.setString(2, memberDTO.getId());
			pstmt.setString(3, memberDTO.getPw());
			pstmt.setString(4, memberDTO.getPw());
			pstmt.setString(5, memberDTO.getName());
			pstmt.setString(6, memberDTO.getPhone());
			pstmt.setString(7, memberDTO.getMail());
			pstmt.setString(8, memberDTO.getAddress());
			pstmt.setString(9, memberDTO.getQuestion());
			pstmt.setString(10, memberDTO.getAnswer());
			pstmt.setInt(11, memberDTO.getCode());

			int su = pstmt.executeUpdate();
			// System.out.println(su + "개의 행이 만들어졌습니다");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}

	public int member_update(MemberDTO memberDTO) {
		int count = 0;
		getConnection();
		String sql = "update member set id=?, pw=? , pw2 =? , name=?, phone=?, mail=?, address=?, question=?, answer=?, code=? where seq = ? ";
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, memberDTO.getId());
			pstmt.setString(2, memberDTO.getPw());
			pstmt.setString(3, memberDTO.getPw2());
			pstmt.setString(4, memberDTO.getName());
			pstmt.setString(5, memberDTO.getPhone());
			pstmt.setString(6, memberDTO.getMail());
			pstmt.setString(7, memberDTO.getAddress());
			pstmt.setString(8, memberDTO.getQuestion());
			pstmt.setString(9, memberDTO.getAnswer());
			pstmt.setInt(10, memberDTO.getCode());
			pstmt.setInt(11, memberDTO.getSeq());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return count;
	}
	
	public int member_delete(String id) {
		int count = 0;
		getConnection();
		String sql = "delete member where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} // try,catch
		} // try,catch,finally
		return count;
	}

	public List<MemberDTO> getmemberList() {
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		getConnection();
		String sql = "select * from member order by name asc";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MemberDTO memberDTO = new MemberDTO();
				memberDTO.setSeq(rs.getInt("seq"));
				memberDTO.setId(rs.getString("id"));
				memberDTO.setPw(rs.getString("pw"));
				memberDTO.setPw2(rs.getString("pw2"));
				memberDTO.setName(rs.getString("name"));
				memberDTO.setPhone(rs.getString("phone"));
				memberDTO.setMail(rs.getString("mail"));
				memberDTO.setAddress(rs.getString("address"));
				memberDTO.setQuestion(rs.getString("question"));
				memberDTO.setAnswer(rs.getString("answer"));
				memberDTO.setCode(rs.getInt("code"));
				list.add(memberDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			list = null;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} // try,catch
		} // try,catch,finally
		return list;
	}
	
	//plane=========================================================================================
	public int getSeq2() {
		int seq2 = 0;
		getConnection();
		String sql = "SELECT seq_plane.NEXTVAL from dual";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			seq2 = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} // try,catch
		} // try,catch,finally
		return seq2;
	}// getSeq()

	public int plane_insert(PlaneDTO planeDTO) {
		int count = 0;
		getConnection();
		String sql = "insert into plane values(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, planeDTO.getSeq2());
			pstmt.setString(2, planeDTO.getPlaneCode());
			pstmt.setString(3, planeDTO.getDate());
			pstmt.setString(4, planeDTO.getDeparture());
			pstmt.setString(5, planeDTO.getArrival());
			pstmt.setString(6, planeDTO.getDepartureEng());
			pstmt.setString(7, planeDTO.getArrivalEng());
			pstmt.setString(8, planeDTO.getTime1());
			pstmt.setString(9, planeDTO.getTime2());
			pstmt.setString(10, planeDTO.getPrice());
			pstmt.setString(11, planeDTO.getTotalSeat());

			int su = pstmt.executeUpdate();
			// System.out.println(su + "개의 행이 만들어졌습니다");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}

	public int plane_delete(String planecode) {
		int count = 0;
		getConnection();
		String sql = "delete plane where planecode=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, planecode);
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} // try,catch
		} // try,catch,finally
		return count;
	}

	public int plane_update(PlaneDTO planeDTO) { // 수정
		int count = 0;
		getConnection();
		String sql = "update plane set planecode=?, dday=?, departure=?, arrival=?, departEng=?, arrivEng=?, time1=?, time2=?, price=?, totalseat=? where seq=?";
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, planeDTO.getPlaneCode());
			pstmt.setString(2, planeDTO.getDate());
			pstmt.setString(3, planeDTO.getDeparture());
			pstmt.setString(4, planeDTO.getArrival());
			pstmt.setString(5, planeDTO.getDepartureEng());
			pstmt.setString(6, planeDTO.getArrivalEng());
			pstmt.setString(7, planeDTO.getTime1());
			pstmt.setString(8, planeDTO.getTime2());
			pstmt.setString(9, planeDTO.getPrice());
			pstmt.setString(10, planeDTO.getTotalSeat());
			pstmt.setInt(11, planeDTO.getSeq2());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}

	public List<PlaneDTO> getplaneList() {
		List<PlaneDTO> list = new ArrayList<PlaneDTO>();
		getConnection();
		String sql = "select * from plane order by dday asc";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				PlaneDTO planeDTO = new PlaneDTO();
				planeDTO.setSeq2(rs.getInt("seq"));
				planeDTO.setPlaneCode(rs.getString("planecode"));
				planeDTO.setDate(rs.getString("dday"));
				planeDTO.setDeparture(rs.getString("departure"));
				planeDTO.setArrival(rs.getString("arrival"));
				planeDTO.setDepartureEng(rs.getString("departEng"));
				planeDTO.setArrivalEng(rs.getString("arrivEng"));
				planeDTO.setTime1(rs.getString("time1"));
				planeDTO.setTime2(rs.getString("time2"));
				planeDTO.setPrice(rs.getString("price"));
				planeDTO.setTotalSeat(rs.getString("totalseat"));
				list.add(planeDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			list = null;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} // try,catch
		} // try,catch,finally
		return list;
	}
	
	//book=========================================================================================
	public int getSeq3() {
		int seq3 = 0;
		getConnection();
		String sql = "SELECT seq_book.NEXTVAL from dual";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			seq3 = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} // try,catch
		} // try,catch,finally
		return seq3;
	}// getSeq()

	public int book_insert(BookDTO bookDTO) {
		int count = 0;
		getConnection();
		String sql = "insert into book values(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bookDTO.getSeq3());
			pstmt.setString(2, bookDTO.getPlanecode());
			pstmt.setString(3, bookDTO.getName());
			pstmt.setString(4, bookDTO.getPassportnum());
			pstmt.setString(5, bookDTO.getFirstname());
			pstmt.setString(6, bookDTO.getLastname());
			pstmt.setInt(7, bookDTO.getGender());
			pstmt.setString(8, bookDTO.getAge());
			pstmt.setInt(9, bookDTO.getPeople());
			pstmt.setString(10, bookDTO.getSeat());
			pstmt.setString(11, bookDTO.getId());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}

	public List<BookDTO> getbookList() {
		List<BookDTO> list = new ArrayList<BookDTO>();
		getConnection();
		String sql = "select * from book";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BookDTO bookDTO = new BookDTO();
				bookDTO.setSeq3(rs.getInt("seq"));
				bookDTO.setPlanecode(rs.getString("planecode"));
				bookDTO.setName(rs.getString("name"));
				bookDTO.setPassportnum(rs.getString("passportnum"));
				bookDTO.setFirstname(rs.getString("firstname"));
				bookDTO.setLastname(rs.getString("lastname"));
				bookDTO.setGender(rs.getInt("gender"));
				bookDTO.setAge(rs.getString("age"));
				bookDTO.setPeople(rs.getInt("people"));
				bookDTO.setSeat(rs.getString("seat"));
				bookDTO.setId(rs.getString("id"));
				
				list.add(bookDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			list = null;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} // try,catch
		} // try,catch,finally
		return list;
	}
	
	//payment=========================================================================================	
	public int getSeq4() {
		int seq4 = 0;
		getConnection();
		String sql = "SELECT seq_payment.NEXTVAL from dual";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			seq4 = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} // try,catch
		} // try,catch,finally
		return seq4;
	}// getSeq()
	
	public int payment_insert(PaymentDTO paymentDTO) {
		int count = 0;
		getConnection();
		String sql = "insert into payment values(?,?,?,?,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paymentDTO.getSeq4());
			pstmt.setString(2, paymentDTO.getPay());
			pstmt.setInt(3, paymentDTO.getCharge());
			pstmt.setInt(4, paymentDTO.getCount());
			pstmt.setInt(5, paymentDTO.getOldyoung());
			pstmt.setInt(6, paymentDTO.getPeople());
			pstmt.setString(7, paymentDTO.getSeat());
			pstmt.setInt(8, paymentDTO.getPrice());
			pstmt.setString(9, paymentDTO.getPlanecode());
			pstmt.setString(10, paymentDTO.getId());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}
	
	public List<PaymentDTO> getpaymentList() {
		List<PaymentDTO> list = new ArrayList<PaymentDTO>();
		getConnection();
		String sql = "select * from payment";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				PaymentDTO paymentDTO = new PaymentDTO();
				paymentDTO.setSeq4(rs.getInt("seq"));
				paymentDTO.setPay(rs.getString("pay"));
				paymentDTO.setCharge(rs.getInt("charge"));
				paymentDTO.setCount(rs.getInt("count"));
				paymentDTO.setOldyoung(rs.getInt("oldyoung"));
				paymentDTO.setPeople(rs.getInt("people"));
				paymentDTO.setSeat(rs.getString("seat"));
				paymentDTO.setPrice(rs.getInt("price"));
				paymentDTO.setPlanecode(rs.getString("planecode"));
				paymentDTO.setId(rs.getString("id"));
				list.add(paymentDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			list = null;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} // try,catch
		} // try,catch,finally
		return list;
	}
}

