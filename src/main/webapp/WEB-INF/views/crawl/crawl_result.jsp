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
            <div class="col-lg-4">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        input
                    </div>
                    <div class="panel-body">
                        <p>${input}</p>
                    </div>
                    <div class="panel-footer">
                        Panel Footer
                    </div>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="panel panel-success">
                    <div class="panel-heading">
                        text
                    </div>
                    <div class="panel-body">
                        <p>${text}</p>
                    </div>
                    <div class="panel-footer">
                        Panel Footer
                    </div>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        head
                    </div>
                    <div class="panel-body">
                        <p>${head}</p>
                    </div>
                    <div class="panel-footer">
                        Panel Footer
                    </div>
                </div>
            </div>
            <div class="col-lg-12">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        head
                    </div>
                    <div class="panel-body">
                        <p>${html}</p>
                            <%--<iframe src="${URL}" ></iframe>--%>
                    </div>
                    <div class="panel-footer">
                        Panel Footer
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

        $('input[name=userid]').attr('value',"dongyang123");
        $('input[name=userpassword]').attr('value',"mirae123");
        window.open('${URL}/target.html');
    });


</script>
</body>
</html>

