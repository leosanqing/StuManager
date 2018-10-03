package cn.swu.stormleo.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import cn.swu.stormleo.dao.UserDao;
import cn.swu.stormleo.utils.JDBCUtil;

public class UserDaoImpl implements UserDao
{
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	@Override
	public boolean login(String userName,String password)
	{
		
			try
			{
				// 1.建立连接
				 conn=(Connection) JDBCUtil.getConn();
				String sql="select * from user where name=? and password=?";
				
				// 2.创建ps对象
				 ps=(PreparedStatement) conn.prepareStatement(sql);
				ps.setString(1, userName);
				ps.setString(2, password);
				
				// 返回结果集
				 rs=ps.executeQuery();
				
				return rs.next();
				
			} catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				JDBCUtil.release(conn, ps, rs);
			}
			
		return false;
	}

}
