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
                <h1 class="page-header" style="text-align: center">Search URL</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="panel panel-default">

                    <div class="panel-heading">
                        <div class="row">
                            <div class="col-xs-3">
                                <i class="fa fa-search fa-5x"></i>
                            </div>
                            <div class="col-xs-9 text-right">
                                <div class="huge">DevSec</div>
                                <div>XSS</div>
                            </div>
                        </div>
                    </div>
                    <form id="frm" action="/xss" method="post">
                        <div class="panel-body">
                            <div class="col-sm-12">
                                <div class="input-group">
                                    <input type="url" class="form-control" id="scanUrl" name="scanUrl" value="" placeholder="Search or scan a URL">
                                    <span class="input-group-btn">
                                        <button class="btn btn-warning" type="button" onclick="fnSearch()" >
                                            <i class="fa fa-search"></i>
                                        </button>
                                    </span>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="../includes/footer.jsp" flush="false" />
</div>

<jsp:include page="../includes/foot.jsp" flush="false" />

<script type="text/javascript">
    $(document).ready(function(){

    });

    function fnSearch(){
        if($("#scanUrl").val() == '') {
            alert('URL을 입력해주세요.');
        }else{

            $.ajax({
               type: 'post',
                url: '/xss',
                data : { scanUrl : 'test'},
                dataType:'text',
                success : function(data){
                   alert(data);
                },
                error: function(jqXHR, textStatus, errorThrown) {
                    alert("ERROR : " + textStatus + " : " + errorThrown);
                }
            });

            /*$("#frm").submit();*/
        }
    }

</script>
</body>
</html>

