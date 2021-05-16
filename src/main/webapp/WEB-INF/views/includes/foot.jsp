<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- summernote editor -->
<script src="/summernote/summernote-lite.js"></script>
<script src="/summernote/summernote-ko-KR.js"></script>

<script type="text/javascript">
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
            responsive: true
        });
    });
    $(".sidebar-nav")
        .attr("class","sidebar-nav navbar-collapse collapse")
        .attr("aria-expanded",'false')
        .attr("style","height:1px");

    function summernote(){
        $("#summernote").summernote({
            height : 400,
            minHeight : null,
            maxHeight : null,
            focus : true,
            lang : "ko-KR"
        });
    }

</script>