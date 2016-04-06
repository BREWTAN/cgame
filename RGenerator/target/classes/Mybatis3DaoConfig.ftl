<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
	xmlns:jdbc="http://www.springframework.org/schema/jdbc"
	xmlns:context="http://www.springframework.org/schema/context" 
	xmlns:tx="http://www.springframework.org/schema/tx"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
						http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx.xsd
						http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd
						http://www.springframework.org/schema/jdbc http://www.springframework.org/schema/jdbc/spring-jdbc.xsd">

	<#list clazzinfos as clazzinfo>
	<bean id="${clazzinfo.domainObject}Mapper" class="org.mybatis.spring.mapper.MapperFactoryBean">
		<property name="mapperInterface" value="${clazzinfo.packageName}.mapper.${clazzinfo.domainClass}Mapper" />
		<property name="sqlSessionFactory" ref="sqlSessionFactory" />
	</bean>
	 <bean id="${clazzinfo.domainObject?lower_case}Dao" class="${clazzinfo.packageName}.dao.${clazzinfo.domainClass}Dao" >
 		<property name="mapper" ref="${clazzinfo.domainObject}Mapper" />
 		<property name="sqlSessionFactory" ref="sqlSessionFactory" />
 	</bean>
	</#list>
	
</beans>
