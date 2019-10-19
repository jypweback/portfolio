var boardMain = {
    tagArrays : [],
    formInit : function(){
        this.setEvent();
    },

    setEvent : function(){
        /** 게시판 취소 */
        $("#btnCancel").on("click", function(){
            $(location).attr("href", "/boards");
        });

        /** 게시판 등록 */
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
                url : "/api/v1/boards",
                data : JSON.stringify(boardReqDto),
                type : "POST",
                async : true,
                dataType : "json",
                contentType : "application/json;charset=UTF-8"
            }).done(function(data, status, jqXHR){
                $(location).attr("href", "/boards");
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
