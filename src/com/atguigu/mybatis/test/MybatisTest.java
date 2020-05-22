package com.atguigu.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.atguigu.mybatis.bean.Employee;
import com.atguigu.mybatis.dao.EmployeeMapper;

public class MybatisTest {

	@Test
	public void test() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			Employee employee = openSession.selectOne("com.atguigu.mybatis.EmployeeMapper.selectEmp", 1);
			System.out.println(employee);
		}finally {
			openSession.close();
		}
	}
	
	public SqlSessionFactory getSqlSessionFactory() throws IOException {
		// TODO Auto-generated method stub
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Test
	public void test01() throws IOException {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		
		SqlSession openSession = sqlSessionFactory.openSession();
		
		try {
			EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
		
			Employee employee = mapper.getEmpById(1);
			
			System.out.println(employee);
		} finally {
			// TODO: handle finally clause
			openSession.close();
		}
	}

	/**
	 * 测试增删改
	 * @throws IOException 
	 */
	@Test
	public void test03() throws IOException {
		//获取SqlSessionFactory对象
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		//获取到的SqlSession不会自动提交数据
		SqlSession openSession = sqlSessionFactory.openSession();
		
		//自动提交数据
//		SqlSession openSession = sqlSessionFactory.openSession(true);
		
		try {
			EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
			//添加数据
			Employee employee = new Employee(null, "jer", "jer@atguigu.com", "1");
			mapper.addEmp(employee);
			System.out.println(employee.getId());
			
			//更新数据
//			Employee employee = new Employee(3, "tutu", "tutu@atguigu.com", "0");
//			mapper.updateEmp(employee);
			
			//删除数据
//			mapper.deleteEmpById(3);
			//手动提交数据
			openSession.commit();
		} finally {
			// TODO: handle finally clause
			openSession.close();
		}
	}
	
	@Test
	public void test04() throws IOException {
		//获取SqlSessionFactory对象
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		//获取到的SqlSession不会自动提交数据
		SqlSession openSession = sqlSessionFactory.openSession();
		
		try {
			EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
			
//			Employee employee = mapper.grtEmpByIdAndLastName(1, "tom");
//			
//			//Map
//			Map<String, Object> map = new HashMap<String, Object>();
//			map.put("id", 1);
//			map.put("lastName", "Tom");
////			Employee employee = mapper.getEmpByMap(map);
//			
//			System.out.println(employee);
			
//			List<Employee> list = mapper.getEmpsByLastNameLike("%e%");
//			for (Employee employee : list) {
//				System.out.println(employee);
//			}
			
			Map<String, Object> map = mapper.getEmpByIdReturnMap(1);
			System.out.println(map);
			
			Map<Integer, Employee> map2 = mapper.getEmpbyLastNameLikeRetrunMap("%r%");
			System.out.println(map2);
			
//			Map<String, Employee> map2 = mapper.getEmpbyLastNameLikeRetrunMap("%r%");
//			System.out.println(map2);
			
		} finally {
			// TODO: handle finally clause
			openSession.close();
		}
	}
}
