<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>分类管理</title>
		<link type="text/css" rel="styleSheet" href="${request.contextPath}/css/style.css" />
	</head>

	<body>
		<div id="content">
			<div id="new">
				<a class="button icon_add" href="<@s.url '${request.contextPath}/manage/category/add' />">新建分类</a>
				<span id="tips"><#if tips??>${tips}</#if></span>
			</div>
			
			<div id="header">
				<span class="icon_flag">分类信息列表</span>
			</div>
		
			<#--
			<input type="text" placeholder="请输入查询的分类名称" />
			<a class="button icon_query" href="<@s.url '${request.contextPath}/manage/category/add' />">查  询</a>
			-->	
			
	  		<table width="100%" border="0" cellspacing="0" cellpadding="0" id="classTable">
	  			<tr id="thead">
					<td width="10%">分类ID</td>
					<td width="40%">分类名称</td>
					<td width="15%">分类排序</td>
					<td width="20%">分类创建时间</td>
					<td width="15%">操作</td>
  				</tr>
				<#if (0 < categoryList?size)>
					<#list categoryList as c>
						<tr bgColor="#<#if (0 == c_index % 2)>F9F9F9<#else>FFFFFF</#if>" onMouseOver="changeBgColor(this, '#ECECEC');" onMouseOut="changeBgColor(this, '#<#if (0 == c_index % 2)>F9F9F9<#else>FFFFFF</#if>');">
							<td>
								${c.categoryId}
							</td>
							<td>
								${c.categoryName}
							</td>
							<td>
								${c.categoryOrderby}
							</td>
							<td>
								${c.categoryCreateTime}
							</td>
							<td>
								<a href="${request.contextPath}/manage/category/sub/${c.categoryId}">子分类</a>&nbsp;&nbsp;
								<a href="${request.contextPath}/manage/category/${c.categoryId}">编辑</a>&nbsp;&nbsp;
								<a href="${request.contextPath}/manage/category/del/${c.categoryId}" onClick="return confirm('确定删除吗？');">删除</a>
							</td>
						</tr>
					</#list>
				<#else>
					<tr bgColor="F9F9F9">
						<td colspan="5">没有数据！</td>
					</tr>
				</#if>
	  		</table>
	  		<div id="pageNav">
	  			<#include "Pager.ftl" />
	  		</div>
		</div>
		
		<script language="javascript" src="${request.contextPath}/js/jquery.js"></script>
		<script language="javascript" src="${request.contextPath}/js/public.js"></script>
	</body>
</html>
