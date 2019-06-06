<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>资源<#if (0 == resource.resourceId)>添加<#else>修改</#if></title>
		<link type="text/css" rel="styleSheet" href="${request.contextPath}/css/style.css" />
	</head>

	<body>
		<div id="content">
			<div id="header">
				<span class="icon_flag"><#if (0 == resource.resourceId)>添加<#else>修改</#if>资源：</span>
			</div>
			
			<form id="resourceForm" action="${request.contextPath}/manage/resource/save" method="post">
				<table width="700px" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td>
							<div class="label">资源分类：</div>
							<div>
								<@s.formSingleSelect "resource.category.categoryId" categoryMap "class='selectStyle'" />
							</div>
						</td>
						<td>
							<div class="label">资源名称：</div>
							<div>
								<@s.formInput "resource.resourceName" "class='input'" />
								<span class="red" id="resourceNameTips"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td>
							<div class="label">资源作者：</div>
							<div>
								<@s.formInput "resource.resourceAuthor" "class='input'" />
							</div>
						</td>
						<td>
							<div class="label">资源出版时间：（格式为：2012-01-01）</div>
							<div>
								<@s.formInput "resource.resourcePublishDate" "class='input'" />
							</div>
						</td>
					</tr>
					<tr>
						<td>
							<div class="label">资源ISBN：</div>
							<div>
								<@s.formInput "resource.resourceISBN" "class='input'" />
							</div>
						</td>
						<td>
							<div class="label">资源价格：</div>
							<div>
								<@s.formInput "resource.resourcePrice" "class='input'" />
							</div>
						</td>
					</tr>
					<tr>
						<td>
							<div class="label">资源出版社：</div>
							<div>
								<@s.formInput "resource.resourcePublisher" "class='input'" />
							</div>
						</td>
						<td>
							<div class="label">资源版次：</div>
							<div>
								<@s.formInput "resource.resourceEdition" "class='input'" />
							</div>
						</td>
					</tr>
					<tr>
						<td>
							<div class="label">资源页数：</div>
							<div>
								<@s.formInput "resource.resourcePage" "class='input'" />
							</div>
						</td>
						<td>
							<div class="label">资源装帧：</div>
							<div>
								<@s.formInput "resource.resourceFrame" "class='input'" />
							</div>
						</td>
					</tr>
					<tr>
						<td>
							<div class="label">资源开本：</div>
							<div>
								<@s.formInput "resource.resourceFormat" "class='input'" />
							</div>
						</td>
						<td>
							<div class="label">资源印张：</div>
							<div>
								<@s.formInput "resource.resourceSheet" "class='input'" />
							</div>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<div class="label">资源附件：</div>
							<div>
								<input type="file" class="input" style="width: 652px;" name="resourceFile" />
							</div>
						</td>
					</tr>
				</table>
				
				
				<div id="operation">
					<#if (0 == resource.resourceId)>
						<a class="button icon_save" href="javascript:;" id="resource_submit">保  存</a>
					<#else>
						<a class="button icon_save" href="javascript:;" id="resource_submit">修  改</a>
					</#if>&nbsp;&nbsp;
					<a class="button icon_return" href="javascript:history.back();">返  回</a>
				</div>
				
				<@s.formHiddenInput "resource.resourceId" />
				<@s.formHiddenInput "resource.resourceCreateTime" />
			</form>
		</div>
		<script language="javascript" src="${request.contextPath}/js/jquery.js"></script>
		<script type="text/javascript">
		<!--
		$(function() {
			// 选中
			$(".selectStyle").val("${resource.categoryId}");
			
			// 提交
			$("#resource_submit").on("click", function() {
				$("#resourceForm").submit();
			});
		});
		//-->
		</script>
	</body>
</html>
