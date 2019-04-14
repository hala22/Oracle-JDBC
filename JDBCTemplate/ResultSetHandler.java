package JDBCTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 处理查询结果集的接口
 * @author air
 *
 */
public interface ResultSetHandler {
	
	
	public void handleRS(ResultSet rs) throws SQLException;

}
