package com.atguigu.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.atguigu.mybatis.bean.Employee;

public interface EmployeeMapper {
	
	//多条记录封装一个map：Map(Integer，Employee) key就是这条记录的主键，值是封装后的javaBean
	//告诉mybatis封装这个map的时候使用哪个属性作为map的主键
	@MapKey("id")
	public Map<Integer, Employee> getEmpbyLastNameLikeRetrunMap(String lastname);
	
//	@MapKey("lastName")
//	public Map<String, Employee> getEmpbyLastNameLikeRetrunMap(String lastName);
	
	//返回一条记录的map，key就是列名 值就是对应的值
	public Map<String, Object> getEmpByIdReturnMap(Integer id);
	
	public List<Employee> getEmpsByLastNameLike(String lastName);
	
	public Employee getEmpByMap(Map<String, Object> map);
	//命名参数：明确指定封装参数map的key：@Param("id") @Param("lastName")
	public Employee grtEmpByIdAndLastName(@Param("id")Integer id,@Param("lastName")String lastName);
	public Employee getEmpById(Integer id); 
	
	public void addEmp(Employee employee);
	public void updateEmp(Employee employee);
	public void deleteEmpById(Integer id);
}
