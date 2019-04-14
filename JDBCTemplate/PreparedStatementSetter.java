package JDBCTemplate;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 设置占位符值的接口
 * @author air
 *
 */
public interface PreparedStatementSetter {

	public void setValues(PreparedStatement ps) throws SQLException;
}
