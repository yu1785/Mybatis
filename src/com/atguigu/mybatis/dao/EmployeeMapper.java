package com.atguigu.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.atguigu.mybatis.bean.Employee;

public interface EmployeeMapper {
	
	//������¼��װһ��map��Map(Integer��Employee) key����������¼��������ֵ�Ƿ�װ���javaBean
	//����mybatis��װ���map��ʱ��ʹ���ĸ�������Ϊmap������
	@MapKey("id")
	public Map<Integer, Employee> getEmpbyLastNameLikeRetrunMap(String lastname);
	
//	@MapKey("lastName")
//	public Map<String, Employee> getEmpbyLastNameLikeRetrunMap(String lastName);
	
	//����һ����¼��map��key�������� ֵ���Ƕ�Ӧ��ֵ
	public Map<String, Object> getEmpByIdReturnMap(Integer id);
	
	public List<Employee> getEmpsByLastNameLike(String lastName);
	
	public Employee getEmpByMap(Map<String, Object> map);
	//������������ȷָ����װ����map��key��@Param("id") @Param("lastName")
	public Employee grtEmpByIdAndLastName(@Param("id")Integer id,@Param("lastName")String lastName);
	public Employee getEmpById(Integer id); 
	
	public void addEmp(Employee employee);
	public void updateEmp(Employee employee);
	public void deleteEmpById(Integer id);
}
