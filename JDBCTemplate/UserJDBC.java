package JDBCTemplate;

import java.sql.SQLException;

public class UserJDBC extends JDBCTemplate{

	public static void main(String[] args) {
		
//		Test tt=new Test();
//		User user=new User();
//		tt.addUser(user);
//		tt.query(username);
	}
	
	@Override
	public int update(String sql, PreparedStatementSetter setter) {
		// TODO Auto-generated method stub
		return super.update(sql, setter);
	}
	
	@Override
	public void query(String sql, PreparedStatementSetter setter, ResultSetHandler handler) throws SQLException {
		// TODO Auto-generated method stub
		super.query(sql, setter, handler);
	}
	
//	public int addUser(User user) throws SQLException {
//		String sql = "INSERT INTO t_user (id,username,password,sex,"
//				+ "id_number,tel,addr) "
//				+ "VALUES(t_user_id_seq.NEXTVAL,?,?,?,?,?,?)";
//		//调用通用的增删改方法
//		return update(sql, new PreparedStatementSetter() {	
//			@Override
//			public void setValues(PreparedStatement pstmt) throws SQLException {
//				pstmt.setString(1, user.getUsername());
//				pstmt.setString(2, user.getPassword());
//				pstmt.setInt(3, user.getSex());
//				pstmt.setString(4, user.getIdNumber());
//				pstmt.setString(5, user.getTel());
//				pstmt.setString(6, user.getAddr());
//			}
//		});
//
//	}
//
///**
//	 * 通过用户名查找用户
//	 * @param username:用户名
//	 * @return 查找到的用户信息  null:没有对应的用户
//	 * @throws ClassNotFoundException
//	 * @throws SQLException
//	 */
//	public List<User> queryUser(String username) throws SQLException {
//		List<User> list = new ArrayList<>();	
//		String sql = "SELECT id,username,password,sex,id_number,"
//				+ "tel,addr FROM t_user WHERE username=?";
//		query(sql, new PreparedStatementSetter() {			
//			@Override
//			public void setValues(PreparedStatement pstmt) throws SQLException {
//				//放置设置占位符的值的代码
//				pstmt.setString(1, username);
//			}
//		}, new ResultSetHandler() {			
//			@Override
//			public void handleRS(ResultSet rs) throws SQLException {
//				//放置结果集处理的代码
//				if(rs.next()) {
//					User user = new User(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
//							rs.getString(6), rs.getString(7));
//					list.add(user);
//				}
//			}
//		});
//		return list;
//	}
}
