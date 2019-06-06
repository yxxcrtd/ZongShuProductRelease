<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>分类<#if (0 == category.categoryId)>添加<#else>修改</#if></title>
		<link type="text/css" rel="styleSheet" href="${request.contextPath}/css/style.css" />
	</head>

	<body>
		<div id="content">
			<div id="header">
				<span class="icon_flag"><#if (0 == category.categoryId)>添加<#else>修改</#if>分类：</span>
			</div>
			
			<form id="categoryForm" action="${request.contextPath}/manage/category/save" method="post">
				
				<div class="label">分类名称：</div>
				<div>
					<@s.formInput "category.categoryName" "class='input'" /><@s.showErrors classOrStyle="red" />
				</div>
				
				<div class="label">分类排序：</div>
				<div>
					<@s.formInput "category.categoryOrderby" "class='input'" /><@s.showErrors classOrStyle="red" />
				</div>
				
				<div id="operation">
					<#if (0 == category.categoryId)>
						<a class="button icon_save" href="javascript:;" id="category_submit">保  存</a>
					<#else>
						<a class="button icon_save" href="javascript:;" id="category_submit">修  改</a>
					</#if>&nbsp;&nbsp;
					<a class="button icon_return" href="javascript:history.back();">返  回</a>
				</div>
				
				<@s.formHiddenInput "category.categoryId" />
				<@s.formHiddenInput "category.categoryParentId" />
				<@s.formHiddenInput "category.categoryParentPath" />
				<@s.formHiddenInput "category.categoryCreateTime" />
			</form>
		</div>
		<script language="javascript" src="${request.contextPath}/js/jquery.js"></script>
		<script type="text/javascript">
		<!--
		$(function() {
			$("#category_submit").on("click", function() {
				$("#categoryForm").submit();
			});
		});
		//-->
		</script>
	</body>
</html>
