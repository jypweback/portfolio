var boardMain = {

    formInit : function(){
        this.setDataBind();
    },
    setDataBind : function(){
        $('#dataTable').dataTable({
            bPaginate : true,
            processing: true,
            serverSide: false,
            lengthMenu : [10,20,50],
            order: [[ 0, "desc" ]],
            ajax : {
                "url":"/api/v1/boards",
                "type":"GET",
                "data": function (d) {
                     d.size = 100;
                },
                "dataSrc": function(json){
                    return json.content;
                }
            },
            columns : [
                {"data": "rowNumber"},
                {"data": "title"},
                {"data": "creatorId"},
                {"data": "createDatetime"}
            ]
        });
    }
}

$(document).ready(function() {
	boardMain.formInit();
});
