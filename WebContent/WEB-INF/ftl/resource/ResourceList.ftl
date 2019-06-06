<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>资源管理</title>
		<link type="text/css" rel="styleSheet" href="${request.contextPath}/css/style.css" />
	</head>

	<body>
		<div id="content">
			<div id="new">
				<a class="button icon_add" href="<@s.url '${request.contextPath}/manage/resource/add' />">新建资源</a>
				<span id="tips"><#if tips??>${tips}</#if></span>
			</div>
			
			<div id="header">
				<span class="icon_flag">资源信息列表</span>
			</div>
		
			<#--
			<input type="text" placeholder="请输入查询的资源名称" />
			<a class="button icon_query" href="<@s.url '${request.contextPath}/manage/resource/add' />">查  询</a>
			-->	
			
	  		<table width="100%" border="0" cellspacing="0" cellpadding="0" id="classTable">
	  			<tr id="thead">
					<td width="10%">资源ID</td>
					<td width="10%">资源分类</td>
					<td width="20%">资源名称</td>
					<td width="10%">资源ISBN</td>
					<td width="10%">资源作者</td>
					<td width="10%">资源价格</td>
					<td width="15%">操作</td>
  				</tr>
				<#if (0 < resourceList?size)>
					<#list resourceList as r>
						<tr bgColor="#<#if (0 == r_index % 2)>F9F9F9<#else>FFFFFF</#if>" onMouseOver="changeBgColor(this, '#ECECEC');" onMouseOut="changeBgColor(this, '#<#if (0 == r_index % 2)>F9F9F9<#else>FFFFFF</#if>');">
							<td>${r.resourceId}</td>
							<td>${r.category.categoryName}</td>
							<td class="left">${r.resourceName}</td>
							<td>${r.resourceISBN}</td>
							<td>${r.resourceAuthor}</td>
							<td>${r.resourcePrice?string.currency}</td>
							<td>
								<a href="${request.contextPath}/manage/resource/${r.resourceId}">编辑</a>&nbsp;&nbsp;
								<a href="${request.contextPath}/manage/resource/del/${r.resourceId}" onClick="return confirm('确定删除吗？');">删除</a>
							</td>
						</tr>
					</#list>
				<#else>
					<tr bgColor="F9F9F9">
						<td colspan="8">没有数据！</td>
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
