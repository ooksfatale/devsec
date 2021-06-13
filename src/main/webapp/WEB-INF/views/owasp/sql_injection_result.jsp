<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
    <!-- HEAD START -->
    <jsp:include page="../includes/head.jsp" flush="false" />
    <!-- //HEAD START -->
</head>
<body>
<div id="wrapper">
    <jsp:include page="../includes/header.jsp" flush="false" />
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Result</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-6">
                <div class="panel ${panel}">
                    <div class="panel-heading">
                        SQL Injection : ${msg}
                    </div>
                    <div class="panel-body">
                        <p>${result}</p>
                    </div>
                    <div class="panel-footer">
                        <p><c:out value="${html}" escapeXml="true" /></p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="../includes/footer.jsp" flush="false" />
</div>

<jsp:include page="../includes/foot.jsp" flush="false" />

<script type="text/javascript">
    $(document).ready(function(){
        alert('${alert}');
    });

</script>
</body>
</html>

