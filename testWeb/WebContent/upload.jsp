<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>

<link rel="stylesheet" href="./css/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="./css/bootstrap-theme.min.css">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="./js/jquery-1.8.2.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="./js/bootstrap.min.js"></script>
<title>Struts2 Showcase - Fileupload sample</title>
</head>

<body>
	<div class="page-header">
		<h1>Fileupload sample</h1>
	</div>

	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">

				<s:actionerror cssClass="alert alert-error" />
				<s:fielderror cssClass="alert alert-error" />
				<s:form action="doUpload" method="POST" enctype="multipart/form-data" >
					<s:file name="upload" label="File" />
					<s:textfield name="caption" label="Caption" />
					<s:submit value="submit" cssClass="btn btn-primary" />
				</s:form>
			</div>
		</div>
	</div>
</body>
</html>