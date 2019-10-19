var boardMain = {

    formInit : function(){
        //this.setDataBind();
        this.setEvent();
    },

    setEvent : function(){

        /** 댓글추가 */
        $("#btnSaveTag").on("click", function(){
            var data = $('form[id="tagForm"]').serializeObject();
            if($.trim(data.replyText) == ""){
                alert("코멘트를 입력해주세요.");
                return false;
            }

            var replyDto = new Object();
            replyDto.replyText = data.replyText;
            replyDto.creatorId = data.creatorId;

            $.ajax({
                url : "/api/v1/boards/" + $("#hdnBoardId").val() + "/replys",
                data : JSON.stringify(replyDto),
                type : "POST",
                async : true,
                dataType : "json",
                contentType : "application/json;charset=UTF-8"
            }).done(function(data, status, jqXHR){
                $(location).attr("href", "/boards/"+ $("#hdnBoardId").val());
            }).fail(function(data, status, jqXHR){
                var errorMessage = JSON.parse(data.responseText);
                alert(errorMessage.message);
            });
        });

        /** 게시판 삭제 */
        $("#btnRemove").on("click", function(){
            $.ajax({
                url : "/api/v1/boards/" + $("#hdnBoardId").val(),
                type : "DELETE",
                async : true,
            }).done(function(data, status, jqXHR){
                $(location).attr("href", "/boards");
            }).fail(function(data, status, jqXHR){
                var errorMessage = JSON.parse(data.responseText);
                alert(errorMessage.message);
            });
        });

        /** 게시판 삭제 */
        $("button[name='replyRemove']").on("click", function(){
            if( !confirm("삭제 하시겠습니까?")){
                return false;
            }

            $.ajax({
                url : "/api/v1/boards/" + $("#hdnBoardId").val() + "/replys/" + this.value,
                type : "DELETE",
                async : true,
            }).done(function(data, status, jqXHR){
                $(location).attr("href", "/boards/" + $("#hdnBoardId").val());
            }).fail(function(data, status, jqXHR){
                var errorMessage = JSON.parse(data.responseText);
                alert(errorMessage.message);
            });
        });

        /** 게시판 수정 */
        $("#btnUpdate").on("click", function(){
            $(location).attr("href", "/boards/" + $("#hdnBoardId").val() +"/form");
        });
    }
}


$(document).ready(function() {
	boardMain.formInit();
});
