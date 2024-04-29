package shop.dao;

import java.security.spec.RSAKeyGenParameterSpec;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shop.dto.Order;
import shop.dto.Product;

public class OrderRepository extends JDBConnection {
	
	/**
	 * 주문 등록
	 * @param user
	 * @return
	 */
	public int insert(Order order) {
		int result = 0;
		
		String sql = " INSERT INTO ORDER "
				   + " (SHIP_NAME, ZIP_CODE, COUNTRY, ADDRESS, "
				   + " DATE, ORDER_PW, USER_ID, TOTAL_PRICE, PHONE) "
				   + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ";
				
		try {
			psmt = con.prepareStatement(sql);
			
			psmt.setString( 1, order.getShipName() );
			psmt.setString( 2, order.getZipCode() );
			psmt.setString( 3, order.getCountry() );
			psmt.setString( 4, order.getAddress() );
			psmt.setString( 5, order.getDate() );
			psmt.setString( 6, order.getOrderPw() );
			psmt.setString( 7, order.getUserId() );
			psmt.setInt( 8, order.getTotalPrice() );
			psmt.setString( 9, order.getPhone() );
			
			result = psmt.executeUpdate();
			
			
		} catch (SQLException e) {
			System.err.println("주문 등록 시, 예외 발생");
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 최근 등록한 orderNo 
	 * @return
	 */
	public int lastOrderNo() {
		int result = 0;
		
		String sql = " SELECT ORDER_NO FROM `ORDER` "
				   + " ORDER BY DATE DESC LIMIT 1 ";
		
		try {
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				result = rs.getInt("ORDER_NO");
			}
			
		} catch (SQLException e) {
			System.err.println("최근 주문번호 조회 시, 예외 발생");
			e.printStackTrace();
		}
		return result;
	}

	
	/**
	 * 주문 내역 조회 - 회원
	 * @param userId
	 * @return
	 */
	public List<Product> list(String userId) {
		
		List<Product> boardList = new ArrayList<Product>();
		
		// SQL 수정 필요(JOIN)
		String sql = " SELECT * FROM ORDER "
				   + " WHERE USER_ID = ? ";
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				Order order = new Order();
				Product product = new Product();
				
				// 알맞은 것으로 적용
				order.setOrderNo( rs.getInt("orderNo") );
				product.setName( rs.getString("name") );
				product.setUnitPrice( rs.getInt("price") );
				product.setQuantity( rs.getInt("quantity") );
				
			}
			
		} catch (SQLException e) {
			System.err.println("회원 주문 내역 조회 시, 예외 발생");
			e.printStackTrace();
		}
		return boardList;
	}
	
	/**
	 * 주문 내역 조회 - 비회원
	 * @param phone
	 * @param orderPw
	 * @return
	 */
	public List<Product> list(String phone, String orderPw) {
		
		
	}
	
}






























