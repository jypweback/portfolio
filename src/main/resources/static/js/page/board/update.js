var boardMain = {
    tagArrays : [],
    formInit : function(){
        this.setDataBind();
        this.setEvent();
    },

    setDataBind : function(){
        $("input[name=tags]").each(function(){
            boardMain.tagArrays.push($(this).data("text"));
            $('#txtTags').tagsinput('add', $(this).data("text"));
        });
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

        /** 게시판 취소 */
        $("#btnCancel").on("click", function(){
            $(location).attr("href", "/boards/" + $("#hdnBoardId").val());
        });

        /** 게시판 수정 */
        $("#btnSave").on("click", function(){

            var data = $('form[id="boardForm"]').serializeObject();
            if($.trim(data.title) == ""){
                alert("제목을 입력해주세요.");
                return false;
            }

            if($.trim(data.boardText) == ""){
                alert("내용을 입력해주세요.");
                return false;
            }

            var boardDto = new Object();
            boardDto.title = data.title;
            boardDto.boardText = data.boardText;

            var tagDtos = new Array();
            $(boardMain.tagArrays).each(function(){
                var tagDto = new Object();
                tagDto.tagText = this;
                tagDtos.push(tagDto);
            });

            var boardReqDto = new Object();
            boardReqDto.boardDto = boardDto;
            boardReqDto.tagDtos = tagDtos;

            $.ajax({
                url : "/api/v1/boards/" + $("#hdnBoardId").val(),
                data : JSON.stringify(boardReqDto),
                type : "PUT",
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

        $('#txtTags').on('itemAdded', function(event) {
            boardMain.tagArrays.push(event.item);
        });

        $('#txtTags').on('itemRemoved', function(event) {
            $(boardMain.tagArrays).each(function(index, tag){
                if(tag == event.item){
                    boardMain.tagArrays.splice(index, 1);
                }
            });
        });
    }
}


$(document).ready(function() {
	boardMain.formInit();
});
