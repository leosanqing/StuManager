package cn.swu.stormleo.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import cn.swu.stormleo.dao.StuDao;
import cn.swu.stormleo.domain.Student;
import cn.swu.stormleo.utils.JDBCUtil;

public class StuDaoImpl implements StuDao
{
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	//创建集合对象
	List<Student> list = new ArrayList<Student>(); 
	
	
	@Override
	public List<Student> findAll()
	{
		try
		{
			conn=(Connection) JDBCUtil.getConn();
			
			// 查询
			String sql="select * from t_stu";
			ps=(PreparedStatement) conn.prepareStatement(sql);
			rs=ps.executeQuery();
			
			
			
			//
			while(rs.next())
			{
				Student stu = new Student();
				
				
				stu.setId(rs.getInt("id"));
				stu.setAge(rs.getInt("age"));
				stu.setName(rs.getString("name"));
				stu.setGender(rs.getString("gender"));
				stu.setAddress(rs.getString("address"));
				
				list.add(stu);
			}
			
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
}
