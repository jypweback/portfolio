var boardMain = {

    formInit : function(){
        this.setDataBind();
        this.setEvent();
    },
    setDataBind : function(){
        $('#dataTable').dataTable({
            bPaginate : true,
            processing: true,
            serverSide: false,
            //pagingType : false,
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
                {
                    "data": "createDatetime",
                    "render": function (data) {
                        var date = new Date(data);
                        var month = date.getMonth() + 1;
                        return date.getFullYear() + "-" + (month.toString().length > 1 ? month : "0" + month) + "-" + date.getDate();
                    }
                }
            ]
        });
    },

    setEvent : function(){
        var table = $('#dataTable').DataTable();
        $('#dataTable tbody').on('click', 'tr', function () {
            var row = table.row( this ).data();
            $(location).attr("href", "/boards/"+ row.id);
        });

        $("#btnSave").on("click", function(){
            $(location).attr("href", "/boards/create");
        });
    }

}

$(document).ready(function() {
	boardMain.formInit();
});
